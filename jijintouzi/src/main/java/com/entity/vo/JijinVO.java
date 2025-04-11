package com.entity.vo;

import com.entity.JijinEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 基金
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jijin")
public class JijinVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


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

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
