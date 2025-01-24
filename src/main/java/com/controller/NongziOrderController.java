
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 农资订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/nongziOrder")
public class NongziOrderController {
    private static final Logger logger = LoggerFactory.getLogger(NongziOrderController.class);

    private static final String TABLE_NAME = "nongziOrder";

    @Autowired
    private NongziOrderService nongziOrderService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AddressService addressService;//收货地址
    @Autowired
    private CartService cartService;//购物车
    @Autowired
    private ChanpinService chanpinService;//农产品
    @Autowired
    private ChanpinCollectionService chanpinCollectionService;//农产品收藏
    @Autowired
    private ChanpinCommentbackService chanpinCommentbackService;//农产品评价
    @Autowired
    private ChanpinOrderService chanpinOrderService;//农产品订单
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private JishuService jishuService;//农业技术
    @Autowired
    private NongziService nongziService;//农资
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private ZhongzhihuService zhongzhihuService;//种植户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("种植户".equals(role))
            params.put("zhongzhihuId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = nongziOrderService.queryPage(params);

        //字典表数据转换
        List<NongziOrderView> list =(List<NongziOrderView>)page.getList();
        for(NongziOrderView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        NongziOrderEntity nongziOrder = nongziOrderService.selectById(id);
        if(nongziOrder !=null){
            //entity转view
            NongziOrderView view = new NongziOrderView();
            BeanUtils.copyProperties( nongziOrder , view );//把实体数据重构到view中
            //级联表 农资
            //级联表
            NongziEntity nongzi = nongziService.selectById(nongziOrder.getNongziId());
            if(nongzi != null){
            BeanUtils.copyProperties( nongzi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "zhongzhihuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setNongziId(nongzi.getId());
            }
            //级联表 种植户
            //级联表
            ZhongzhihuEntity zhongzhihu = zhongzhihuService.selectById(nongziOrder.getZhongzhihuId());
            if(zhongzhihu != null){
            BeanUtils.copyProperties( zhongzhihu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "zhongzhihuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setZhongzhihuId(zhongzhihu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody NongziOrderEntity nongziOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,nongziOrder:{}",this.getClass().getName(),nongziOrder.toString());
        NongziEntity nongziEntity = nongziService.selectById(nongziOrder.getNongziId());
        String role = String.valueOf(request.getSession().getAttribute("role"));
        Integer buyNumber = nongziOrder.getBuyNumber();

        if(false)
            return R.error(511,"永远不会进入");
        else if("种植户".equals(role))
            nongziOrder.setZhongzhihuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        nongziOrder.setNongziOrderTruePrice(nongziEntity.getNongziNewMoney()*buyNumber);
        nongziEntity.setNongziKucunNumber(nongziEntity.getNongziKucunNumber()-buyNumber);
        nongziOrder.setCreateTime(new Date());
        nongziOrder.setInsertTime(new Date());
        nongziOrderService.insert(nongziOrder);
        nongziService.updateById(nongziEntity);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody NongziOrderEntity nongziOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,nongziOrder:{}",this.getClass().getName(),nongziOrder.toString());
        NongziOrderEntity oldNongziOrderEntity = nongziOrderService.selectById(nongziOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("种植户".equals(role))
//            nongziOrder.setZhongzhihuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            nongziOrderService.updateById(nongziOrder);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<NongziOrderEntity> oldNongziOrderList =nongziOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        nongziOrderService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<NongziOrderEntity> nongziOrderList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            NongziOrderEntity nongziOrderEntity = new NongziOrderEntity();
//                            nongziOrderEntity.setNongziOrderUuidNumber(data.get(0));                    //订单编号 要改的
//                            nongziOrderEntity.setNongziId(Integer.valueOf(data.get(0)));   //农资 要改的
//                            nongziOrderEntity.setZhongzhihuId(Integer.valueOf(data.get(0)));   //种植户 要改的
//                            nongziOrderEntity.setBuyNumber(Integer.valueOf(data.get(0)));   //购买数量 要改的
//                            nongziOrderEntity.setNongziOrderDizhi(data.get(0));                    //地址 要改的
//                            nongziOrderEntity.setNongziOrderTruePrice(data.get(0));                    //实付价格 要改的
//                            nongziOrderEntity.setNongziOrderCourierName(data.get(0));                    //快递公司 要改的
//                            nongziOrderEntity.setNongziOrderCourierNumber(data.get(0));                    //快递单号 要改的
//                            nongziOrderEntity.setNongziOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            nongziOrderEntity.setInsertTime(date);//时间
//                            nongziOrderEntity.setCreateTime(date);//时间
                            nongziOrderList.add(nongziOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单编号
                                if(seachFields.containsKey("nongziOrderUuidNumber")){
                                    List<String> nongziOrderUuidNumber = seachFields.get("nongziOrderUuidNumber");
                                    nongziOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> nongziOrderUuidNumber = new ArrayList<>();
                                    nongziOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("nongziOrderUuidNumber",nongziOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单编号
                        List<NongziOrderEntity> nongziOrderEntities_nongziOrderUuidNumber = nongziOrderService.selectList(new EntityWrapper<NongziOrderEntity>().in("nongzi_order_uuid_number", seachFields.get("nongziOrderUuidNumber")));
                        if(nongziOrderEntities_nongziOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(NongziOrderEntity s:nongziOrderEntities_nongziOrderUuidNumber){
                                repeatFields.add(s.getNongziOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        nongziOrderService.insertBatch(nongziOrderList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = nongziOrderService.queryPage(params);

        //字典表数据转换
        List<NongziOrderView> list =(List<NongziOrderView>)page.getList();
        for(NongziOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        NongziOrderEntity nongziOrder = nongziOrderService.selectById(id);
            if(nongziOrder !=null){


                //entity转view
                NongziOrderView view = new NongziOrderView();
                BeanUtils.copyProperties( nongziOrder , view );//把实体数据重构到view中

                //级联表
                    NongziEntity nongzi = nongziService.selectById(nongziOrder.getNongziId());
                if(nongzi != null){
                    BeanUtils.copyProperties( nongzi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setNongziId(nongzi.getId());
                }
                //级联表
                    ZhongzhihuEntity zhongzhihu = zhongzhihuService.selectById(nongziOrder.getZhongzhihuId());
                if(zhongzhihu != null){
                    BeanUtils.copyProperties( zhongzhihu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setZhongzhihuId(zhongzhihu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody NongziOrderEntity nongziOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,nongziOrder:{}",this.getClass().getName(),nongziOrder.toString());
            NongziEntity nongziEntity = nongziService.selectById(nongziOrder.getNongziId());
            if(nongziEntity == null){
                return R.error(511,"查不到该农资");
            }
            // Double nongziNewMoney = nongziEntity.getNongziNewMoney();

            if(false){
            }
            else if(nongziEntity.getNongziNewMoney() == null){
                return R.error(511,"金额不能为空");
            }
            else if((nongziEntity.getNongziKucunNumber() -nongziOrder.getBuyNumber())<0){
                return R.error(511,"购买数量不能大于库存数量");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            double balance = yonghuEntity.getNewMoney() - nongziEntity.getNongziNewMoney()*nongziOrder.getBuyNumber();//余额
            if(balance<0)
                return R.error(511,"余额不够支付");
            nongziOrder.setNongziOrderTypes(101); //设置订单状态为已支付
            nongziOrder.setNongziOrderTruePrice(nongziEntity.getNongziNewMoney()*nongziOrder.getBuyNumber()); //设置实付价格
//            nongziOrder.setYonghuId(userId); //设置订单支付人id
            nongziOrder.setNongziOrderUuidNumber(String.valueOf(new Date().getTime()));
            nongziOrder.setInsertTime(new Date());
            nongziOrder.setCreateTime(new Date());
                nongziEntity.setNongziKucunNumber( nongziEntity.getNongziKucunNumber() -nongziOrder.getBuyNumber());
                nongziService.updateById(nongziEntity);
                nongziOrderService.insert(nongziOrder);//新增订单
            //更新第一注册表
            yonghuEntity.setNewMoney(balance);//设置金额
            yonghuService.updateById(yonghuEntity);


            return R.ok();
    }
    /**
     * 添加订单
     */
    @RequestMapping("/order")
    public R add(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("order方法:,,Controller:{},,params:{}",this.getClass().getName(),params.toString());
        String nongziOrderUuidNumber = String.valueOf(new Date().getTime());

        //获取当前登录用户的id
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        Integer addressId = Integer.valueOf(String.valueOf(params.get("addressId")));

            Integer zhongzhihuId = Integer.valueOf(String.valueOf(params.get("zhongzhihuId")));//种植户
            String nongziOrderDizhi = String.valueOf(params.get("nongziOrderDizhi"));//地址

        String data = String.valueOf(params.get("nongzis"));
        JSONArray jsonArray = JSON.parseArray(data);
        List<Map> nongzis = JSON.parseObject(jsonArray.toString(), List.class);

        //获取当前登录用户的个人信息
        YonghuEntity yonghuEntity = yonghuService.selectById(zhongzhihuId);

        //当前订单表
        List<NongziOrderEntity> nongziOrderList = new ArrayList<>();
        //商品表
        List<NongziEntity> nongziList = new ArrayList<>();
        //购物车ids
        List<Integer> cartIds = new ArrayList<>();

        BigDecimal zhekou = new BigDecimal(1.0);

        //循环取出需要的数据
        for (Map<String, Object> map : nongzis) {
           //取值
            Integer nongziId = Integer.valueOf(String.valueOf(map.get("nongziId")));//商品id
            Integer buyNumber = Integer.valueOf(String.valueOf(map.get("buyNumber")));//购买数量
            NongziEntity nongziEntity = nongziService.selectById(nongziId);//购买的商品
            String id = String.valueOf(map.get("id"));
            if(StringUtil.isNotEmpty(id))
                cartIds.add(Integer.valueOf(id));

            //判断商品的库存是否足够
            if(nongziEntity.getNongziKucunNumber() < buyNumber){
                //商品库存不足直接返回
                return R.error(nongziEntity.getNongziName()+"的库存不足");
            }else{
                //商品库存充足就减库存
                nongziEntity.setNongziKucunNumber(nongziEntity.getNongziKucunNumber() - buyNumber);
            }

            //订单信息表增加数据
            NongziOrderEntity nongziOrderEntity = new NongziOrderEntity<>();

            //赋值订单信息
            nongziOrderEntity.setNongziOrderUuidNumber(nongziOrderUuidNumber);//订单编号
            nongziOrderEntity.setNongziId(nongziId);//农资
                        nongziOrderEntity.setZhongzhihuId(null);//种植户  ???????
            nongziOrderEntity.setBuyNumber(buyNumber);//购买数量 ？？？？？？
            nongziOrderEntity.setNongziOrderDizhi(nongziOrderDizhi);//地址 ？？？？？？
            nongziOrderEntity.setNongziOrderTypes(101);//订单类型
            nongziOrderEntity.setInsertTime(new Date());//订单创建时间
            nongziOrderEntity.setCreateTime(new Date());//创建时间

            //判断是什么支付方式 1代表余额 2代表积分
//            if(nongziOrderPaymentTypes == 1){//余额支付
                //计算金额
                Double money = new BigDecimal(nongziEntity.getNongziNewMoney()).multiply(new BigDecimal(buyNumber)).multiply(zhekou).doubleValue();

                if(yonghuEntity.getNewMoney() - money <0 ){
                    return R.error("余额不足,请充值！！！");
                }else{
                    //计算所获得积分
                    Double buyJifen =0.0;


                    nongziOrderEntity.setNongziOrderTruePrice(money);

                }
//            }
            nongziOrderList.add(nongziOrderEntity);
            nongziList.add(nongziEntity);

        }
        nongziOrderService.insertBatch(nongziOrderList);
        nongziService.updateBatchById(nongziList);
        yonghuService.updateById(yonghuEntity);
        if(cartIds != null && cartIds.size()>0)
            cartService.deleteBatchIds(cartIds);

        return R.ok();
    }


    /**
    * 退款
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

            NongziOrderEntity nongziOrder = nongziOrderService.selectById(id);//当前表service
            Integer buyNumber = nongziOrder.getBuyNumber();
            Integer nongziId = nongziOrder.getNongziId();
            if(nongziId == null)
                return R.error(511,"查不到该农资");
            NongziEntity nongziEntity = nongziService.selectById(nongziId);
            if(nongziEntity == null)
                return R.error(511,"查不到该农资");
            Double nongziNewMoney = nongziEntity.getNongziNewMoney();
            if(nongziNewMoney == null)
                return R.error(511,"农资价格不能为空");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
            return R.error(511,"用户金额不能为空");
            Double zhekou = 1.0;

                //计算金额
                Double money = nongziEntity.getNongziNewMoney() * buyNumber  * zhekou;
                //计算所获得积分
                Double buyJifen = 0.0;
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() + money); //设置金额



            nongziEntity.setNongziKucunNumber(nongziEntity.getNongziKucunNumber() + buyNumber);

            nongziOrder.setNongziOrderTypes(102);//设置订单状态为已退款
            nongziOrderService.updateAllColumnById(nongziOrder);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            nongziService.updateById(nongziEntity);//更新订单中农资的信息

            return R.ok();
    }

    /**
     * 发货
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id ,String nongziOrderCourierNumber, String nongziOrderCourierName , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        NongziOrderEntity  nongziOrderEntity = nongziOrderService.selectById(id);
        nongziOrderEntity.setNongziOrderTypes(103);//设置订单状态为已发货
        nongziOrderEntity.setNongziOrderCourierNumber(nongziOrderCourierNumber);
        nongziOrderEntity.setNongziOrderCourierName(nongziOrderCourierName);
        nongziOrderService.updateById( nongziOrderEntity);

        return R.ok();
    }


    /**
     * 收货
     */
    @RequestMapping("/receiving")
    public R receiving(Integer id , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        NongziOrderEntity  nongziOrderEntity = nongziOrderService.selectById(id);
        nongziOrderEntity.setNongziOrderTypes(104);//设置订单状态为收货
        nongziOrderService.updateById( nongziOrderEntity);
        return R.ok();
    }

}

