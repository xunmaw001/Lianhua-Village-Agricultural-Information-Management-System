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
 * 农产品
 *
 * @author 
 * @email
 */
@TableName("chanpin")
public class ChanpinEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChanpinEntity() {

	}

	public ChanpinEntity(T t) {
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
     * 种植户
     */
    @ColumnInfo(comment="种植户",type="int(11)")
    @TableField(value = "zhongzhihu_id")

    private Integer zhongzhihuId;


    /**
     * 农产品名称
     */
    @ColumnInfo(comment="农产品名称",type="varchar(200)")
    @TableField(value = "chanpin_name")

    private String chanpinName;


    /**
     * 农产品编号
     */
    @ColumnInfo(comment="农产品编号",type="varchar(200)")
    @TableField(value = "chanpin_uuid_number")

    private String chanpinUuidNumber;


    /**
     * 农产品照片
     */
    @ColumnInfo(comment="农产品照片",type="varchar(200)")
    @TableField(value = "chanpin_photo")

    private String chanpinPhoto;


    /**
     * 农产品类型
     */
    @ColumnInfo(comment="农产品类型",type="int(11)")
    @TableField(value = "chanpin_types")

    private Integer chanpinTypes;


    /**
     * 农产品库存
     */
    @ColumnInfo(comment="农产品库存",type="int(11)")
    @TableField(value = "chanpin_kucun_number")

    private Integer chanpinKucunNumber;


    /**
     * 金额
     */
    @ColumnInfo(comment="金额",type="decimal(10,2)")
    @TableField(value = "chanpin_new_money")

    private Double chanpinNewMoney;


    /**
     * 农产品热度
     */
    @ColumnInfo(comment="农产品热度",type="int(11)")
    @TableField(value = "chanpin_clicknum")

    private Integer chanpinClicknum;


    /**
     * 农产品介绍
     */
    @ColumnInfo(comment="农产品介绍",type="longtext")
    @TableField(value = "chanpin_content")

    private String chanpinContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "chanpin_delete")

    private Integer chanpinDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 获取：种植户
	 */
    public Integer getZhongzhihuId() {
        return zhongzhihuId;
    }
    /**
	 * 设置：种植户
	 */

    public void setZhongzhihuId(Integer zhongzhihuId) {
        this.zhongzhihuId = zhongzhihuId;
    }
    /**
	 * 获取：农产品名称
	 */
    public String getChanpinName() {
        return chanpinName;
    }
    /**
	 * 设置：农产品名称
	 */

    public void setChanpinName(String chanpinName) {
        this.chanpinName = chanpinName;
    }
    /**
	 * 获取：农产品编号
	 */
    public String getChanpinUuidNumber() {
        return chanpinUuidNumber;
    }
    /**
	 * 设置：农产品编号
	 */

    public void setChanpinUuidNumber(String chanpinUuidNumber) {
        this.chanpinUuidNumber = chanpinUuidNumber;
    }
    /**
	 * 获取：农产品照片
	 */
    public String getChanpinPhoto() {
        return chanpinPhoto;
    }
    /**
	 * 设置：农产品照片
	 */

    public void setChanpinPhoto(String chanpinPhoto) {
        this.chanpinPhoto = chanpinPhoto;
    }
    /**
	 * 获取：农产品类型
	 */
    public Integer getChanpinTypes() {
        return chanpinTypes;
    }
    /**
	 * 设置：农产品类型
	 */

    public void setChanpinTypes(Integer chanpinTypes) {
        this.chanpinTypes = chanpinTypes;
    }
    /**
	 * 获取：农产品库存
	 */
    public Integer getChanpinKucunNumber() {
        return chanpinKucunNumber;
    }
    /**
	 * 设置：农产品库存
	 */

    public void setChanpinKucunNumber(Integer chanpinKucunNumber) {
        this.chanpinKucunNumber = chanpinKucunNumber;
    }
    /**
	 * 获取：金额
	 */
    public Double getChanpinNewMoney() {
        return chanpinNewMoney;
    }
    /**
	 * 设置：金额
	 */

    public void setChanpinNewMoney(Double chanpinNewMoney) {
        this.chanpinNewMoney = chanpinNewMoney;
    }
    /**
	 * 获取：农产品热度
	 */
    public Integer getChanpinClicknum() {
        return chanpinClicknum;
    }
    /**
	 * 设置：农产品热度
	 */

    public void setChanpinClicknum(Integer chanpinClicknum) {
        this.chanpinClicknum = chanpinClicknum;
    }
    /**
	 * 获取：农产品介绍
	 */
    public String getChanpinContent() {
        return chanpinContent;
    }
    /**
	 * 设置：农产品介绍
	 */

    public void setChanpinContent(String chanpinContent) {
        this.chanpinContent = chanpinContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getChanpinDelete() {
        return chanpinDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setChanpinDelete(Integer chanpinDelete) {
        this.chanpinDelete = chanpinDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "Chanpin{" +
            ", id=" + id +
            ", zhongzhihuId=" + zhongzhihuId +
            ", chanpinName=" + chanpinName +
            ", chanpinUuidNumber=" + chanpinUuidNumber +
            ", chanpinPhoto=" + chanpinPhoto +
            ", chanpinTypes=" + chanpinTypes +
            ", chanpinKucunNumber=" + chanpinKucunNumber +
            ", chanpinNewMoney=" + chanpinNewMoney +
            ", chanpinClicknum=" + chanpinClicknum +
            ", chanpinContent=" + chanpinContent +
            ", chanpinDelete=" + chanpinDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
