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
 * 农资订单
 *
 * @author 
 * @email
 */
@TableName("nongzi_order")
public class NongziOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public NongziOrderEntity() {

	}

	public NongziOrderEntity(T t) {
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
     * 订单编号
     */
    @ColumnInfo(comment="订单编号",type="varchar(200)")
    @TableField(value = "nongzi_order_uuid_number")

    private String nongziOrderUuidNumber;


    /**
     * 农资
     */
    @ColumnInfo(comment="农资",type="int(11)")
    @TableField(value = "nongzi_id")

    private Integer nongziId;


    /**
     * 种植户
     */
    @ColumnInfo(comment="种植户",type="int(11)")
    @TableField(value = "zhongzhihu_id")

    private Integer zhongzhihuId;


    /**
     * 购买数量
     */
    @ColumnInfo(comment="购买数量",type="int(11)")
    @TableField(value = "buy_number")

    private Integer buyNumber;


    /**
     * 地址
     */
    @ColumnInfo(comment="地址",type="varchar(200)")
    @TableField(value = "nongzi_order_dizhi")

    private String nongziOrderDizhi;


    /**
     * 实付价格
     */
    @ColumnInfo(comment="实付价格",type="decimal(10,2)")
    @TableField(value = "nongzi_order_true_price")

    private Double nongziOrderTruePrice;


    /**
     * 快递公司
     */
    @ColumnInfo(comment="快递公司",type="varchar(200)")
    @TableField(value = "nongzi_order_courier_name")

    private String nongziOrderCourierName;


    /**
     * 快递单号
     */
    @ColumnInfo(comment="快递单号",type="varchar(200)")
    @TableField(value = "nongzi_order_courier_number")

    private String nongziOrderCourierNumber;


    /**
     * 订单类型
     */
    @ColumnInfo(comment="订单类型",type="int(11)")
    @TableField(value = "nongzi_order_types")

    private Integer nongziOrderTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="订单创建时间",type="timestamp")
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
	 * 获取：订单编号
	 */
    public String getNongziOrderUuidNumber() {
        return nongziOrderUuidNumber;
    }
    /**
	 * 设置：订单编号
	 */

    public void setNongziOrderUuidNumber(String nongziOrderUuidNumber) {
        this.nongziOrderUuidNumber = nongziOrderUuidNumber;
    }
    /**
	 * 获取：农资
	 */
    public Integer getNongziId() {
        return nongziId;
    }
    /**
	 * 设置：农资
	 */

    public void setNongziId(Integer nongziId) {
        this.nongziId = nongziId;
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
	 * 获取：购买数量
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }
    /**
	 * 设置：购买数量
	 */

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 获取：地址
	 */
    public String getNongziOrderDizhi() {
        return nongziOrderDizhi;
    }
    /**
	 * 设置：地址
	 */

    public void setNongziOrderDizhi(String nongziOrderDizhi) {
        this.nongziOrderDizhi = nongziOrderDizhi;
    }
    /**
	 * 获取：实付价格
	 */
    public Double getNongziOrderTruePrice() {
        return nongziOrderTruePrice;
    }
    /**
	 * 设置：实付价格
	 */

    public void setNongziOrderTruePrice(Double nongziOrderTruePrice) {
        this.nongziOrderTruePrice = nongziOrderTruePrice;
    }
    /**
	 * 获取：快递公司
	 */
    public String getNongziOrderCourierName() {
        return nongziOrderCourierName;
    }
    /**
	 * 设置：快递公司
	 */

    public void setNongziOrderCourierName(String nongziOrderCourierName) {
        this.nongziOrderCourierName = nongziOrderCourierName;
    }
    /**
	 * 获取：快递单号
	 */
    public String getNongziOrderCourierNumber() {
        return nongziOrderCourierNumber;
    }
    /**
	 * 设置：快递单号
	 */

    public void setNongziOrderCourierNumber(String nongziOrderCourierNumber) {
        this.nongziOrderCourierNumber = nongziOrderCourierNumber;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getNongziOrderTypes() {
        return nongziOrderTypes;
    }
    /**
	 * 设置：订单类型
	 */

    public void setNongziOrderTypes(Integer nongziOrderTypes) {
        this.nongziOrderTypes = nongziOrderTypes;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：订单创建时间
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
        return "NongziOrder{" +
            ", id=" + id +
            ", nongziOrderUuidNumber=" + nongziOrderUuidNumber +
            ", nongziId=" + nongziId +
            ", zhongzhihuId=" + zhongzhihuId +
            ", buyNumber=" + buyNumber +
            ", nongziOrderDizhi=" + nongziOrderDizhi +
            ", nongziOrderTruePrice=" + nongziOrderTruePrice +
            ", nongziOrderCourierName=" + nongziOrderCourierName +
            ", nongziOrderCourierNumber=" + nongziOrderCourierNumber +
            ", nongziOrderTypes=" + nongziOrderTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
