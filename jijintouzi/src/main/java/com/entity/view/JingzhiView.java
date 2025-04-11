package com.entity.view;

import com.entity.JingzhiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 基金净值
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("jingzhi")
public class JingzhiView extends JingzhiEntity implements Serializable {
    private static final long serialVersionUID = 1L;




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

	public JingzhiView() {

	}

	public JingzhiView(JingzhiEntity jingzhiEntity) {
		try {
			BeanUtils.copyProperties(this, jingzhiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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










}
