
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
 * 种植户
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zhongzhihu")
public class ZhongzhihuController {
    private static final Logger logger = LoggerFactory.getLogger(ZhongzhihuController.class);

    private static final String TABLE_NAME = "zhongzhihu";

    @Autowired
    private ZhongzhihuService zhongzhihuService;


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
    private NongziOrderService nongziOrderService;//农资订单
    @Autowired
    private YonghuService yonghuService;//用户
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
        PageUtils page = zhongzhihuService.queryPage(params);

        //字典表数据转换
        List<ZhongzhihuView> list =(List<ZhongzhihuView>)page.getList();
        for(ZhongzhihuView c:list){
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
        ZhongzhihuEntity zhongzhihu = zhongzhihuService.selectById(id);
        if(zhongzhihu !=null){
            //entity转view
            ZhongzhihuView view = new ZhongzhihuView();
            BeanUtils.copyProperties( zhongzhihu , view );//把实体数据重构到view中
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
    public R save(@RequestBody ZhongzhihuEntity zhongzhihu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhongzhihu:{}",this.getClass().getName(),zhongzhihu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ZhongzhihuEntity> queryWrapper = new EntityWrapper<ZhongzhihuEntity>()
            .eq("username", zhongzhihu.getUsername())
            .or()
            .eq("zhongzhihu_phone", zhongzhihu.getZhongzhihuPhone())
            .or()
            .eq("zhongzhihu_id_number", zhongzhihu.getZhongzhihuIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhongzhihuEntity zhongzhihuEntity = zhongzhihuService.selectOne(queryWrapper);
        if(zhongzhihuEntity==null){
            zhongzhihu.setCreateTime(new Date());
            zhongzhihu.setPassword("123456");
            zhongzhihuService.insert(zhongzhihu);
            return R.ok();
        }else {
            return R.error(511,"账户或者种植户手机号或者种植户身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhongzhihuEntity zhongzhihu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,zhongzhihu:{}",this.getClass().getName(),zhongzhihu.toString());
        ZhongzhihuEntity oldZhongzhihuEntity = zhongzhihuService.selectById(zhongzhihu.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(zhongzhihu.getZhongzhihuPhoto()) || "null".equals(zhongzhihu.getZhongzhihuPhoto())){
                zhongzhihu.setZhongzhihuPhoto(null);
        }

            zhongzhihuService.updateById(zhongzhihu);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ZhongzhihuEntity> oldZhongzhihuList =zhongzhihuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        zhongzhihuService.deleteBatchIds(Arrays.asList(ids));

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
            List<ZhongzhihuEntity> zhongzhihuList = new ArrayList<>();//上传的东西
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
                            ZhongzhihuEntity zhongzhihuEntity = new ZhongzhihuEntity();
//                            zhongzhihuEntity.setUsername(data.get(0));                    //账户 要改的
//                            zhongzhihuEntity.setPassword("123456");//密码
//                            zhongzhihuEntity.setZhongzhihuName(data.get(0));                    //种植户姓名 要改的
//                            zhongzhihuEntity.setZhongzhihuPhoto("");//详情和图片
//                            zhongzhihuEntity.setZhongzhihuPhone(data.get(0));                    //种植户手机号 要改的
//                            zhongzhihuEntity.setZhongzhihuIdNumber(data.get(0));                    //种植户身份证号 要改的
//                            zhongzhihuEntity.setZhongzhihuEmail(data.get(0));                    //邮箱 要改的
//                            zhongzhihuEntity.setNewMoney(data.get(0));                    //余额 要改的
//                            zhongzhihuEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            zhongzhihuEntity.setCreateTime(date);//时间
                            zhongzhihuList.add(zhongzhihuEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //种植户手机号
                                if(seachFields.containsKey("zhongzhihuPhone")){
                                    List<String> zhongzhihuPhone = seachFields.get("zhongzhihuPhone");
                                    zhongzhihuPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> zhongzhihuPhone = new ArrayList<>();
                                    zhongzhihuPhone.add(data.get(0));//要改的
                                    seachFields.put("zhongzhihuPhone",zhongzhihuPhone);
                                }
                                //种植户身份证号
                                if(seachFields.containsKey("zhongzhihuIdNumber")){
                                    List<String> zhongzhihuIdNumber = seachFields.get("zhongzhihuIdNumber");
                                    zhongzhihuIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> zhongzhihuIdNumber = new ArrayList<>();
                                    zhongzhihuIdNumber.add(data.get(0));//要改的
                                    seachFields.put("zhongzhihuIdNumber",zhongzhihuIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<ZhongzhihuEntity> zhongzhihuEntities_username = zhongzhihuService.selectList(new EntityWrapper<ZhongzhihuEntity>().in("username", seachFields.get("username")));
                        if(zhongzhihuEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhongzhihuEntity s:zhongzhihuEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //种植户手机号
                        List<ZhongzhihuEntity> zhongzhihuEntities_zhongzhihuPhone = zhongzhihuService.selectList(new EntityWrapper<ZhongzhihuEntity>().in("zhongzhihu_phone", seachFields.get("zhongzhihuPhone")));
                        if(zhongzhihuEntities_zhongzhihuPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhongzhihuEntity s:zhongzhihuEntities_zhongzhihuPhone){
                                repeatFields.add(s.getZhongzhihuPhone());
                            }
                            return R.error(511,"数据库的该表中的 [种植户手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //种植户身份证号
                        List<ZhongzhihuEntity> zhongzhihuEntities_zhongzhihuIdNumber = zhongzhihuService.selectList(new EntityWrapper<ZhongzhihuEntity>().in("zhongzhihu_id_number", seachFields.get("zhongzhihuIdNumber")));
                        if(zhongzhihuEntities_zhongzhihuIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhongzhihuEntity s:zhongzhihuEntities_zhongzhihuIdNumber){
                                repeatFields.add(s.getZhongzhihuIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [种植户身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        zhongzhihuService.insertBatch(zhongzhihuList);
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
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        ZhongzhihuEntity zhongzhihu = zhongzhihuService.selectOne(new EntityWrapper<ZhongzhihuEntity>().eq("username", username));
        if(zhongzhihu==null || !zhongzhihu.getPassword().equals(password))
            return R.error("账号或密码不正确");
        String token = tokenService.generateToken(zhongzhihu.getId(),username, "zhongzhihu", "种植户");
        R r = R.ok();
        r.put("token", token);
        r.put("role","种植户");
        r.put("username",zhongzhihu.getZhongzhihuName());
        r.put("tableName","zhongzhihu");
        r.put("userId",zhongzhihu.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody ZhongzhihuEntity zhongzhihu, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<ZhongzhihuEntity> queryWrapper = new EntityWrapper<ZhongzhihuEntity>()
            .eq("username", zhongzhihu.getUsername())
            .or()
            .eq("zhongzhihu_phone", zhongzhihu.getZhongzhihuPhone())
            .or()
            .eq("zhongzhihu_id_number", zhongzhihu.getZhongzhihuIdNumber())
            ;
        ZhongzhihuEntity zhongzhihuEntity = zhongzhihuService.selectOne(queryWrapper);
        if(zhongzhihuEntity != null)
            return R.error("账户或者种植户手机号或者种植户身份证号已经被使用");
        zhongzhihu.setNewMoney(0.0);
        zhongzhihu.setCreateTime(new Date());
        zhongzhihuService.insert(zhongzhihu);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        ZhongzhihuEntity zhongzhihu = zhongzhihuService.selectById(id);
        zhongzhihu.setPassword("123456");
        zhongzhihuService.updateById(zhongzhihu);
        return R.ok();
    }

	/**
	 * 修改密码
	 */
	@GetMapping(value = "/updatePassword")
	public R updatePassword(String  oldPassword, String  newPassword, HttpServletRequest request) {
        ZhongzhihuEntity zhongzhihu = zhongzhihuService.selectById((Integer)request.getSession().getAttribute("userId"));
		if(newPassword == null){
			return R.error("新密码不能为空") ;
		}
		if(!oldPassword.equals(zhongzhihu.getPassword())){
			return R.error("原密码输入错误");
		}
		if(newPassword.equals(zhongzhihu.getPassword())){
			return R.error("新密码不能和原密码一致") ;
		}
        zhongzhihu.setPassword(newPassword);
		zhongzhihuService.updateById(zhongzhihu);
		return R.ok();
	}



    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        ZhongzhihuEntity zhongzhihu = zhongzhihuService.selectOne(new EntityWrapper<ZhongzhihuEntity>().eq("username", username));
        if(zhongzhihu!=null){
            zhongzhihu.setPassword("123456");
            zhongzhihuService.updateById(zhongzhihu);
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrZhongzhihu(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        ZhongzhihuEntity zhongzhihu = zhongzhihuService.selectById(id);
        if(zhongzhihu !=null){
            //entity转view
            ZhongzhihuView view = new ZhongzhihuView();
            BeanUtils.copyProperties( zhongzhihu , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = zhongzhihuService.queryPage(params);

        //字典表数据转换
        List<ZhongzhihuView> list =(List<ZhongzhihuView>)page.getList();
        for(ZhongzhihuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZhongzhihuEntity zhongzhihu = zhongzhihuService.selectById(id);
            if(zhongzhihu !=null){


                //entity转view
                ZhongzhihuView view = new ZhongzhihuView();
                BeanUtils.copyProperties( zhongzhihu , view );//把实体数据重构到view中

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
    public R add(@RequestBody ZhongzhihuEntity zhongzhihu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,zhongzhihu:{}",this.getClass().getName(),zhongzhihu.toString());
        Wrapper<ZhongzhihuEntity> queryWrapper = new EntityWrapper<ZhongzhihuEntity>()
            .eq("username", zhongzhihu.getUsername())
            .or()
            .eq("zhongzhihu_phone", zhongzhihu.getZhongzhihuPhone())
            .or()
            .eq("zhongzhihu_id_number", zhongzhihu.getZhongzhihuIdNumber())
//            .notIn("zhongzhihu_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhongzhihuEntity zhongzhihuEntity = zhongzhihuService.selectOne(queryWrapper);
        if(zhongzhihuEntity==null){
            zhongzhihu.setCreateTime(new Date());
            zhongzhihu.setPassword("123456");
        zhongzhihuService.insert(zhongzhihu);

            return R.ok();
        }else {
            return R.error(511,"账户或者种植户手机号或者种植户身份证号已经被使用");
        }
    }

}

