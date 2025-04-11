package com.entity.view;

import com.entity.JiaoyijiluEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 交易记录
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("jiaoyijilu")
public class JiaoyijiluView extends JiaoyijiluEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 类型的值
		*/
		private String jiaoyijiluValue;



		//级联表 jijin
			/**
			* 基金代码
			*/
			private String jijinUuidNumber;
			/**
			* 基金名称
			*/
			private String jijinName;
			/**
			* 基金照片
			*/
			private String jijinPhoto;
			/**
			* 基金类型
			*/
			private Integer jijinTypes;
				/**
				* 基金类型的值
				*/
				private String jijinValue;
			/**
			* 点击次数
			*/
			private Integer jijinClicknum;
			/**
			* 首页推荐
			*/
			private Integer jijinTuijianTypes;
				/**
				* 首页推荐的值
				*/
				private String jijinTuijianValue;
			/**
			* 基金档案
			*/
			private String jijinContent;
			/**
			* 是否上架
			*/
			private Integer shangxiaTypes;
				/**
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer jijinDelete;

		//级联表 yonghu
			/**
			* 昵称
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;
			/**
			* 余额
			*/
			private Double newMoney;

	public JiaoyijiluView() {

	}

	public JiaoyijiluView(JiaoyijiluEntity jiaoyijiluEntity) {
		try {
			BeanUtils.copyProperties(this, jiaoyijiluEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 类型的值
			*/
			public String getJiaoyijiluValue() {
				return jiaoyijiluValue;
			}
			/**
			* 设置： 类型的值
			*/
			public void setJiaoyijiluValue(String jiaoyijiluValue) {
				this.jiaoyijiluValue = jiaoyijiluValue;
			}
















				//级联表的get和set jijin
					/**
					* 获取： 基金代码
					*/
					public String getJijinUuidNumber() {
						return jijinUuidNumber;
					}
					/**
					* 设置： 基金代码
					*/
					public void setJijinUuidNumber(String jijinUuidNumber) {
						this.jijinUuidNumber = jijinUuidNumber;
					}
					/**
					* 获取： 基金名称
					*/
					public String getJijinName() {
						return jijinName;
					}
					/**
					* 设置： 基金名称
					*/
					public void setJijinName(String jijinName) {
						this.jijinName = jijinName;
					}
					/**
					* 获取： 基金照片
					*/
					public String getJijinPhoto() {
						return jijinPhoto;
					}
					/**
					* 设置： 基金照片
					*/
					public void setJijinPhoto(String jijinPhoto) {
						this.jijinPhoto = jijinPhoto;
					}
					/**
					* 获取： 基金类型
					*/
					public Integer getJijinTypes() {
						return jijinTypes;
					}
					/**
					* 设置： 基金类型
					*/
					public void setJijinTypes(Integer jijinTypes) {
						this.jijinTypes = jijinTypes;
					}


						/**
						* 获取： 基金类型的值
						*/
						public String getJijinValue() {
							return jijinValue;
						}
						/**
						* 设置： 基金类型的值
						*/
						public void setJijinValue(String jijinValue) {
							this.jijinValue = jijinValue;
						}
					/**
					* 获取： 点击次数
					*/
					public Integer getJijinClicknum() {
						return jijinClicknum;
					}
					/**
					* 设置： 点击次数
					*/
					public void setJijinClicknum(Integer jijinClicknum) {
						this.jijinClicknum = jijinClicknum;
					}
					/**
					* 获取： 首页推荐
					*/
					public Integer getJijinTuijianTypes() {
						return jijinTuijianTypes;
					}
					/**
					* 设置： 首页推荐
					*/
					public void setJijinTuijianTypes(Integer jijinTuijianTypes) {
						this.jijinTuijianTypes = jijinTuijianTypes;
					}


						/**
						* 获取： 首页推荐的值
						*/
						public String getJijinTuijianValue() {
							return jijinTuijianValue;
						}
						/**
						* 设置： 首页推荐的值
						*/
						public void setJijinTuijianValue(String jijinTuijianValue) {
							this.jijinTuijianValue = jijinTuijianValue;
						}
					/**
					* 获取： 基金档案
					*/
					public String getJijinContent() {
						return jijinContent;
					}
					/**
					* 设置： 基金档案
					*/
					public void setJijinContent(String jijinContent) {
						this.jijinContent = jijinContent;
					}
					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
					}


						/**
						* 获取： 是否上架的值
						*/
						public String getShangxiaValue() {
							return shangxiaValue;
						}
						/**
						* 设置： 是否上架的值
						*/
						public void setShangxiaValue(String shangxiaValue) {
							this.shangxiaValue = shangxiaValue;
						}
					/**
					* 获取： 逻辑删除
					*/
					public Integer getJijinDelete() {
						return jijinDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setJijinDelete(Integer jijinDelete) {
						this.jijinDelete = jijinDelete;
					}













				//级联表的get和set yonghu
					/**
					* 获取： 昵称
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 昵称
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
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
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
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



}
