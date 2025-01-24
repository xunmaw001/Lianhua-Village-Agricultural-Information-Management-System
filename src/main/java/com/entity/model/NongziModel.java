package com.entity.model;

import com.entity.NongziEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 农资
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class NongziModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 农资名称
     */
    private String nongziName;


    /**
     * 农资编号
     */
    private String nongziUuidNumber;


    /**
     * 农资照片
     */
    private String nongziPhoto;


    /**
     * 农资类型
     */
    private Integer nongziTypes;


    /**
     * 农资库存
     */
    private Integer nongziKucunNumber;


    /**
     * 金额
     */
    private Double nongziNewMoney;


    /**
     * 农资热度
     */
    private Integer nongziClicknum;


    /**
     * 农资介绍
     */
    private String nongziContent;


    /**
     * 逻辑删除
     */
    private Integer nongziDelete;


    /**
     * 录入时间
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

    }
