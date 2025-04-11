package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.JijinEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * 基金
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("jijin")
public class JijinView extends JijinEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 基金类型的值
		*/
		private String jijinValue;
		/**
		* 基金风险类型的值
		*/
		private String jijinFengxianValue;
		/**
		* 首页推荐的值
		*/
		private String jijinTuijianValue;
		/**
		* 是否上架的值
		*/
		private String shangxiaValue;



		//级联表 jijinjingli
			/**
			* 基金经理姓名
			*/
			private String jijinjingliName;
			/**
			* 基金经理照片
			*/
			private String jijinjingliPhoto;
			/**
			* 工作年限
			*/
			private String jijinjingliGongzuo;
			/**
			* 性别
			*/
			private Integer sexTypes;
				/**
				* 性别的值
				*/
				private String sexValue;
			/**
			* 任期及回报
			*/
			private String jijinjingliRenqiText;
			/**
			* 基金经理档案
			*/
			private String jijinjingliContent;




	/**
	 * 净值list
	 */
	private List jingzhiList;


	public JijinView() {

	}

	public JijinView(JijinEntity jijinEntity) {
		try {
			BeanUtils.copyProperties(this, jijinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			* 获取： 基金风险类型的值
			*/
			public String getJijinFengxianValue() {
				return jijinFengxianValue;
			}
			/**
			* 设置： 基金风险类型的值
			*/
			public void setJijinFengxianValue(String jijinFengxianValue) {
				this.jijinFengxianValue = jijinFengxianValue;
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


















				//级联表的get和set jijinjingli
					/**
					* 获取： 基金经理姓名
					*/
					public String getJijinjingliName() {
						return jijinjingliName;
					}
					/**
					* 设置： 基金经理姓名
					*/
					public void setJijinjingliName(String jijinjingliName) {
						this.jijinjingliName = jijinjingliName;
					}
					/**
					* 获取： 基金经理照片
					*/
					public String getJijinjingliPhoto() {
						return jijinjingliPhoto;
					}
					/**
					* 设置： 基金经理照片
					*/
					public void setJijinjingliPhoto(String jijinjingliPhoto) {
						this.jijinjingliPhoto = jijinjingliPhoto;
					}
					/**
					* 获取： 工作年限
					*/
					public String getJijinjingliGongzuo() {
						return jijinjingliGongzuo;
					}
					/**
					* 设置： 工作年限
					*/
					public void setJijinjingliGongzuo(String jijinjingliGongzuo) {
						this.jijinjingliGongzuo = jijinjingliGongzuo;
					}
					/**
					* 获取： 性别
					*/
					public Integer getSexTypes() {
						return sexTypes;
					}
					/**
					* 设置： 性别
					*/
					public void setSexTypes(Integer sexTypes) {
						this.sexTypes = sexTypes;
					}


						/**
						* 获取： 性别的值
						*/
						public String getSexValue() {
							return sexValue;
						}
						/**
						* 设置： 性别的值
						*/
						public void setSexValue(String sexValue) {
							this.sexValue = sexValue;
						}
					/**
					* 获取： 任期及回报
					*/
					public String getJijinjingliRenqiText() {
						return jijinjingliRenqiText;
					}
					/**
					* 设置： 任期及回报
					*/
					public void setJijinjingliRenqiText(String jijinjingliRenqiText) {
						this.jijinjingliRenqiText = jijinjingliRenqiText;
					}
					/**
					* 获取： 基金经理档案
					*/
					public String getJijinjingliContent() {
						return jijinjingliContent;
					}
					/**
					* 设置： 基金经理档案
					*/
					public void setJijinjingliContent(String jijinjingliContent) {
						this.jijinjingliContent = jijinjingliContent;
					}


	public List getJingzhiList() {
		return jingzhiList;
	}

	public void setJingzhiList(List jingzhiList) {
		this.jingzhiList = jingzhiList;
	}
}
