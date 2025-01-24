package com.entity.model;

import com.entity.ChanpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 农产品
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChanpinModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 种植户
     */
    private Integer zhongzhihuId;


    /**
     * 农产品名称
     */
    private String chanpinName;


    /**
     * 农产品编号
     */
    private String chanpinUuidNumber;


    /**
     * 农产品照片
     */
    private String chanpinPhoto;


    /**
     * 农产品类型
     */
    private Integer chanpinTypes;


    /**
     * 农产品库存
     */
    private Integer chanpinKucunNumber;


    /**
     * 金额
     */
    private Double chanpinNewMoney;


    /**
     * 农产品热度
     */
    private Integer chanpinClicknum;


    /**
     * 农产品介绍
     */
    private String chanpinContent;


    /**
     * 逻辑删除
     */
    private Integer chanpinDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
