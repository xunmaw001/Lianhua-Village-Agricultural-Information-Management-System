package com.entity.model;

import com.entity.JishuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 农业技术
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JishuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 农作物名称
     */
    private String jishuName;


    /**
     * 农作物编号
     */
    private String jishuUuidNumber;


    /**
     * 农作物照片
     */
    private String jishuPhoto;


    /**
     * 农作物类型
     */
    private Integer jishuTypes;


    /**
     * 农作物视频
     */
    private String jishuVideo;


    /**
     * 作用
     */
    private String jishuZuoyong;


    /**
     * 产地
     */
    private String jishuCandi;


    /**
     * 适宜温度
     */
    private String jishuWendu;


    /**
     * 适宜湿度
     */
    private String jishuShidu;


    /**
     * 日照时长
     */
    private String jishuRizhao;


    /**
     * 营养价值
     */
    private String jishuJiazhi;


    /**
     * 农作物介绍
     */
    private String jishuContent;


    /**
     * 逻辑删除
     */
    private Integer jishuDelete;


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
