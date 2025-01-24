package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.NongziOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 农资订单
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("nongzi_order")
public class NongziOrderView extends NongziOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 订单类型的值
	*/
	@ColumnInfo(comment="订单类型的字典表值",type="varchar(200)")
	private String nongziOrderValue;

	//级联表 农资
		/**
		* 农资名称
		*/

		@ColumnInfo(comment="农资名称",type="varchar(200)")
		private String nongziName;
		/**
		* 农资编号
		*/

		@ColumnInfo(comment="农资编号",type="varchar(200)")
		private String nongziUuidNumber;
		/**
		* 农资照片
		*/

		@ColumnInfo(comment="农资照片",type="varchar(200)")
		private String nongziPhoto;
		/**
		* 农资类型
		*/
		@ColumnInfo(comment="农资类型",type="int(11)")
		private Integer nongziTypes;
			/**
			* 农资类型的值
			*/
			@ColumnInfo(comment="农资类型的字典表值",type="varchar(200)")
			private String nongziValue;
		/**
		* 农资库存
		*/

		@ColumnInfo(comment="农资库存",type="int(11)")
		private Integer nongziKucunNumber;
		/**
		* 金额
		*/
		@ColumnInfo(comment="金额",type="decimal(10,2)")
		private Double nongziNewMoney;
		/**
		* 农资热度
		*/

		@ColumnInfo(comment="农资热度",type="int(11)")
		private Integer nongziClicknum;
		/**
		* 农资介绍
		*/

		@ColumnInfo(comment="农资介绍",type="longtext")
		private String nongziContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer nongziDelete;
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



	public NongziOrderView() {

	}

	public NongziOrderView(NongziOrderEntity nongziOrderEntity) {
		try {
			BeanUtils.copyProperties(this, nongziOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 订单类型的值
	*/
	public String getNongziOrderValue() {
		return nongziOrderValue;
	}
	/**
	* 设置： 订单类型的值
	*/
	public void setNongziOrderValue(String nongziOrderValue) {
		this.nongziOrderValue = nongziOrderValue;
	}


	//级联表的get和set 农资

		/**
		* 获取： 农资名称
		*/
		public String getNongziName() {
			return nongziName;
		}
		/**
		* 设置： 农资名称
		*/
		public void setNongziName(String nongziName) {
			this.nongziName = nongziName;
		}

		/**
		* 获取： 农资编号
		*/
		public String getNongziUuidNumber() {
			return nongziUuidNumber;
		}
		/**
		* 设置： 农资编号
		*/
		public void setNongziUuidNumber(String nongziUuidNumber) {
			this.nongziUuidNumber = nongziUuidNumber;
		}

		/**
		* 获取： 农资照片
		*/
		public String getNongziPhoto() {
			return nongziPhoto;
		}
		/**
		* 设置： 农资照片
		*/
		public void setNongziPhoto(String nongziPhoto) {
			this.nongziPhoto = nongziPhoto;
		}
		/**
		* 获取： 农资类型
		*/
		public Integer getNongziTypes() {
			return nongziTypes;
		}
		/**
		* 设置： 农资类型
		*/
		public void setNongziTypes(Integer nongziTypes) {
			this.nongziTypes = nongziTypes;
		}


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

		/**
		* 获取： 农资库存
		*/
		public Integer getNongziKucunNumber() {
			return nongziKucunNumber;
		}
		/**
		* 设置： 农资库存
		*/
		public void setNongziKucunNumber(Integer nongziKucunNumber) {
			this.nongziKucunNumber = nongziKucunNumber;
		}

		/**
		* 获取： 金额
		*/
		public Double getNongziNewMoney() {
			return nongziNewMoney;
		}
		/**
		* 设置： 金额
		*/
		public void setNongziNewMoney(Double nongziNewMoney) {
			this.nongziNewMoney = nongziNewMoney;
		}

		/**
		* 获取： 农资热度
		*/
		public Integer getNongziClicknum() {
			return nongziClicknum;
		}
		/**
		* 设置： 农资热度
		*/
		public void setNongziClicknum(Integer nongziClicknum) {
			this.nongziClicknum = nongziClicknum;
		}

		/**
		* 获取： 农资介绍
		*/
		public String getNongziContent() {
			return nongziContent;
		}
		/**
		* 设置： 农资介绍
		*/
		public void setNongziContent(String nongziContent) {
			this.nongziContent = nongziContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getNongziDelete() {
			return nongziDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setNongziDelete(Integer nongziDelete) {
			this.nongziDelete = nongziDelete;
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
		return "NongziOrderView{" +
			", nongziOrderValue=" + nongziOrderValue +
			", nongziName=" + nongziName +
			", nongziUuidNumber=" + nongziUuidNumber +
			", nongziPhoto=" + nongziPhoto +
			", nongziKucunNumber=" + nongziKucunNumber +
			", nongziNewMoney=" + nongziNewMoney +
			", nongziClicknum=" + nongziClicknum +
			", nongziContent=" + nongziContent +
			", nongziDelete=" + nongziDelete +
			", zhongzhihuName=" + zhongzhihuName +
			", zhongzhihuPhoto=" + zhongzhihuPhoto +
			", zhongzhihuPhone=" + zhongzhihuPhone +
			", zhongzhihuIdNumber=" + zhongzhihuIdNumber +
			", zhongzhihuEmail=" + zhongzhihuEmail +
			", newMoney=" + newMoney +
			"} " + super.toString();
	}
}
