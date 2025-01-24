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
 * 农资
 *
 * @author 
 * @email
 */
@TableName("nongzi")
public class NongziEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public NongziEntity() {

	}

	public NongziEntity(T t) {
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
     * 农资名称
     */
    @ColumnInfo(comment="农资名称",type="varchar(200)")
    @TableField(value = "nongzi_name")

    private String nongziName;


    /**
     * 农资编号
     */
    @ColumnInfo(comment="农资编号",type="varchar(200)")
    @TableField(value = "nongzi_uuid_number")

    private String nongziUuidNumber;


    /**
     * 农资照片
     */
    @ColumnInfo(comment="农资照片",type="varchar(200)")
    @TableField(value = "nongzi_photo")

    private String nongziPhoto;


    /**
     * 农资类型
     */
    @ColumnInfo(comment="农资类型",type="int(11)")
    @TableField(value = "nongzi_types")

    private Integer nongziTypes;


    /**
     * 农资库存
     */
    @ColumnInfo(comment="农资库存",type="int(11)")
    @TableField(value = "nongzi_kucun_number")

    private Integer nongziKucunNumber;


    /**
     * 金额
     */
    @ColumnInfo(comment="金额",type="decimal(10,2)")
    @TableField(value = "nongzi_new_money")

    private Double nongziNewMoney;


    /**
     * 农资热度
     */
    @ColumnInfo(comment="农资热度",type="int(11)")
    @TableField(value = "nongzi_clicknum")

    private Integer nongziClicknum;


    /**
     * 农资介绍
     */
    @ColumnInfo(comment="农资介绍",type="longtext")
    @TableField(value = "nongzi_content")

    private String nongziContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "nongzi_delete")

    private Integer nongziDelete;


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
	 * 获取：农资名称
	 */
    public String getNongziName() {
        return nongziName;
    }
    /**
	 * 设置：农资名称
	 */

    public void setNongziName(String nongziName) {
        this.nongziName = nongziName;
    }
    /**
	 * 获取：农资编号
	 */
    public String getNongziUuidNumber() {
        return nongziUuidNumber;
    }
    /**
	 * 设置：农资编号
	 */

    public void setNongziUuidNumber(String nongziUuidNumber) {
        this.nongziUuidNumber = nongziUuidNumber;
    }
    /**
	 * 获取：农资照片
	 */
    public String getNongziPhoto() {
        return nongziPhoto;
    }
    /**
	 * 设置：农资照片
	 */

    public void setNongziPhoto(String nongziPhoto) {
        this.nongziPhoto = nongziPhoto;
    }
    /**
	 * 获取：农资类型
	 */
    public Integer getNongziTypes() {
        return nongziTypes;
    }
    /**
	 * 设置：农资类型
	 */

    public void setNongziTypes(Integer nongziTypes) {
        this.nongziTypes = nongziTypes;
    }
    /**
	 * 获取：农资库存
	 */
    public Integer getNongziKucunNumber() {
        return nongziKucunNumber;
    }
    /**
	 * 设置：农资库存
	 */

    public void setNongziKucunNumber(Integer nongziKucunNumber) {
        this.nongziKucunNumber = nongziKucunNumber;
    }
    /**
	 * 获取：金额
	 */
    public Double getNongziNewMoney() {
        return nongziNewMoney;
    }
    /**
	 * 设置：金额
	 */

    public void setNongziNewMoney(Double nongziNewMoney) {
        this.nongziNewMoney = nongziNewMoney;
    }
    /**
	 * 获取：农资热度
	 */
    public Integer getNongziClicknum() {
        return nongziClicknum;
    }
    /**
	 * 设置：农资热度
	 */

    public void setNongziClicknum(Integer nongziClicknum) {
        this.nongziClicknum = nongziClicknum;
    }
    /**
	 * 获取：农资介绍
	 */
    public String getNongziContent() {
        return nongziContent;
    }
    /**
	 * 设置：农资介绍
	 */

    public void setNongziContent(String nongziContent) {
        this.nongziContent = nongziContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getNongziDelete() {
        return nongziDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setNongziDelete(Integer nongziDelete) {
        this.nongziDelete = nongziDelete;
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
        return "Nongzi{" +
            ", id=" + id +
            ", nongziName=" + nongziName +
            ", nongziUuidNumber=" + nongziUuidNumber +
            ", nongziPhoto=" + nongziPhoto +
            ", nongziTypes=" + nongziTypes +
            ", nongziKucunNumber=" + nongziKucunNumber +
            ", nongziNewMoney=" + nongziNewMoney +
            ", nongziClicknum=" + nongziClicknum +
            ", nongziContent=" + nongziContent +
            ", nongziDelete=" + nongziDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
