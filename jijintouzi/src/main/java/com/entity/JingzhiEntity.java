package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 基金净值
 *
 * @author 
 * @email
 */
@TableName("jingzhi")
public class JingzhiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JingzhiEntity() {

	}

	public JingzhiEntity(T t) {
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
     * 基金
     */
    @TableField(value = "jijin_id")

    private Integer jijinId;


    /**
     * 净值
     */
    @TableField(value = "jingzhi_money")

    private Double jingzhiMoney;


    /**
     * 日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
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
	 * 设置：基金
	 */
    public Integer getJijinId() {
        return jijinId;
    }


    /**
	 * 获取：基金
	 */

    public void setJijinId(Integer jijinId) {
        this.jijinId = jijinId;
    }
    /**
	 * 设置：净值
	 */
    public Double getJingzhiMoney() {
        return jingzhiMoney;
    }


    /**
	 * 获取：净值
	 */

    public void setJingzhiMoney(Double jingzhiMoney) {
        this.jingzhiMoney = jingzhiMoney;
    }
    /**
	 * 设置：日期
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：日期
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
        return "Jingzhi{" +
            "id=" + id +
            ", jijinId=" + jijinId +
            ", jingzhiMoney=" + jingzhiMoney +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
