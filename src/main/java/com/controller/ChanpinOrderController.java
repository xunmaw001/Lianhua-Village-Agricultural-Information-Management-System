
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
 * 农产品订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chanpinOrder")
public class ChanpinOrderController {
    private static final Logger logger = LoggerFactory.getLogger(ChanpinOrderController.class);

    private static final String TABLE_NAME = "chanpinOrder";

    @Autowired
    private ChanpinOrderService chanpinOrderService;


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
    private NongziOrderService nongziOrderService;//农资订单
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
        PageUtils page = chanpinOrderService.queryPage(params);

        //字典表数据转换
        List<ChanpinOrderView> list =(List<ChanpinOrderView>)page.getList();
        for(ChanpinOrderView c:list){
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
        ChanpinOrderEntity chanpinOrder = chanpinOrderService.selectById(id);
        if(chanpinOrder !=null){
            //entity转view
            ChanpinOrderView view = new ChanpinOrderView();
            BeanUtils.copyProperties( chanpinOrder , view );//把实体数据重构到view中
            //级联表 收货地址
            //级联表
            AddressEntity address = addressService.selectById(chanpinOrder.getAddressId());
            if(address != null){
            BeanUtils.copyProperties( address , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setAddressId(address.getId());
            }
            //级联表 农产品
            //级联表
            ChanpinEntity chanpin = chanpinService.selectById(chanpinOrder.getChanpinId());
            if(chanpin != null){
            BeanUtils.copyProperties( chanpin , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setChanpinId(chanpin.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(chanpinOrder.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
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
    public R save(@RequestBody ChanpinOrderEntity chanpinOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chanpinOrder:{}",this.getClass().getName(),chanpinOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            chanpinOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        chanpinOrder.setCreateTime(new Date());
        chanpinOrder.setInsertTime(new Date());
        chanpinOrderService.insert(chanpinOrder);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChanpinOrderEntity chanpinOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,chanpinOrder:{}",this.getClass().getName(),chanpinOrder.toString());
        ChanpinOrderEntity oldChanpinOrderEntity = chanpinOrderService.selectById(chanpinOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            chanpinOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            chanpinOrderService.updateById(chanpinOrder);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ChanpinOrderEntity> oldChanpinOrderList =chanpinOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        chanpinOrderService.deleteBatchIds(Arrays.asList(ids));

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
            List<ChanpinOrderEntity> chanpinOrderList = new ArrayList<>();//上传的东西
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
                            ChanpinOrderEntity chanpinOrderEntity = new ChanpinOrderEntity();
//                            chanpinOrderEntity.setAddressId(Integer.valueOf(data.get(0)));   //收货地址 要改的
//                            chanpinOrderEntity.setChanpinOrderUuidNumber(data.get(0));                    //订单编号 要改的
//                            chanpinOrderEntity.setChanpinId(Integer.valueOf(data.get(0)));   //农产品 要改的
//                            chanpinOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            chanpinOrderEntity.setBuyNumber(Integer.valueOf(data.get(0)));   //购买数量 要改的
//                            chanpinOrderEntity.setChanpinOrderTruePrice(data.get(0));                    //实付价格 要改的
//                            chanpinOrderEntity.setChanpinOrderCourierName(data.get(0));                    //快递公司 要改的
//                            chanpinOrderEntity.setChanpinOrderCourierNumber(data.get(0));                    //快递单号 要改的
//                            chanpinOrderEntity.setChanpinOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            chanpinOrderEntity.setInsertTime(date);//时间
//                            chanpinOrderEntity.setCreateTime(date);//时间
                            chanpinOrderList.add(chanpinOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单编号
                                if(seachFields.containsKey("chanpinOrderUuidNumber")){
                                    List<String> chanpinOrderUuidNumber = seachFields.get("chanpinOrderUuidNumber");
                                    chanpinOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> chanpinOrderUuidNumber = new ArrayList<>();
                                    chanpinOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("chanpinOrderUuidNumber",chanpinOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单编号
                        List<ChanpinOrderEntity> chanpinOrderEntities_chanpinOrderUuidNumber = chanpinOrderService.selectList(new EntityWrapper<ChanpinOrderEntity>().in("chanpin_order_uuid_number", seachFields.get("chanpinOrderUuidNumber")));
                        if(chanpinOrderEntities_chanpinOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ChanpinOrderEntity s:chanpinOrderEntities_chanpinOrderUuidNumber){
                                repeatFields.add(s.getChanpinOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        chanpinOrderService.insertBatch(chanpinOrderList);
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
        PageUtils page = chanpinOrderService.queryPage(params);

        //字典表数据转换
        List<ChanpinOrderView> list =(List<ChanpinOrderView>)page.getList();
        for(ChanpinOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChanpinOrderEntity chanpinOrder = chanpinOrderService.selectById(id);
            if(chanpinOrder !=null){


                //entity转view
                ChanpinOrderView view = new ChanpinOrderView();
                BeanUtils.copyProperties( chanpinOrder , view );//把实体数据重构到view中

                //级联表
                    AddressEntity address = addressService.selectById(chanpinOrder.getAddressId());
                if(address != null){
                    BeanUtils.copyProperties( address , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setAddressId(address.getId());
                }
                //级联表
                    ChanpinEntity chanpin = chanpinService.selectById(chanpinOrder.getChanpinId());
                if(chanpin != null){
                    BeanUtils.copyProperties( chanpin , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setChanpinId(chanpin.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(chanpinOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
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
    public R add(@RequestBody ChanpinOrderEntity chanpinOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,chanpinOrder:{}",this.getClass().getName(),chanpinOrder.toString());
            ChanpinEntity chanpinEntity = chanpinService.selectById(chanpinOrder.getChanpinId());
            if(chanpinEntity == null){
                return R.error(511,"查不到该农产品");
            }
            // Double chanpinNewMoney = chanpinEntity.getChanpinNewMoney();

            if(false){
            }
            else if(chanpinEntity.getChanpinNewMoney() == null){
                return R.error(511,"金额不能为空");
            }
            else if((chanpinEntity.getChanpinKucunNumber() -chanpinOrder.getBuyNumber())<0){
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
            double balance = yonghuEntity.getNewMoney() - chanpinEntity.getChanpinNewMoney()*chanpinOrder.getBuyNumber();//余额
            if(balance<0)
                return R.error(511,"余额不够支付");
            chanpinOrder.setChanpinOrderTypes(101); //设置订单状态为已支付
            chanpinOrder.setChanpinOrderTruePrice(chanpinEntity.getChanpinNewMoney()*chanpinOrder.getBuyNumber()); //设置实付价格
            chanpinOrder.setYonghuId(userId); //设置订单支付人id
            chanpinOrder.setChanpinOrderUuidNumber(String.valueOf(new Date().getTime()));
            chanpinOrder.setInsertTime(new Date());
            chanpinOrder.setCreateTime(new Date());
                chanpinEntity.setChanpinKucunNumber( chanpinEntity.getChanpinKucunNumber() -chanpinOrder.getBuyNumber());
                chanpinService.updateById(chanpinEntity);
                chanpinOrderService.insert(chanpinOrder);//新增订单
            //更新第一注册表
            yonghuEntity.setNewMoney(balance);//设置金额
            yonghuService.updateById(yonghuEntity);

            ZhongzhihuEntity zhongzhihuEntity = zhongzhihuService.selectById(chanpinEntity.getZhongzhihuId());
            zhongzhihuEntity.setNewMoney(zhongzhihuEntity.getNewMoney()+chanpinOrder.getChanpinOrderTruePrice());//动态计算金额
            zhongzhihuService.updateById(zhongzhihuEntity);

            return R.ok();
    }
    /**
     * 添加订单
     */
    @RequestMapping("/order")
    public R add(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("order方法:,,Controller:{},,params:{}",this.getClass().getName(),params.toString());
        String chanpinOrderUuidNumber = String.valueOf(new Date().getTime());

        //获取当前登录用户的id
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        Integer addressId = Integer.valueOf(String.valueOf(params.get("addressId")));


        String data = String.valueOf(params.get("chanpins"));
        JSONArray jsonArray = JSON.parseArray(data);
        List<Map> chanpins = JSON.parseObject(jsonArray.toString(), List.class);

        //获取当前登录用户的个人信息
        YonghuEntity yonghuEntity = yonghuService.selectById(userId);

        //当前订单表
        List<ChanpinOrderEntity> chanpinOrderList = new ArrayList<>();
        //商品表
        List<ChanpinEntity> chanpinList = new ArrayList<>();
        //购物车ids
        List<Integer> cartIds = new ArrayList<>();

        BigDecimal zhekou = new BigDecimal(1.0);

        //循环取出需要的数据
        for (Map<String, Object> map : chanpins) {
           //取值
            Integer chanpinId = Integer.valueOf(String.valueOf(map.get("chanpinId")));//商品id
            Integer buyNumber = Integer.valueOf(String.valueOf(map.get("buyNumber")));//购买数量
            ChanpinEntity chanpinEntity = chanpinService.selectById(chanpinId);//购买的商品
            String id = String.valueOf(map.get("id"));
            if(StringUtil.isNotEmpty(id))
                cartIds.add(Integer.valueOf(id));

            //判断商品的库存是否足够
            if(chanpinEntity.getChanpinKucunNumber() < buyNumber){
                //商品库存不足直接返回
                return R.error(chanpinEntity.getChanpinName()+"的库存不足");
            }else{
                //商品库存充足就减库存
                chanpinEntity.setChanpinKucunNumber(chanpinEntity.getChanpinKucunNumber() - buyNumber);
            }

            //订单信息表增加数据
            ChanpinOrderEntity chanpinOrderEntity = new ChanpinOrderEntity<>();

            //赋值订单信息
            chanpinOrderEntity.setAddressId(addressId);//收货地址
            chanpinOrderEntity.setChanpinOrderUuidNumber(chanpinOrderUuidNumber);//订单编号
            chanpinOrderEntity.setChanpinId(chanpinId);//农产品
                        chanpinOrderEntity.setYonghuId(userId);//用户
            chanpinOrderEntity.setBuyNumber(buyNumber);//购买数量 ？？？？？？
            chanpinOrderEntity.setChanpinOrderTypes(101);//订单类型
            chanpinOrderEntity.setInsertTime(new Date());//订单创建时间
            chanpinOrderEntity.setCreateTime(new Date());//创建时间

            //判断是什么支付方式 1代表余额 2代表积分
//            if(chanpinOrderPaymentTypes == 1){//余额支付
                //计算金额
                Double money = new BigDecimal(chanpinEntity.getChanpinNewMoney()).multiply(new BigDecimal(buyNumber)).multiply(zhekou).doubleValue();

                if(yonghuEntity.getNewMoney() - money <0 ){
                    return R.error("余额不足,请充值！！！");
                }else{
                    //计算所获得积分
                    Double buyJifen =0.0;
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() - money); //设置金额


                    chanpinOrderEntity.setChanpinOrderTruePrice(money);

                }
//            }
            chanpinOrderList.add(chanpinOrderEntity);
            chanpinList.add(chanpinEntity);

        }
        chanpinOrderService.insertBatch(chanpinOrderList);
        chanpinService.updateBatchById(chanpinList);
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

            ChanpinOrderEntity chanpinOrder = chanpinOrderService.selectById(id);//当前表service
            Integer buyNumber = chanpinOrder.getBuyNumber();
            Integer chanpinId = chanpinOrder.getChanpinId();
            if(chanpinId == null)
                return R.error(511,"查不到该农产品");
            ChanpinEntity chanpinEntity = chanpinService.selectById(chanpinId);
            if(chanpinEntity == null)
                return R.error(511,"查不到该农产品");
            Double chanpinNewMoney = chanpinEntity.getChanpinNewMoney();
            if(chanpinNewMoney == null)
                return R.error(511,"农产品价格不能为空");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
            return R.error(511,"用户金额不能为空");
            Double zhekou = 1.0;

                //计算金额
                Double money = chanpinEntity.getChanpinNewMoney() * buyNumber  * zhekou;
                //计算所获得积分
                Double buyJifen = 0.0;
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() + money); //设置金额



            chanpinEntity.setChanpinKucunNumber(chanpinEntity.getChanpinKucunNumber() + buyNumber);

            chanpinOrder.setChanpinOrderTypes(102);//设置订单状态为已退款
            chanpinOrderService.updateAllColumnById(chanpinOrder);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            chanpinService.updateById(chanpinEntity);//更新订单中农产品的信息

            return R.ok();
    }

    /**
    * 评价
    */
    @RequestMapping("/commentback")
    public R commentback(Integer id, String commentbackText, Integer chanpinCommentbackPingfenNumber, HttpServletRequest request){
        logger.debug("commentback方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
            ChanpinOrderEntity chanpinOrder = chanpinOrderService.selectById(id);
        if(chanpinOrder == null)
            return R.error(511,"查不到该订单");
        Integer chanpinId = chanpinOrder.getChanpinId();
        if(chanpinId == null)
            return R.error(511,"查不到该农产品");

        ChanpinCommentbackEntity chanpinCommentbackEntity = new ChanpinCommentbackEntity();
            chanpinCommentbackEntity.setId(id);
            chanpinCommentbackEntity.setChanpinId(chanpinId);
            chanpinCommentbackEntity.setYonghuId((Integer) request.getSession().getAttribute("userId"));
            chanpinCommentbackEntity.setChanpinCommentbackText(commentbackText);
            chanpinCommentbackEntity.setInsertTime(new Date());
            chanpinCommentbackEntity.setReplyText(null);
            chanpinCommentbackEntity.setUpdateTime(null);
            chanpinCommentbackEntity.setCreateTime(new Date());
            chanpinCommentbackService.insert(chanpinCommentbackEntity);

            chanpinOrder.setChanpinOrderTypes(105);//设置订单状态为已评价
            chanpinOrderService.updateById(chanpinOrder);//根据id更新
            return R.ok();
    }

    /**
     * 发货
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id ,String chanpinOrderCourierNumber, String chanpinOrderCourierName , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        ChanpinOrderEntity  chanpinOrderEntity = chanpinOrderService.selectById(id);
        chanpinOrderEntity.setChanpinOrderTypes(103);//设置订单状态为已发货
        chanpinOrderEntity.setChanpinOrderCourierNumber(chanpinOrderCourierNumber);
        chanpinOrderEntity.setChanpinOrderCourierName(chanpinOrderCourierName);
        chanpinOrderService.updateById( chanpinOrderEntity);

        return R.ok();
    }


    /**
     * 收货
     */
    @RequestMapping("/receiving")
    public R receiving(Integer id , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        ChanpinOrderEntity  chanpinOrderEntity = chanpinOrderService.selectById(id);
        chanpinOrderEntity.setChanpinOrderTypes(104);//设置订单状态为收货
        chanpinOrderService.updateById( chanpinOrderEntity);
        return R.ok();
    }

}

