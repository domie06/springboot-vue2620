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
 * 基金
 *
 * @author 
 * @email
 */
@TableName("jijin")
public class JijinEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JijinEntity() {

	}

	public JijinEntity(T t) {
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
     * 基金经理
     */
    @TableField(value = "jijinjingli_id")

    private Integer jijinjingliId;


    /**
     * 基金代码
     */
    @TableField(value = "jijin_uuid_number")

    private String jijinUuidNumber;


    /**
     * 基金名称
     */
    @TableField(value = "jijin_name")

    private String jijinName;


    /**
     * 基金照片
     */
    @TableField(value = "jijin_photo")

    private String jijinPhoto;


    /**
     * 基金类型
     */
    @TableField(value = "jijin_types")

    private Integer jijinTypes;


    /**
     * 基金风险类型
     */
    @TableField(value = "jijin_fengxian_types")

    private Integer jijinFengxianTypes;


    /**
     * 点击次数
     */
    @TableField(value = "jijin_clicknum")

    private Integer jijinClicknum;


    /**
     * 首页推荐
     */
    @TableField(value = "jijin_tuijian_types")

    private Integer jijinTuijianTypes;


    /**
     * 基金档案
     */
    @TableField(value = "jijin_content")

    private String jijinContent;


    /**
     * 是否上架
     */
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @TableField(value = "jijin_delete")

    private Integer jijinDelete;


    /**
     * 基金发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 添加时间
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
	 * 设置：基金经理
	 */
    public Integer getJijinjingliId() {
        return jijinjingliId;
    }


    /**
	 * 获取：基金经理
	 */

    public void setJijinjingliId(Integer jijinjingliId) {
        this.jijinjingliId = jijinjingliId;
    }
    /**
	 * 设置：基金代码
	 */
    public String getJijinUuidNumber() {
        return jijinUuidNumber;
    }


    /**
	 * 获取：基金代码
	 */

    public void setJijinUuidNumber(String jijinUuidNumber) {
        this.jijinUuidNumber = jijinUuidNumber;
    }
    /**
	 * 设置：基金名称
	 */
    public String getJijinName() {
        return jijinName;
    }


    /**
	 * 获取：基金名称
	 */

    public void setJijinName(String jijinName) {
        this.jijinName = jijinName;
    }
    /**
	 * 设置：基金照片
	 */
    public String getJijinPhoto() {
        return jijinPhoto;
    }


    /**
	 * 获取：基金照片
	 */

    public void setJijinPhoto(String jijinPhoto) {
        this.jijinPhoto = jijinPhoto;
    }
    /**
	 * 设置：基金类型
	 */
    public Integer getJijinTypes() {
        return jijinTypes;
    }


    /**
	 * 获取：基金类型
	 */

    public void setJijinTypes(Integer jijinTypes) {
        this.jijinTypes = jijinTypes;
    }
    /**
	 * 设置：基金风险类型
	 */
    public Integer getJijinFengxianTypes() {
        return jijinFengxianTypes;
    }


    /**
	 * 获取：基金风险类型
	 */

    public void setJijinFengxianTypes(Integer jijinFengxianTypes) {
        this.jijinFengxianTypes = jijinFengxianTypes;
    }
    /**
	 * 设置：点击次数
	 */
    public Integer getJijinClicknum() {
        return jijinClicknum;
    }


    /**
	 * 获取：点击次数
	 */

    public void setJijinClicknum(Integer jijinClicknum) {
        this.jijinClicknum = jijinClicknum;
    }
    /**
	 * 设置：首页推荐
	 */
    public Integer getJijinTuijianTypes() {
        return jijinTuijianTypes;
    }


    /**
	 * 获取：首页推荐
	 */

    public void setJijinTuijianTypes(Integer jijinTuijianTypes) {
        this.jijinTuijianTypes = jijinTuijianTypes;
    }
    /**
	 * 设置：基金档案
	 */
    public String getJijinContent() {
        return jijinContent;
    }


    /**
	 * 获取：基金档案
	 */

    public void setJijinContent(String jijinContent) {
        this.jijinContent = jijinContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getJijinDelete() {
        return jijinDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setJijinDelete(Integer jijinDelete) {
        this.jijinDelete = jijinDelete;
    }
    /**
	 * 设置：基金发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：基金发布时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Jijin{" +
            "id=" + id +
            ", jijinjingliId=" + jijinjingliId +
            ", jijinUuidNumber=" + jijinUuidNumber +
            ", jijinName=" + jijinName +
            ", jijinPhoto=" + jijinPhoto +
            ", jijinTypes=" + jijinTypes +
            ", jijinFengxianTypes=" + jijinFengxianTypes +
            ", jijinClicknum=" + jijinClicknum +
            ", jijinTuijianTypes=" + jijinTuijianTypes +
            ", jijinContent=" + jijinContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", jijinDelete=" + jijinDelete +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
