package com.entity.vo;

import com.entity.NongziOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 农资订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("nongzi_order")
public class NongziOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单编号
     */

    @TableField(value = "nongzi_order_uuid_number")
    private String nongziOrderUuidNumber;


    /**
     * 农资
     */

    @TableField(value = "nongzi_id")
    private Integer nongziId;


    /**
     * 种植户
     */

    @TableField(value = "zhongzhihu_id")
    private Integer zhongzhihuId;


    /**
     * 购买数量
     */

    @TableField(value = "buy_number")
    private Integer buyNumber;


    /**
     * 地址
     */

    @TableField(value = "nongzi_order_dizhi")
    private String nongziOrderDizhi;


    /**
     * 实付价格
     */

    @TableField(value = "nongzi_order_true_price")
    private Double nongziOrderTruePrice;


    /**
     * 快递公司
     */

    @TableField(value = "nongzi_order_courier_name")
    private String nongziOrderCourierName;


    /**
     * 快递单号
     */

    @TableField(value = "nongzi_order_courier_number")
    private String nongziOrderCourierNumber;


    /**
     * 订单类型
     */

    @TableField(value = "nongzi_order_types")
    private Integer nongziOrderTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
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
	 * 设置：订单编号
	 */
    public String getNongziOrderUuidNumber() {
        return nongziOrderUuidNumber;
    }


    /**
	 * 获取：订单编号
	 */

    public void setNongziOrderUuidNumber(String nongziOrderUuidNumber) {
        this.nongziOrderUuidNumber = nongziOrderUuidNumber;
    }
    /**
	 * 设置：农资
	 */
    public Integer getNongziId() {
        return nongziId;
    }


    /**
	 * 获取：农资
	 */

    public void setNongziId(Integer nongziId) {
        this.nongziId = nongziId;
    }
    /**
	 * 设置：种植户
	 */
    public Integer getZhongzhihuId() {
        return zhongzhihuId;
    }


    /**
	 * 获取：种植户
	 */

    public void setZhongzhihuId(Integer zhongzhihuId) {
        this.zhongzhihuId = zhongzhihuId;
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
	 * 设置：地址
	 */
    public String getNongziOrderDizhi() {
        return nongziOrderDizhi;
    }


    /**
	 * 获取：地址
	 */

    public void setNongziOrderDizhi(String nongziOrderDizhi) {
        this.nongziOrderDizhi = nongziOrderDizhi;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getNongziOrderTruePrice() {
        return nongziOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setNongziOrderTruePrice(Double nongziOrderTruePrice) {
        this.nongziOrderTruePrice = nongziOrderTruePrice;
    }
    /**
	 * 设置：快递公司
	 */
    public String getNongziOrderCourierName() {
        return nongziOrderCourierName;
    }


    /**
	 * 获取：快递公司
	 */

    public void setNongziOrderCourierName(String nongziOrderCourierName) {
        this.nongziOrderCourierName = nongziOrderCourierName;
    }
    /**
	 * 设置：快递单号
	 */
    public String getNongziOrderCourierNumber() {
        return nongziOrderCourierNumber;
    }


    /**
	 * 获取：快递单号
	 */

    public void setNongziOrderCourierNumber(String nongziOrderCourierNumber) {
        this.nongziOrderCourierNumber = nongziOrderCourierNumber;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getNongziOrderTypes() {
        return nongziOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setNongziOrderTypes(Integer nongziOrderTypes) {
        this.nongziOrderTypes = nongziOrderTypes;
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
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
