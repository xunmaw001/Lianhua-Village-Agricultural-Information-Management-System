
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
 * 农业技术
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jishu")
public class JishuController {
    private static final Logger logger = LoggerFactory.getLogger(JishuController.class);

    private static final String TABLE_NAME = "jishu";

    @Autowired
    private JishuService jishuService;


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
        params.put("jishuDeleteStart",1);params.put("jishuDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = jishuService.queryPage(params);

        //字典表数据转换
        List<JishuView> list =(List<JishuView>)page.getList();
        for(JishuView c:list){
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
        JishuEntity jishu = jishuService.selectById(id);
        if(jishu !=null){
            //entity转view
            JishuView view = new JishuView();
            BeanUtils.copyProperties( jishu , view );//把实体数据重构到view中
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
    public R save(@RequestBody JishuEntity jishu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jishu:{}",this.getClass().getName(),jishu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<JishuEntity> queryWrapper = new EntityWrapper<JishuEntity>()
            .eq("jishu_name", jishu.getJishuName())
            .eq("jishu_types", jishu.getJishuTypes())
            .eq("jishu_video", jishu.getJishuVideo())
            .eq("jishu_zuoyong", jishu.getJishuZuoyong())
            .eq("jishu_candi", jishu.getJishuCandi())
            .eq("jishu_wendu", jishu.getJishuWendu())
            .eq("jishu_shidu", jishu.getJishuShidu())
            .eq("jishu_rizhao", jishu.getJishuRizhao())
            .eq("jishu_jiazhi", jishu.getJishuJiazhi())
            .eq("jishu_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JishuEntity jishuEntity = jishuService.selectOne(queryWrapper);
        if(jishuEntity==null){
            jishu.setJishuDelete(1);
            jishu.setInsertTime(new Date());
            jishu.setCreateTime(new Date());
            jishuService.insert(jishu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JishuEntity jishu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jishu:{}",this.getClass().getName(),jishu.toString());
        JishuEntity oldJishuEntity = jishuService.selectById(jishu.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(jishu.getJishuPhoto()) || "null".equals(jishu.getJishuPhoto())){
                jishu.setJishuPhoto(null);
        }
        if("".equals(jishu.getJishuVideo()) || "null".equals(jishu.getJishuVideo())){
                jishu.setJishuVideo(null);
        }

            jishuService.updateById(jishu);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JishuEntity> oldJishuList =jishuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<JishuEntity> list = new ArrayList<>();
        for(Integer id:ids){
            JishuEntity jishuEntity = new JishuEntity();
            jishuEntity.setId(id);
            jishuEntity.setJishuDelete(2);
            list.add(jishuEntity);
        }
        if(list != null && list.size() >0){
            jishuService.updateBatchById(list);
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
            List<JishuEntity> jishuList = new ArrayList<>();//上传的东西
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
                            JishuEntity jishuEntity = new JishuEntity();
//                            jishuEntity.setJishuName(data.get(0));                    //农作物名称 要改的
//                            jishuEntity.setJishuUuidNumber(data.get(0));                    //农作物编号 要改的
//                            jishuEntity.setJishuPhoto("");//详情和图片
//                            jishuEntity.setJishuTypes(Integer.valueOf(data.get(0)));   //农作物类型 要改的
//                            jishuEntity.setJishuVideo(data.get(0));                    //农作物视频 要改的
//                            jishuEntity.setJishuZuoyong(data.get(0));                    //作用 要改的
//                            jishuEntity.setJishuCandi(data.get(0));                    //产地 要改的
//                            jishuEntity.setJishuWendu(data.get(0));                    //适宜温度 要改的
//                            jishuEntity.setJishuShidu(data.get(0));                    //适宜湿度 要改的
//                            jishuEntity.setJishuRizhao(data.get(0));                    //日照时长 要改的
//                            jishuEntity.setJishuJiazhi(data.get(0));                    //营养价值 要改的
//                            jishuEntity.setJishuContent("");//详情和图片
//                            jishuEntity.setJishuDelete(1);//逻辑删除字段
//                            jishuEntity.setInsertTime(date);//时间
//                            jishuEntity.setCreateTime(date);//时间
                            jishuList.add(jishuEntity);


                            //把要查询是否重复的字段放入map中
                                //农作物编号
                                if(seachFields.containsKey("jishuUuidNumber")){
                                    List<String> jishuUuidNumber = seachFields.get("jishuUuidNumber");
                                    jishuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jishuUuidNumber = new ArrayList<>();
                                    jishuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jishuUuidNumber",jishuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //农作物编号
                        List<JishuEntity> jishuEntities_jishuUuidNumber = jishuService.selectList(new EntityWrapper<JishuEntity>().in("jishu_uuid_number", seachFields.get("jishuUuidNumber")).eq("jishu_delete", 1));
                        if(jishuEntities_jishuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JishuEntity s:jishuEntities_jishuUuidNumber){
                                repeatFields.add(s.getJishuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [农作物编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jishuService.insertBatch(jishuList);
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
        PageUtils page = jishuService.queryPage(params);

        //字典表数据转换
        List<JishuView> list =(List<JishuView>)page.getList();
        for(JishuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JishuEntity jishu = jishuService.selectById(id);
            if(jishu !=null){


                //entity转view
                JishuView view = new JishuView();
                BeanUtils.copyProperties( jishu , view );//把实体数据重构到view中

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
    public R add(@RequestBody JishuEntity jishu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jishu:{}",this.getClass().getName(),jishu.toString());
        Wrapper<JishuEntity> queryWrapper = new EntityWrapper<JishuEntity>()
            .eq("jishu_name", jishu.getJishuName())
            .eq("jishu_uuid_number", jishu.getJishuUuidNumber())
            .eq("jishu_types", jishu.getJishuTypes())
            .eq("jishu_video", jishu.getJishuVideo())
            .eq("jishu_zuoyong", jishu.getJishuZuoyong())
            .eq("jishu_candi", jishu.getJishuCandi())
            .eq("jishu_wendu", jishu.getJishuWendu())
            .eq("jishu_shidu", jishu.getJishuShidu())
            .eq("jishu_rizhao", jishu.getJishuRizhao())
            .eq("jishu_jiazhi", jishu.getJishuJiazhi())
            .eq("jishu_delete", jishu.getJishuDelete())
//            .notIn("jishu_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JishuEntity jishuEntity = jishuService.selectOne(queryWrapper);
        if(jishuEntity==null){
            jishu.setJishuDelete(1);
            jishu.setInsertTime(new Date());
            jishu.setCreateTime(new Date());
        jishuService.insert(jishu);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

