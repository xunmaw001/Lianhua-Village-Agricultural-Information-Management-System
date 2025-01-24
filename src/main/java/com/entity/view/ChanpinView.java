package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ChanpinEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 农产品
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("chanpin")
public class ChanpinView extends ChanpinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 农产品类型的值
	*/
	@ColumnInfo(comment="农产品类型的字典表值",type="varchar(200)")
	private String chanpinValue;

	//级联表 种植户
		/**
		* 种植户姓名
		*/

		@ColumnInfo(comment="种植户姓名",type="varchar(200)")
		private String zhongzhihuName;
		/**
		* 头像
		*/

		@ColumnInfo(comment="头像",type="varchar(255)")
		private String zhongzhihuPhoto;
		/**
		* 种植户手机号
		*/

		@ColumnInfo(comment="种植户手机号",type="varchar(200)")
		private String zhongzhihuPhone;
		/**
		* 种植户身份证号
		*/

		@ColumnInfo(comment="种植户身份证号",type="varchar(200)")
		private String zhongzhihuIdNumber;
		/**
		* 邮箱
		*/

		@ColumnInfo(comment="邮箱",type="varchar(200)")
		private String zhongzhihuEmail;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;



	public ChanpinView() {

	}

	public ChanpinView(ChanpinEntity chanpinEntity) {
		try {
			BeanUtils.copyProperties(this, chanpinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 农产品类型的值
	*/
	public String getChanpinValue() {
		return chanpinValue;
	}
	/**
	* 设置： 农产品类型的值
	*/
	public void setChanpinValue(String chanpinValue) {
		this.chanpinValue = chanpinValue;
	}


	//级联表的get和set 种植户

		/**
		* 获取： 种植户姓名
		*/
		public String getZhongzhihuName() {
			return zhongzhihuName;
		}
		/**
		* 设置： 种植户姓名
		*/
		public void setZhongzhihuName(String zhongzhihuName) {
			this.zhongzhihuName = zhongzhihuName;
		}

		/**
		* 获取： 头像
		*/
		public String getZhongzhihuPhoto() {
			return zhongzhihuPhoto;
		}
		/**
		* 设置： 头像
		*/
		public void setZhongzhihuPhoto(String zhongzhihuPhoto) {
			this.zhongzhihuPhoto = zhongzhihuPhoto;
		}

		/**
		* 获取： 种植户手机号
		*/
		public String getZhongzhihuPhone() {
			return zhongzhihuPhone;
		}
		/**
		* 设置： 种植户手机号
		*/
		public void setZhongzhihuPhone(String zhongzhihuPhone) {
			this.zhongzhihuPhone = zhongzhihuPhone;
		}

		/**
		* 获取： 种植户身份证号
		*/
		public String getZhongzhihuIdNumber() {
			return zhongzhihuIdNumber;
		}
		/**
		* 设置： 种植户身份证号
		*/
		public void setZhongzhihuIdNumber(String zhongzhihuIdNumber) {
			this.zhongzhihuIdNumber = zhongzhihuIdNumber;
		}

		/**
		* 获取： 邮箱
		*/
		public String getZhongzhihuEmail() {
			return zhongzhihuEmail;
		}
		/**
		* 设置： 邮箱
		*/
		public void setZhongzhihuEmail(String zhongzhihuEmail) {
			this.zhongzhihuEmail = zhongzhihuEmail;
		}

		/**
		* 获取： 余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}


	@Override
	public String toString() {
		return "ChanpinView{" +
			", chanpinValue=" + chanpinValue +
			", zhongzhihuName=" + zhongzhihuName +
			", zhongzhihuPhoto=" + zhongzhihuPhoto +
			", zhongzhihuPhone=" + zhongzhihuPhone +
			", zhongzhihuIdNumber=" + zhongzhihuIdNumber +
			", zhongzhihuEmail=" + zhongzhihuEmail +
			", newMoney=" + newMoney +
			"} " + super.toString();
	}
}
