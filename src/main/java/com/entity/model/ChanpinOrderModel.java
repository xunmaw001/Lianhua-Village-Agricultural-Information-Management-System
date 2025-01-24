package com.entity.model;

import com.entity.ChanpinOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 农产品订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChanpinOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 收货地址
     */
    private Integer addressId;


    /**
     * 订单编号
     */
    private String chanpinOrderUuidNumber;


    /**
     * 农产品
     */
    private Integer chanpinId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 购买数量
     */
    private Integer buyNumber;


    /**
     * 实付价格
     */
    private Double chanpinOrderTruePrice;


    /**
     * 快递公司
     */
    private String chanpinOrderCourierName;


    /**
     * 快递单号
     */
    private String chanpinOrderCourierNumber;


    /**
     * 订单类型
     */
    private Integer chanpinOrderTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
