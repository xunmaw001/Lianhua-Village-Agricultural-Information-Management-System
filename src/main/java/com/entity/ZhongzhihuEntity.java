package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 种植户
 *
 * @author 
 * @email
 */
@TableName("zhongzhihu")
public class ZhongzhihuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZhongzhihuEntity() {

	}

	public ZhongzhihuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 账户
     */
    @ColumnInfo(comment="账户",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 种植户姓名
     */
    @ColumnInfo(comment="种植户姓名",type="varchar(200)")
    @TableField(value = "zhongzhihu_name")

    private String zhongzhihuName;


    /**
     * 头像
     */
    @ColumnInfo(comment="头像",type="varchar(255)")
    @TableField(value = "zhongzhihu_photo")

    private String zhongzhihuPhoto;


    /**
     * 种植户手机号
     */
    @ColumnInfo(comment="种植户手机号",type="varchar(200)")
    @TableField(value = "zhongzhihu_phone")

    private String zhongzhihuPhone;


    /**
     * 种植户身份证号
     */
    @ColumnInfo(comment="种植户身份证号",type="varchar(200)")
    @TableField(value = "zhongzhihu_id_number")

    private String zhongzhihuIdNumber;


    /**
     * 邮箱
     */
    @ColumnInfo(comment="邮箱",type="varchar(200)")
    @TableField(value = "zhongzhihu_email")

    private String zhongzhihuEmail;


    /**
     * 余额
     */
    @ColumnInfo(comment="余额",type="decimal(10,2)")
    @TableField(value = "new_money")

    private Double newMoney;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Zhongzhihu{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", zhongzhihuName=" + zhongzhihuName +
            ", zhongzhihuPhoto=" + zhongzhihuPhoto +
            ", zhongzhihuPhone=" + zhongzhihuPhone +
            ", zhongzhihuIdNumber=" + zhongzhihuIdNumber +
            ", zhongzhihuEmail=" + zhongzhihuEmail +
            ", newMoney=" + newMoney +
            ", sexTypes=" + sexTypes +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
