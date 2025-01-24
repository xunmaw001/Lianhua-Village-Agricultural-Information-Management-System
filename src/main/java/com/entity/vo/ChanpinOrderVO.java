package com.entity.vo;

import com.entity.ChanpinOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 农产品订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chanpin_order")
public class ChanpinOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 收货地址
     */

    @TableField(value = "address_id")
    private Integer addressId;


    /**
     * 订单编号
     */

    @TableField(value = "chanpin_order_uuid_number")
    private String chanpinOrderUuidNumber;


    /**
     * 农产品
     */

    @TableField(value = "chanpin_id")
    private Integer chanpinId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 购买数量
     */

    @TableField(value = "buy_number")
    private Integer buyNumber;


    /**
     * 实付价格
     */

    @TableField(value = "chanpin_order_true_price")
    private Double chanpinOrderTruePrice;


    /**
     * 快递公司
     */

    @TableField(value = "chanpin_order_courier_name")
    private String chanpinOrderCourierName;


    /**
     * 快递单号
     */

    @TableField(value = "chanpin_order_courier_number")
    private String chanpinOrderCourierNumber;


    /**
     * 订单类型
     */

    @TableField(value = "chanpin_order_types")
    private Integer chanpinOrderTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：收货地址
	 */
    public Integer getAddressId() {
        return addressId;
    }


    /**
	 * 获取：收货地址
	 */

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    /**
	 * 设置：订单编号
	 */
    public String getChanpinOrderUuidNumber() {
        return chanpinOrderUuidNumber;
    }


    /**
	 * 获取：订单编号
	 */

    public void setChanpinOrderUuidNumber(String chanpinOrderUuidNumber) {
        this.chanpinOrderUuidNumber = chanpinOrderUuidNumber;
    }
    /**
	 * 设置：农产品
	 */
    public Integer getChanpinId() {
        return chanpinId;
    }


    /**
	 * 获取：农产品
	 */

    public void setChanpinId(Integer chanpinId) {
        this.chanpinId = chanpinId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：购买数量
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }


    /**
	 * 获取：购买数量
	 */

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getChanpinOrderTruePrice() {
        return chanpinOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setChanpinOrderTruePrice(Double chanpinOrderTruePrice) {
        this.chanpinOrderTruePrice = chanpinOrderTruePrice;
    }
    /**
	 * 设置：快递公司
	 */
    public String getChanpinOrderCourierName() {
        return chanpinOrderCourierName;
    }


    /**
	 * 获取：快递公司
	 */

    public void setChanpinOrderCourierName(String chanpinOrderCourierName) {
        this.chanpinOrderCourierName = chanpinOrderCourierName;
    }
    /**
	 * 设置：快递单号
	 */
    public String getChanpinOrderCourierNumber() {
        return chanpinOrderCourierNumber;
    }


    /**
	 * 获取：快递单号
	 */

    public void setChanpinOrderCourierNumber(String chanpinOrderCourierNumber) {
        this.chanpinOrderCourierNumber = chanpinOrderCourierNumber;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getChanpinOrderTypes() {
        return chanpinOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setChanpinOrderTypes(Integer chanpinOrderTypes) {
        this.chanpinOrderTypes = chanpinOrderTypes;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
