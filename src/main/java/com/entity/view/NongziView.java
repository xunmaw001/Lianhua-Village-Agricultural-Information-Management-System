package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.NongziEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 农资
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("nongzi")
public class NongziView extends NongziEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 农资类型的值
	*/
	@ColumnInfo(comment="农资类型的字典表值",type="varchar(200)")
	private String nongziValue;




	public NongziView() {

	}

	public NongziView(NongziEntity nongziEntity) {
		try {
			BeanUtils.copyProperties(this, nongziEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 农资类型的值
	*/
	public String getNongziValue() {
		return nongziValue;
	}
	/**
	* 设置： 农资类型的值
	*/
	public void setNongziValue(String nongziValue) {
		this.nongziValue = nongziValue;
	}




	@Override
	public String toString() {
		return "NongziView{" +
			", nongziValue=" + nongziValue +
			"} " + super.toString();
	}
}
