package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.JijinjingliEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * 基金经理
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("jijinjingli")
public class JijinjingliView extends JijinjingliEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 性别的值
		*/
		private String sexValue;



	public JijinjingliView() {

	}

	public JijinjingliView(JijinjingliEntity jijinjingliEntity) {
		try {
			BeanUtils.copyProperties(this, jijinjingliEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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













}
