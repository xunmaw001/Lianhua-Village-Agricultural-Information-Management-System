package com.entity.vo;

import com.entity.JishuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 农业技术
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jishu")
public class JishuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 农作物名称
     */

    @TableField(value = "jishu_name")
    private String jishuName;


    /**
     * 农作物编号
     */

    @TableField(value = "jishu_uuid_number")
    private String jishuUuidNumber;


    /**
     * 农作物照片
     */

    @TableField(value = "jishu_photo")
    private String jishuPhoto;


    /**
     * 农作物类型
     */

    @TableField(value = "jishu_types")
    private Integer jishuTypes;


    /**
     * 农作物视频
     */

    @TableField(value = "jishu_video")
    private String jishuVideo;


    /**
     * 作用
     */

    @TableField(value = "jishu_zuoyong")
    private String jishuZuoyong;


    /**
     * 产地
     */

    @TableField(value = "jishu_candi")
    private String jishuCandi;


    /**
     * 适宜温度
     */

    @TableField(value = "jishu_wendu")
    private String jishuWendu;


    /**
     * 适宜湿度
     */

    @TableField(value = "jishu_shidu")
    private String jishuShidu;


    /**
     * 日照时长
     */

    @TableField(value = "jishu_rizhao")
    private String jishuRizhao;


    /**
     * 营养价值
     */

    @TableField(value = "jishu_jiazhi")
    private String jishuJiazhi;


    /**
     * 农作物介绍
     */

    @TableField(value = "jishu_content")
    private String jishuContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "jishu_delete")
    private Integer jishuDelete;


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
	 * 设置：农作物名称
	 */
    public String getJishuName() {
        return jishuName;
    }


    /**
	 * 获取：农作物名称
	 */

    public void setJishuName(String jishuName) {
        this.jishuName = jishuName;
    }
    /**
	 * 设置：农作物编号
	 */
    public String getJishuUuidNumber() {
        return jishuUuidNumber;
    }


    /**
	 * 获取：农作物编号
	 */

    public void setJishuUuidNumber(String jishuUuidNumber) {
        this.jishuUuidNumber = jishuUuidNumber;
    }
    /**
	 * 设置：农作物照片
	 */
    public String getJishuPhoto() {
        return jishuPhoto;
    }


    /**
	 * 获取：农作物照片
	 */

    public void setJishuPhoto(String jishuPhoto) {
        this.jishuPhoto = jishuPhoto;
    }
    /**
	 * 设置：农作物类型
	 */
    public Integer getJishuTypes() {
        return jishuTypes;
    }


    /**
	 * 获取：农作物类型
	 */

    public void setJishuTypes(Integer jishuTypes) {
        this.jishuTypes = jishuTypes;
    }
    /**
	 * 设置：农作物视频
	 */
    public String getJishuVideo() {
        return jishuVideo;
    }


    /**
	 * 获取：农作物视频
	 */

    public void setJishuVideo(String jishuVideo) {
        this.jishuVideo = jishuVideo;
    }
    /**
	 * 设置：作用
	 */
    public String getJishuZuoyong() {
        return jishuZuoyong;
    }


    /**
	 * 获取：作用
	 */

    public void setJishuZuoyong(String jishuZuoyong) {
        this.jishuZuoyong = jishuZuoyong;
    }
    /**
	 * 设置：产地
	 */
    public String getJishuCandi() {
        return jishuCandi;
    }


    /**
	 * 获取：产地
	 */

    public void setJishuCandi(String jishuCandi) {
        this.jishuCandi = jishuCandi;
    }
    /**
	 * 设置：适宜温度
	 */
    public String getJishuWendu() {
        return jishuWendu;
    }


    /**
	 * 获取：适宜温度
	 */

    public void setJishuWendu(String jishuWendu) {
        this.jishuWendu = jishuWendu;
    }
    /**
	 * 设置：适宜湿度
	 */
    public String getJishuShidu() {
        return jishuShidu;
    }


    /**
	 * 获取：适宜湿度
	 */

    public void setJishuShidu(String jishuShidu) {
        this.jishuShidu = jishuShidu;
    }
    /**
	 * 设置：日照时长
	 */
    public String getJishuRizhao() {
        return jishuRizhao;
    }


    /**
	 * 获取：日照时长
	 */

    public void setJishuRizhao(String jishuRizhao) {
        this.jishuRizhao = jishuRizhao;
    }
    /**
	 * 设置：营养价值
	 */
    public String getJishuJiazhi() {
        return jishuJiazhi;
    }


    /**
	 * 获取：营养价值
	 */

    public void setJishuJiazhi(String jishuJiazhi) {
        this.jishuJiazhi = jishuJiazhi;
    }
    /**
	 * 设置：农作物介绍
	 */
    public String getJishuContent() {
        return jishuContent;
    }


    /**
	 * 获取：农作物介绍
	 */

    public void setJishuContent(String jishuContent) {
        this.jishuContent = jishuContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getJishuDelete() {
        return jishuDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setJishuDelete(Integer jishuDelete) {
        this.jishuDelete = jishuDelete;
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
