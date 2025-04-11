package com.entity.model;

import com.entity.JijinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 基金
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JijinModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


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
     * 点击次数
     */
    private Integer jijinClicknum;


    /**
     * 首页推荐
     */
    private Integer jijinTuijianTypes;


    /**
     * 基金档案
     */
    private String jijinContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer jijinDelete;


    /**
     * 基金发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：基金代码
	 */
    public String getJijinUuidNumber() {
        return jijinUuidNumber;
    }


    /**
	 * 设置：基金代码
	 */
    public void setJijinUuidNumber(String jijinUuidNumber) {
        this.jijinUuidNumber = jijinUuidNumber;
    }
    /**
	 * 获取：基金名称
	 */
    public String getJijinName() {
        return jijinName;
    }


    /**
	 * 设置：基金名称
	 */
    public void setJijinName(String jijinName) {
        this.jijinName = jijinName;
    }
    /**
	 * 获取：基金照片
	 */
    public String getJijinPhoto() {
        return jijinPhoto;
    }


    /**
	 * 设置：基金照片
	 */
    public void setJijinPhoto(String jijinPhoto) {
        this.jijinPhoto = jijinPhoto;
    }
    /**
	 * 获取：基金类型
	 */
    public Integer getJijinTypes() {
        return jijinTypes;
    }


    /**
	 * 设置：基金类型
	 */
    public void setJijinTypes(Integer jijinTypes) {
        this.jijinTypes = jijinTypes;
    }
    /**
	 * 获取：点击次数
	 */
    public Integer getJijinClicknum() {
        return jijinClicknum;
    }


    /**
	 * 设置：点击次数
	 */
    public void setJijinClicknum(Integer jijinClicknum) {
        this.jijinClicknum = jijinClicknum;
    }
    /**
	 * 获取：首页推荐
	 */
    public Integer getJijinTuijianTypes() {
        return jijinTuijianTypes;
    }


    /**
	 * 设置：首页推荐
	 */
    public void setJijinTuijianTypes(Integer jijinTuijianTypes) {
        this.jijinTuijianTypes = jijinTuijianTypes;
    }
    /**
	 * 获取：基金档案
	 */
    public String getJijinContent() {
        return jijinContent;
    }


    /**
	 * 设置：基金档案
	 */
    public void setJijinContent(String jijinContent) {
        this.jijinContent = jijinContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 设置：是否上架
	 */
    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getJijinDelete() {
        return jijinDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setJijinDelete(Integer jijinDelete) {
        this.jijinDelete = jijinDelete;
    }
    /**
	 * 获取：基金发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：基金发布时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
