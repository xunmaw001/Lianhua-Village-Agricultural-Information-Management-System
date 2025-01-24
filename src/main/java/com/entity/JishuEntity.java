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
 * 农业技术
 *
 * @author 
 * @email
 */
@TableName("jishu")
public class JishuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JishuEntity() {

	}

	public JishuEntity(T t) {
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
     * 农作物名称
     */
    @ColumnInfo(comment="农作物名称",type="varchar(200)")
    @TableField(value = "jishu_name")

    private String jishuName;


    /**
     * 农作物编号
     */
    @ColumnInfo(comment="农作物编号",type="varchar(200)")
    @TableField(value = "jishu_uuid_number")

    private String jishuUuidNumber;


    /**
     * 农作物照片
     */
    @ColumnInfo(comment="农作物照片",type="varchar(200)")
    @TableField(value = "jishu_photo")

    private String jishuPhoto;


    /**
     * 农作物类型
     */
    @ColumnInfo(comment="农作物类型",type="int(11)")
    @TableField(value = "jishu_types")

    private Integer jishuTypes;


    /**
     * 农作物视频
     */
    @ColumnInfo(comment="农作物视频",type="varchar(200)")
    @TableField(value = "jishu_video")

    private String jishuVideo;


    /**
     * 作用
     */
    @ColumnInfo(comment="作用",type="varchar(200)")
    @TableField(value = "jishu_zuoyong")

    private String jishuZuoyong;


    /**
     * 产地
     */
    @ColumnInfo(comment="产地",type="varchar(200)")
    @TableField(value = "jishu_candi")

    private String jishuCandi;


    /**
     * 适宜温度
     */
    @ColumnInfo(comment="适宜温度",type="varchar(200)")
    @TableField(value = "jishu_wendu")

    private String jishuWendu;


    /**
     * 适宜湿度
     */
    @ColumnInfo(comment="适宜湿度",type="varchar(200)")
    @TableField(value = "jishu_shidu")

    private String jishuShidu;


    /**
     * 日照时长
     */
    @ColumnInfo(comment="日照时长",type="varchar(200)")
    @TableField(value = "jishu_rizhao")

    private String jishuRizhao;


    /**
     * 营养价值
     */
    @ColumnInfo(comment="营养价值",type="varchar(200)")
    @TableField(value = "jishu_jiazhi")

    private String jishuJiazhi;


    /**
     * 农作物介绍
     */
    @ColumnInfo(comment="农作物介绍",type="longtext")
    @TableField(value = "jishu_content")

    private String jishuContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "jishu_delete")

    private Integer jishuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
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
	 * 获取：农作物名称
	 */
    public String getJishuName() {
        return jishuName;
    }
    /**
	 * 设置：农作物名称
	 */

    public void setJishuName(String jishuName) {
        this.jishuName = jishuName;
    }
    /**
	 * 获取：农作物编号
	 */
    public String getJishuUuidNumber() {
        return jishuUuidNumber;
    }
    /**
	 * 设置：农作物编号
	 */

    public void setJishuUuidNumber(String jishuUuidNumber) {
        this.jishuUuidNumber = jishuUuidNumber;
    }
    /**
	 * 获取：农作物照片
	 */
    public String getJishuPhoto() {
        return jishuPhoto;
    }
    /**
	 * 设置：农作物照片
	 */

    public void setJishuPhoto(String jishuPhoto) {
        this.jishuPhoto = jishuPhoto;
    }
    /**
	 * 获取：农作物类型
	 */
    public Integer getJishuTypes() {
        return jishuTypes;
    }
    /**
	 * 设置：农作物类型
	 */

    public void setJishuTypes(Integer jishuTypes) {
        this.jishuTypes = jishuTypes;
    }
    /**
	 * 获取：农作物视频
	 */
    public String getJishuVideo() {
        return jishuVideo;
    }
    /**
	 * 设置：农作物视频
	 */

    public void setJishuVideo(String jishuVideo) {
        this.jishuVideo = jishuVideo;
    }
    /**
	 * 获取：作用
	 */
    public String getJishuZuoyong() {
        return jishuZuoyong;
    }
    /**
	 * 设置：作用
	 */

    public void setJishuZuoyong(String jishuZuoyong) {
        this.jishuZuoyong = jishuZuoyong;
    }
    /**
	 * 获取：产地
	 */
    public String getJishuCandi() {
        return jishuCandi;
    }
    /**
	 * 设置：产地
	 */

    public void setJishuCandi(String jishuCandi) {
        this.jishuCandi = jishuCandi;
    }
    /**
	 * 获取：适宜温度
	 */
    public String getJishuWendu() {
        return jishuWendu;
    }
    /**
	 * 设置：适宜温度
	 */

    public void setJishuWendu(String jishuWendu) {
        this.jishuWendu = jishuWendu;
    }
    /**
	 * 获取：适宜湿度
	 */
    public String getJishuShidu() {
        return jishuShidu;
    }
    /**
	 * 设置：适宜湿度
	 */

    public void setJishuShidu(String jishuShidu) {
        this.jishuShidu = jishuShidu;
    }
    /**
	 * 获取：日照时长
	 */
    public String getJishuRizhao() {
        return jishuRizhao;
    }
    /**
	 * 设置：日照时长
	 */

    public void setJishuRizhao(String jishuRizhao) {
        this.jishuRizhao = jishuRizhao;
    }
    /**
	 * 获取：营养价值
	 */
    public String getJishuJiazhi() {
        return jishuJiazhi;
    }
    /**
	 * 设置：营养价值
	 */

    public void setJishuJiazhi(String jishuJiazhi) {
        this.jishuJiazhi = jishuJiazhi;
    }
    /**
	 * 获取：农作物介绍
	 */
    public String getJishuContent() {
        return jishuContent;
    }
    /**
	 * 设置：农作物介绍
	 */

    public void setJishuContent(String jishuContent) {
        this.jishuContent = jishuContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getJishuDelete() {
        return jishuDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setJishuDelete(Integer jishuDelete) {
        this.jishuDelete = jishuDelete;
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

    @Override
    public String toString() {
        return "Jishu{" +
            ", id=" + id +
            ", jishuName=" + jishuName +
            ", jishuUuidNumber=" + jishuUuidNumber +
            ", jishuPhoto=" + jishuPhoto +
            ", jishuTypes=" + jishuTypes +
            ", jishuVideo=" + jishuVideo +
            ", jishuZuoyong=" + jishuZuoyong +
            ", jishuCandi=" + jishuCandi +
            ", jishuWendu=" + jishuWendu +
            ", jishuShidu=" + jishuShidu +
            ", jishuRizhao=" + jishuRizhao +
            ", jishuJiazhi=" + jishuJiazhi +
            ", jishuContent=" + jishuContent +
            ", jishuDelete=" + jishuDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
