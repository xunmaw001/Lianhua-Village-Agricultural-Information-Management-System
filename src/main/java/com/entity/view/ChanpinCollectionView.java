package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ChanpinCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 农产品收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("chanpin_collection")
public class ChanpinCollectionView extends ChanpinCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String chanpinCollectionValue;

	//级联表 农产品
					 
		/**
		* 农产品 的 种植户
		*/
		@ColumnInfo(comment="种植户",type="int(11)")
		private Integer chanpinZhongzhihuId;
		/**
		* 农产品名称
		*/

		@ColumnInfo(comment="农产品名称",type="varchar(200)")
		private String chanpinName;
		/**
		* 农产品编号
		*/

		@ColumnInfo(comment="农产品编号",type="varchar(200)")
		private String chanpinUuidNumber;
		/**
		* 农产品照片
		*/

		@ColumnInfo(comment="农产品照片",type="varchar(200)")
		private String chanpinPhoto;
		/**
		* 农产品类型
		*/
		@ColumnInfo(comment="农产品类型",type="int(11)")
		private Integer chanpinTypes;
			/**
			* 农产品类型的值
			*/
			@ColumnInfo(comment="农产品类型的字典表值",type="varchar(200)")
			private String chanpinValue;
		/**
		* 农产品库存
		*/

		@ColumnInfo(comment="农产品库存",type="int(11)")
		private Integer chanpinKucunNumber;
		/**
		* 金额
		*/
		@ColumnInfo(comment="金额",type="decimal(10,2)")
		private Double chanpinNewMoney;
		/**
		* 农产品热度
		*/

		@ColumnInfo(comment="农产品热度",type="int(11)")
		private Integer chanpinClicknum;
		/**
		* 农产品介绍
		*/

		@ColumnInfo(comment="农产品介绍",type="longtext")
		private String chanpinContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer chanpinDelete;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 头像
		*/

		@ColumnInfo(comment="头像",type="varchar(255)")
		private String yonghuPhoto;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 邮箱
		*/

		@ColumnInfo(comment="邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;



	public ChanpinCollectionView() {

	}

	public ChanpinCollectionView(ChanpinCollectionEntity chanpinCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, chanpinCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getChanpinCollectionValue() {
		return chanpinCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setChanpinCollectionValue(String chanpinCollectionValue) {
		this.chanpinCollectionValue = chanpinCollectionValue;
	}


	//级联表的get和set 农产品
		/**
		* 获取：农产品 的 种植户
		*/
		public Integer getChanpinZhongzhihuId() {
			return chanpinZhongzhihuId;
		}
		/**
		* 设置：农产品 的 种植户
		*/
		public void setChanpinZhongzhihuId(Integer chanpinZhongzhihuId) {
			this.chanpinZhongzhihuId = chanpinZhongzhihuId;
		}

		/**
		* 获取： 农产品名称
		*/
		public String getChanpinName() {
			return chanpinName;
		}
		/**
		* 设置： 农产品名称
		*/
		public void setChanpinName(String chanpinName) {
			this.chanpinName = chanpinName;
		}

		/**
		* 获取： 农产品编号
		*/
		public String getChanpinUuidNumber() {
			return chanpinUuidNumber;
		}
		/**
		* 设置： 农产品编号
		*/
		public void setChanpinUuidNumber(String chanpinUuidNumber) {
			this.chanpinUuidNumber = chanpinUuidNumber;
		}

		/**
		* 获取： 农产品照片
		*/
		public String getChanpinPhoto() {
			return chanpinPhoto;
		}
		/**
		* 设置： 农产品照片
		*/
		public void setChanpinPhoto(String chanpinPhoto) {
			this.chanpinPhoto = chanpinPhoto;
		}
		/**
		* 获取： 农产品类型
		*/
		public Integer getChanpinTypes() {
			return chanpinTypes;
		}
		/**
		* 设置： 农产品类型
		*/
		public void setChanpinTypes(Integer chanpinTypes) {
			this.chanpinTypes = chanpinTypes;
		}


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

		/**
		* 获取： 农产品库存
		*/
		public Integer getChanpinKucunNumber() {
			return chanpinKucunNumber;
		}
		/**
		* 设置： 农产品库存
		*/
		public void setChanpinKucunNumber(Integer chanpinKucunNumber) {
			this.chanpinKucunNumber = chanpinKucunNumber;
		}

		/**
		* 获取： 金额
		*/
		public Double getChanpinNewMoney() {
			return chanpinNewMoney;
		}
		/**
		* 设置： 金额
		*/
		public void setChanpinNewMoney(Double chanpinNewMoney) {
			this.chanpinNewMoney = chanpinNewMoney;
		}

		/**
		* 获取： 农产品热度
		*/
		public Integer getChanpinClicknum() {
			return chanpinClicknum;
		}
		/**
		* 设置： 农产品热度
		*/
		public void setChanpinClicknum(Integer chanpinClicknum) {
			this.chanpinClicknum = chanpinClicknum;
		}

		/**
		* 获取： 农产品介绍
		*/
		public String getChanpinContent() {
			return chanpinContent;
		}
		/**
		* 设置： 农产品介绍
		*/
		public void setChanpinContent(String chanpinContent) {
			this.chanpinContent = chanpinContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getChanpinDelete() {
			return chanpinDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setChanpinDelete(Integer chanpinDelete) {
			this.chanpinDelete = chanpinDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
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
		return "ChanpinCollectionView{" +
			", chanpinCollectionValue=" + chanpinCollectionValue +
			", chanpinName=" + chanpinName +
			", chanpinUuidNumber=" + chanpinUuidNumber +
			", chanpinPhoto=" + chanpinPhoto +
			", chanpinKucunNumber=" + chanpinKucunNumber +
			", chanpinNewMoney=" + chanpinNewMoney +
			", chanpinClicknum=" + chanpinClicknum +
			", chanpinContent=" + chanpinContent +
			", chanpinDelete=" + chanpinDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			"} " + super.toString();
	}
}
