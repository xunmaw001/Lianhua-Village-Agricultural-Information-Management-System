package com.entity.model;

import com.entity.NongziOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 农资订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class NongziOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单编号
     */
    private String nongziOrderUuidNumber;


    /**
     * 农资
     */
    private Integer nongziId;


    /**
     * 种植户
     */
    private Integer zhongzhihuId;


    /**
     * 购买数量
     */
    private Integer buyNumber;


    /**
     * 地址
     */
    private String nongziOrderDizhi;


    /**
     * 实付价格
     */
    private Double nongziOrderTruePrice;


    /**
     * 快递公司
     */
    private String nongziOrderCourierName;


    /**
     * 快递单号
     */
    private String nongziOrderCourierNumber;


    /**
     * 订单类型
     */
    private Integer nongziOrderTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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

    }
