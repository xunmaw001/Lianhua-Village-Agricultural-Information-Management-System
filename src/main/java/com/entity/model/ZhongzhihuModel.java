package com.entity.model;

import com.entity.ZhongzhihuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 种植户
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZhongzhihuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 种植户姓名
     */
    private String zhongzhihuName;


    /**
     * 头像
     */
    private String zhongzhihuPhoto;


    /**
     * 种植户手机号
     */
    private String zhongzhihuPhone;


    /**
     * 种植户身份证号
     */
    private String zhongzhihuIdNumber;


    /**
     * 邮箱
     */
    private String zhongzhihuEmail;


    /**
     * 余额
     */
    private Double newMoney;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：种植户姓名
	 */
    public String getZhongzhihuName() {
        return zhongzhihuName;
    }


    /**
	 * 设置：种植户姓名
	 */
    public void setZhongzhihuName(String zhongzhihuName) {
        this.zhongzhihuName = zhongzhihuName;
    }
    /**
	 * 获取：头像
	 */
    public String getZhongzhihuPhoto() {
        return zhongzhihuPhoto;
    }


    /**
	 * 设置：头像
	 */
    public void setZhongzhihuPhoto(String zhongzhihuPhoto) {
        this.zhongzhihuPhoto = zhongzhihuPhoto;
    }
    /**
	 * 获取：种植户手机号
	 */
    public String getZhongzhihuPhone() {
        return zhongzhihuPhone;
    }


    /**
	 * 设置：种植户手机号
	 */
    public void setZhongzhihuPhone(String zhongzhihuPhone) {
        this.zhongzhihuPhone = zhongzhihuPhone;
    }
    /**
	 * 获取：种植户身份证号
	 */
    public String getZhongzhihuIdNumber() {
        return zhongzhihuIdNumber;
    }


    /**
	 * 设置：种植户身份证号
	 */
    public void setZhongzhihuIdNumber(String zhongzhihuIdNumber) {
        this.zhongzhihuIdNumber = zhongzhihuIdNumber;
    }
    /**
	 * 获取：邮箱
	 */
    public String getZhongzhihuEmail() {
        return zhongzhihuEmail;
    }


    /**
	 * 设置：邮箱
	 */
    public void setZhongzhihuEmail(String zhongzhihuEmail) {
        this.zhongzhihuEmail = zhongzhihuEmail;
    }
    /**
	 * 获取：余额
	 */
    public Double getNewMoney() {
        return newMoney;
    }


    /**
	 * 设置：余额
	 */
    public void setNewMoney(Double newMoney) {
        this.newMoney = newMoney;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
