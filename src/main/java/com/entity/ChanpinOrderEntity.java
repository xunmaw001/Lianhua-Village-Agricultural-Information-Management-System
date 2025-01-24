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
 * 农产品订单
 *
 * @author 
 * @email
 */
@TableName("chanpin_order")
public class ChanpinOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChanpinOrderEntity() {

	}

	public ChanpinOrderEntity(T t) {
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
     * 收货地址
     */
    @ColumnInfo(comment="收货地址",type="int(11)")
    @TableField(value = "address_id")

    private Integer addressId;


    /**
     * 订单编号
     */
    @ColumnInfo(comment="订单编号",type="varchar(200)")
    @TableField(value = "chanpin_order_uuid_number")

    private String chanpinOrderUuidNumber;


    /**
     * 农产品
     */
    @ColumnInfo(comment="农产品",type="int(11)")
    @TableField(value = "chanpin_id")

    private Integer chanpinId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 购买数量
     */
    @ColumnInfo(comment="购买数量",type="int(11)")
    @TableField(value = "buy_number")

    private Integer buyNumber;


    /**
     * 实付价格
     */
    @ColumnInfo(comment="实付价格",type="decimal(10,2)")
    @TableField(value = "chanpin_order_true_price")

    private Double chanpinOrderTruePrice;


    /**
     * 快递公司
     */
    @ColumnInfo(comment="快递公司",type="varchar(200)")
    @TableField(value = "chanpin_order_courier_name")

    private String chanpinOrderCourierName;


    /**
     * 快递单号
     */
    @ColumnInfo(comment="快递单号",type="varchar(200)")
    @TableField(value = "chanpin_order_courier_number")

    private String chanpinOrderCourierNumber;


    /**
     * 订单类型
     */
    @ColumnInfo(comment="订单类型",type="int(11)")
    @TableField(value = "chanpin_order_types")

    private Integer chanpinOrderTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="订单创建时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
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
	 * 获取：收货地址
	 */
    public Integer getAddressId() {
        return addressId;
    }
    /**
	 * 设置：收货地址
	 */

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    /**
	 * 获取：订单编号
	 */
    public String getChanpinOrderUuidNumber() {
        return chanpinOrderUuidNumber;
    }
    /**
	 * 设置：订单编号
	 */

    public void setChanpinOrderUuidNumber(String chanpinOrderUuidNumber) {
        this.chanpinOrderUuidNumber = chanpinOrderUuidNumber;
    }
    /**
	 * 获取：农产品
	 */
    public Integer getChanpinId() {
        return chanpinId;
    }
    /**
	 * 设置：农产品
	 */

    public void setChanpinId(Integer chanpinId) {
        this.chanpinId = chanpinId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
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
	 * 获取：实付价格
	 */
    public Double getChanpinOrderTruePrice() {
        return chanpinOrderTruePrice;
    }
    /**
	 * 设置：实付价格
	 */

    public void setChanpinOrderTruePrice(Double chanpinOrderTruePrice) {
        this.chanpinOrderTruePrice = chanpinOrderTruePrice;
    }
    /**
	 * 获取：快递公司
	 */
    public String getChanpinOrderCourierName() {
        return chanpinOrderCourierName;
    }
    /**
	 * 设置：快递公司
	 */

    public void setChanpinOrderCourierName(String chanpinOrderCourierName) {
        this.chanpinOrderCourierName = chanpinOrderCourierName;
    }
    /**
	 * 获取：快递单号
	 */
    public String getChanpinOrderCourierNumber() {
        return chanpinOrderCourierNumber;
    }
    /**
	 * 设置：快递单号
	 */

    public void setChanpinOrderCourierNumber(String chanpinOrderCourierNumber) {
        this.chanpinOrderCourierNumber = chanpinOrderCourierNumber;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getChanpinOrderTypes() {
        return chanpinOrderTypes;
    }
    /**
	 * 设置：订单类型
	 */

    public void setChanpinOrderTypes(Integer chanpinOrderTypes) {
        this.chanpinOrderTypes = chanpinOrderTypes;
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
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ChanpinOrder{" +
            ", id=" + id +
            ", addressId=" + addressId +
            ", chanpinOrderUuidNumber=" + chanpinOrderUuidNumber +
            ", chanpinId=" + chanpinId +
            ", yonghuId=" + yonghuId +
            ", buyNumber=" + buyNumber +
            ", chanpinOrderTruePrice=" + chanpinOrderTruePrice +
            ", chanpinOrderCourierName=" + chanpinOrderCourierName +
            ", chanpinOrderCourierNumber=" + chanpinOrderCourierNumber +
            ", chanpinOrderTypes=" + chanpinOrderTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
