package com.entity.vo;

import com.entity.NongziEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 农资
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("nongzi")
public class NongziVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 农资名称
     */

    @TableField(value = "nongzi_name")
    private String nongziName;


    /**
     * 农资编号
     */

    @TableField(value = "nongzi_uuid_number")
    private String nongziUuidNumber;


    /**
     * 农资照片
     */

    @TableField(value = "nongzi_photo")
    private String nongziPhoto;


    /**
     * 农资类型
     */

    @TableField(value = "nongzi_types")
    private Integer nongziTypes;


    /**
     * 农资库存
     */

    @TableField(value = "nongzi_kucun_number")
    private Integer nongziKucunNumber;


    /**
     * 金额
     */

    @TableField(value = "nongzi_new_money")
    private Double nongziNewMoney;


    /**
     * 农资热度
     */

    @TableField(value = "nongzi_clicknum")
    private Integer nongziClicknum;


    /**
     * 农资介绍
     */

    @TableField(value = "nongzi_content")
    private String nongziContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "nongzi_delete")
    private Integer nongziDelete;


    /**
     * 录入时间
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
	 * 设置：农资名称
	 */
    public String getNongziName() {
        return nongziName;
    }


    /**
	 * 获取：农资名称
	 */

    public void setNongziName(String nongziName) {
        this.nongziName = nongziName;
    }
    /**
	 * 设置：农资编号
	 */
    public String getNongziUuidNumber() {
        return nongziUuidNumber;
    }


    /**
	 * 获取：农资编号
	 */

    public void setNongziUuidNumber(String nongziUuidNumber) {
        this.nongziUuidNumber = nongziUuidNumber;
    }
    /**
	 * 设置：农资照片
	 */
    public String getNongziPhoto() {
        return nongziPhoto;
    }


    /**
	 * 获取：农资照片
	 */

    public void setNongziPhoto(String nongziPhoto) {
        this.nongziPhoto = nongziPhoto;
    }
    /**
	 * 设置：农资类型
	 */
    public Integer getNongziTypes() {
        return nongziTypes;
    }


    /**
	 * 获取：农资类型
	 */

    public void setNongziTypes(Integer nongziTypes) {
        this.nongziTypes = nongziTypes;
    }
    /**
	 * 设置：农资库存
	 */
    public Integer getNongziKucunNumber() {
        return nongziKucunNumber;
    }


    /**
	 * 获取：农资库存
	 */

    public void setNongziKucunNumber(Integer nongziKucunNumber) {
        this.nongziKucunNumber = nongziKucunNumber;
    }
    /**
	 * 设置：金额
	 */
    public Double getNongziNewMoney() {
        return nongziNewMoney;
    }


    /**
	 * 获取：金额
	 */

    public void setNongziNewMoney(Double nongziNewMoney) {
        this.nongziNewMoney = nongziNewMoney;
    }
    /**
	 * 设置：农资热度
	 */
    public Integer getNongziClicknum() {
        return nongziClicknum;
    }


    /**
	 * 获取：农资热度
	 */

    public void setNongziClicknum(Integer nongziClicknum) {
        this.nongziClicknum = nongziClicknum;
    }
    /**
	 * 设置：农资介绍
	 */
    public String getNongziContent() {
        return nongziContent;
    }


    /**
	 * 获取：农资介绍
	 */

    public void setNongziContent(String nongziContent) {
        this.nongziContent = nongziContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getNongziDelete() {
        return nongziDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setNongziDelete(Integer nongziDelete) {
        this.nongziDelete = nongziDelete;
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
