package com.entity.vo;

import com.entity.ChanpinEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 农产品
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chanpin")
public class ChanpinVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 种植户
     */

    @TableField(value = "zhongzhihu_id")
    private Integer zhongzhihuId;


    /**
     * 农产品名称
     */

    @TableField(value = "chanpin_name")
    private String chanpinName;


    /**
     * 农产品编号
     */

    @TableField(value = "chanpin_uuid_number")
    private String chanpinUuidNumber;


    /**
     * 农产品照片
     */

    @TableField(value = "chanpin_photo")
    private String chanpinPhoto;


    /**
     * 农产品类型
     */

    @TableField(value = "chanpin_types")
    private Integer chanpinTypes;


    /**
     * 农产品库存
     */

    @TableField(value = "chanpin_kucun_number")
    private Integer chanpinKucunNumber;


    /**
     * 金额
     */

    @TableField(value = "chanpin_new_money")
    private Double chanpinNewMoney;


    /**
     * 农产品热度
     */

    @TableField(value = "chanpin_clicknum")
    private Integer chanpinClicknum;


    /**
     * 农产品介绍
     */

    @TableField(value = "chanpin_content")
    private String chanpinContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "chanpin_delete")
    private Integer chanpinDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：农产品名称
	 */
    public String getChanpinName() {
        return chanpinName;
    }


    /**
	 * 获取：农产品名称
	 */

    public void setChanpinName(String chanpinName) {
        this.chanpinName = chanpinName;
    }
    /**
	 * 设置：农产品编号
	 */
    public String getChanpinUuidNumber() {
        return chanpinUuidNumber;
    }


    /**
	 * 获取：农产品编号
	 */

    public void setChanpinUuidNumber(String chanpinUuidNumber) {
        this.chanpinUuidNumber = chanpinUuidNumber;
    }
    /**
	 * 设置：农产品照片
	 */
    public String getChanpinPhoto() {
        return chanpinPhoto;
    }


    /**
	 * 获取：农产品照片
	 */

    public void setChanpinPhoto(String chanpinPhoto) {
        this.chanpinPhoto = chanpinPhoto;
    }
    /**
	 * 设置：农产品类型
	 */
    public Integer getChanpinTypes() {
        return chanpinTypes;
    }


    /**
	 * 获取：农产品类型
	 */

    public void setChanpinTypes(Integer chanpinTypes) {
        this.chanpinTypes = chanpinTypes;
    }
    /**
	 * 设置：农产品库存
	 */
    public Integer getChanpinKucunNumber() {
        return chanpinKucunNumber;
    }


    /**
	 * 获取：农产品库存
	 */

    public void setChanpinKucunNumber(Integer chanpinKucunNumber) {
        this.chanpinKucunNumber = chanpinKucunNumber;
    }
    /**
	 * 设置：金额
	 */
    public Double getChanpinNewMoney() {
        return chanpinNewMoney;
    }


    /**
	 * 获取：金额
	 */

    public void setChanpinNewMoney(Double chanpinNewMoney) {
        this.chanpinNewMoney = chanpinNewMoney;
    }
    /**
	 * 设置：农产品热度
	 */
    public Integer getChanpinClicknum() {
        return chanpinClicknum;
    }


    /**
	 * 获取：农产品热度
	 */

    public void setChanpinClicknum(Integer chanpinClicknum) {
        this.chanpinClicknum = chanpinClicknum;
    }
    /**
	 * 设置：农产品介绍
	 */
    public String getChanpinContent() {
        return chanpinContent;
    }


    /**
	 * 获取：农产品介绍
	 */

    public void setChanpinContent(String chanpinContent) {
        this.chanpinContent = chanpinContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getChanpinDelete() {
        return chanpinDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setChanpinDelete(Integer chanpinDelete) {
        this.chanpinDelete = chanpinDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
