package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ChanpinOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 农产品订单
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("chanpin_order")
public class ChanpinOrderView extends ChanpinOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 订单类型的值
	*/
	@ColumnInfo(comment="订单类型的字典表值",type="varchar(200)")
	private String chanpinOrderValue;

	//级联表 收货地址
					 
		/**
		* 收货地址 的 创建用户
		*/
		@ColumnInfo(comment="创建用户",type="int(20)")
		private Integer addressYonghuId;
		/**
		* 收货人
		*/

		@ColumnInfo(comment="收货人",type="varchar(200)")
		private String addressName;
		/**
		* 电话
		*/

		@ColumnInfo(comment="电话",type="varchar(200)")
		private String addressPhone;
		/**
		* 地址
		*/

		@ColumnInfo(comment="地址",type="varchar(200)")
		private String addressDizhi;
		/**
		* 是否默认地址
		*/
		@ColumnInfo(comment="是否默认地址",type="int(11)")
		private Integer isdefaultTypes;
			/**
			* 是否默认地址的值
			*/
			@ColumnInfo(comment="是否默认地址的字典表值",type="varchar(200)")
			private String isdefaultValue;
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



	public ChanpinOrderView() {

	}

	public ChanpinOrderView(ChanpinOrderEntity chanpinOrderEntity) {
		try {
			BeanUtils.copyProperties(this, chanpinOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 订单类型的值
	*/
	public String getChanpinOrderValue() {
		return chanpinOrderValue;
	}
	/**
	* 设置： 订单类型的值
	*/
	public void setChanpinOrderValue(String chanpinOrderValue) {
		this.chanpinOrderValue = chanpinOrderValue;
	}


	//级联表的get和set 收货地址
		/**
		* 获取：收货地址 的 创建用户
		*/
		public Integer getAddressYonghuId() {
			return addressYonghuId;
		}
		/**
		* 设置：收货地址 的 创建用户
		*/
		public void setAddressYonghuId(Integer addressYonghuId) {
			this.addressYonghuId = addressYonghuId;
		}

		/**
		* 获取： 收货人
		*/
		public String getAddressName() {
			return addressName;
		}
		/**
		* 设置： 收货人
		*/
		public void setAddressName(String addressName) {
			this.addressName = addressName;
		}

		/**
		* 获取： 电话
		*/
		public String getAddressPhone() {
			return addressPhone;
		}
		/**
		* 设置： 电话
		*/
		public void setAddressPhone(String addressPhone) {
			this.addressPhone = addressPhone;
		}

		/**
		* 获取： 地址
		*/
		public String getAddressDizhi() {
			return addressDizhi;
		}
		/**
		* 设置： 地址
		*/
		public void setAddressDizhi(String addressDizhi) {
			this.addressDizhi = addressDizhi;
		}
		/**
		* 获取： 是否默认地址
		*/
		public Integer getIsdefaultTypes() {
			return isdefaultTypes;
		}
		/**
		* 设置： 是否默认地址
		*/
		public void setIsdefaultTypes(Integer isdefaultTypes) {
			this.isdefaultTypes = isdefaultTypes;
		}


			/**
			* 获取： 是否默认地址的值
			*/
			public String getIsdefaultValue() {
				return isdefaultValue;
			}
			/**
			* 设置： 是否默认地址的值
			*/
			public void setIsdefaultValue(String isdefaultValue) {
				this.isdefaultValue = isdefaultValue;
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
		return "ChanpinOrderView{" +
			", chanpinOrderValue=" + chanpinOrderValue +
			", addressName=" + addressName +
			", addressPhone=" + addressPhone +
			", addressDizhi=" + addressDizhi +
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
