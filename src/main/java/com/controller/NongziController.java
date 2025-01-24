
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
 * 农资
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/nongzi")
public class NongziController {
    private static final Logger logger = LoggerFactory.getLogger(NongziController.class);

    private static final String TABLE_NAME = "nongzi";

    @Autowired
    private NongziService nongziService;


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
        params.put("nongziDeleteStart",1);params.put("nongziDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = nongziService.queryPage(params);

        //字典表数据转换
        List<NongziView> list =(List<NongziView>)page.getList();
        for(NongziView c:list){
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
        NongziEntity nongzi = nongziService.selectById(id);
        if(nongzi !=null){
            //entity转view
            NongziView view = new NongziView();
            BeanUtils.copyProperties( nongzi , view );//把实体数据重构到view中
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
    public R save(@RequestBody NongziEntity nongzi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,nongzi:{}",this.getClass().getName(),nongzi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<NongziEntity> queryWrapper = new EntityWrapper<NongziEntity>()
            .eq("nongzi_name", nongzi.getNongziName())
            .eq("nongzi_types", nongzi.getNongziTypes())
            .eq("nongzi_kucun_number", nongzi.getNongziKucunNumber())
            .eq("nongzi_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        NongziEntity nongziEntity = nongziService.selectOne(queryWrapper);
        if(nongziEntity==null){
            nongzi.setNongziClicknum(1);
            nongzi.setNongziDelete(1);
            nongzi.setInsertTime(new Date());
            nongzi.setCreateTime(new Date());
            nongziService.insert(nongzi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody NongziEntity nongzi, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,nongzi:{}",this.getClass().getName(),nongzi.toString());
        NongziEntity oldNongziEntity = nongziService.selectById(nongzi.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(nongzi.getNongziPhoto()) || "null".equals(nongzi.getNongziPhoto())){
                nongzi.setNongziPhoto(null);
        }

            nongziService.updateById(nongzi);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<NongziEntity> oldNongziList =nongziService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<NongziEntity> list = new ArrayList<>();
        for(Integer id:ids){
            NongziEntity nongziEntity = new NongziEntity();
            nongziEntity.setId(id);
            nongziEntity.setNongziDelete(2);
            list.add(nongziEntity);
        }
        if(list != null && list.size() >0){
            nongziService.updateBatchById(list);
        }

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
            List<NongziEntity> nongziList = new ArrayList<>();//上传的东西
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
                            NongziEntity nongziEntity = new NongziEntity();
//                            nongziEntity.setNongziName(data.get(0));                    //农资名称 要改的
//                            nongziEntity.setNongziUuidNumber(data.get(0));                    //农资编号 要改的
//                            nongziEntity.setNongziPhoto("");//详情和图片
//                            nongziEntity.setNongziTypes(Integer.valueOf(data.get(0)));   //农资类型 要改的
//                            nongziEntity.setNongziKucunNumber(Integer.valueOf(data.get(0)));   //农资库存 要改的
//                            nongziEntity.setNongziNewMoney(data.get(0));                    //金额 要改的
//                            nongziEntity.setNongziClicknum(Integer.valueOf(data.get(0)));   //农资热度 要改的
//                            nongziEntity.setNongziContent("");//详情和图片
//                            nongziEntity.setNongziDelete(1);//逻辑删除字段
//                            nongziEntity.setInsertTime(date);//时间
//                            nongziEntity.setCreateTime(date);//时间
                            nongziList.add(nongziEntity);


                            //把要查询是否重复的字段放入map中
                                //农资编号
                                if(seachFields.containsKey("nongziUuidNumber")){
                                    List<String> nongziUuidNumber = seachFields.get("nongziUuidNumber");
                                    nongziUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> nongziUuidNumber = new ArrayList<>();
                                    nongziUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("nongziUuidNumber",nongziUuidNumber);
                                }
                        }

                        //查询是否重复
                         //农资编号
                        List<NongziEntity> nongziEntities_nongziUuidNumber = nongziService.selectList(new EntityWrapper<NongziEntity>().in("nongzi_uuid_number", seachFields.get("nongziUuidNumber")).eq("nongzi_delete", 1));
                        if(nongziEntities_nongziUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(NongziEntity s:nongziEntities_nongziUuidNumber){
                                repeatFields.add(s.getNongziUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [农资编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        nongziService.insertBatch(nongziList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<NongziView> returnNongziViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = nongziOrderService.queryPage(params1);
        List<NongziOrderView> orderViewsList =(List<NongziOrderView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(NongziOrderView orderView:orderViewsList){
            Integer nongziTypes = orderView.getNongziTypes();
            if(typeMap.containsKey(nongziTypes)){
                typeMap.put(nongziTypes,typeMap.get(nongziTypes)+1);
            }else{
                typeMap.put(nongziTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("nongziTypes",type);
            PageUtils pageUtils1 = nongziService.queryPage(params2);
            List<NongziView> nongziViewList =(List<NongziView>)pageUtils1.getList();
            returnNongziViewList.addAll(nongziViewList);
            if(returnNongziViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = nongziService.queryPage(params);
        if(returnNongziViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnNongziViewList.size();//要添加的数量
            List<NongziView> nongziViewList =(List<NongziView>)page.getList();
            for(NongziView nongziView:nongziViewList){
                Boolean addFlag = true;
                for(NongziView returnNongziView:returnNongziViewList){
                    if(returnNongziView.getId().intValue() ==nongziView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnNongziViewList.add(nongziView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnNongziViewList = returnNongziViewList.subList(0, limit);
        }

        for(NongziView c:returnNongziViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnNongziViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = nongziService.queryPage(params);

        //字典表数据转换
        List<NongziView> list =(List<NongziView>)page.getList();
        for(NongziView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        NongziEntity nongzi = nongziService.selectById(id);
            if(nongzi !=null){

                //点击数量加1
                nongzi.setNongziClicknum(nongzi.getNongziClicknum()+1);
                nongziService.updateById(nongzi);

                //entity转view
                NongziView view = new NongziView();
                BeanUtils.copyProperties( nongzi , view );//把实体数据重构到view中

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
    public R add(@RequestBody NongziEntity nongzi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,nongzi:{}",this.getClass().getName(),nongzi.toString());
        Wrapper<NongziEntity> queryWrapper = new EntityWrapper<NongziEntity>()
            .eq("nongzi_name", nongzi.getNongziName())
            .eq("nongzi_uuid_number", nongzi.getNongziUuidNumber())
            .eq("nongzi_types", nongzi.getNongziTypes())
            .eq("nongzi_kucun_number", nongzi.getNongziKucunNumber())
            .eq("nongzi_clicknum", nongzi.getNongziClicknum())
            .eq("nongzi_delete", nongzi.getNongziDelete())
//            .notIn("nongzi_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        NongziEntity nongziEntity = nongziService.selectOne(queryWrapper);
        if(nongziEntity==null){
            nongzi.setNongziClicknum(1);
            nongzi.setNongziDelete(1);
            nongzi.setInsertTime(new Date());
            nongzi.setCreateTime(new Date());
        nongziService.insert(nongzi);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

