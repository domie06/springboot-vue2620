package com.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * 基金经理
 *
 * @author 
 * @email
 */
@TableName("jijinjingli")
public class JijinjingliEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JijinjingliEntity() {

	}

	public JijinjingliEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 基金经理姓名
     */
    @TableField(value = "jijinjingli_name")

    private String jijinjingliName;


    /**
     * 基金经理照片
     */
    @TableField(value = "jijinjingli_photo")

    private String jijinjingliPhoto;


    /**
     * 工作年限
     */
    @TableField(value = "jijinjingli_gongzuo")

    private String jijinjingliGongzuo;


    /**
     * 性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 任期及回报
     */
    @TableField(value = "jijinjingli_renqi_text")

    private String jijinjingliRenqiText;


    /**
     * 基金经理档案
     */
    @TableField(value = "jijinjingli_content")

    private String jijinjingliContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：基金经理姓名
	 */
    public String getJijinjingliName() {
        return jijinjingliName;
    }


    /**
	 * 获取：基金经理姓名
	 */

    public void setJijinjingliName(String jijinjingliName) {
        this.jijinjingliName = jijinjingliName;
    }
    /**
	 * 设置：基金经理照片
	 */
    public String getJijinjingliPhoto() {
        return jijinjingliPhoto;
    }


    /**
	 * 获取：基金经理照片
	 */

    public void setJijinjingliPhoto(String jijinjingliPhoto) {
        this.jijinjingliPhoto = jijinjingliPhoto;
    }
    /**
	 * 设置：工作年限
	 */
    public String getJijinjingliGongzuo() {
        return jijinjingliGongzuo;
    }


    /**
	 * 获取：工作年限
	 */

    public void setJijinjingliGongzuo(String jijinjingliGongzuo) {
        this.jijinjingliGongzuo = jijinjingliGongzuo;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：任期及回报
	 */
    public String getJijinjingliRenqiText() {
        return jijinjingliRenqiText;
    }


    /**
	 * 获取：任期及回报
	 */

    public void setJijinjingliRenqiText(String jijinjingliRenqiText) {
        this.jijinjingliRenqiText = jijinjingliRenqiText;
    }
    /**
	 * 设置：基金经理档案
	 */
    public String getJijinjingliContent() {
        return jijinjingliContent;
    }


    /**
	 * 获取：基金经理档案
	 */

    public void setJijinjingliContent(String jijinjingliContent) {
        this.jijinjingliContent = jijinjingliContent;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Jijinjingli{" +
            "id=" + id +
            ", jijinjingliName=" + jijinjingliName +
            ", jijinjingliPhoto=" + jijinjingliPhoto +
            ", jijinjingliGongzuo=" + jijinjingliGongzuo +
            ", sexTypes=" + sexTypes +
            ", jijinjingliRenqiText=" + jijinjingliRenqiText +
            ", jijinjingliContent=" + jijinjingliContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
