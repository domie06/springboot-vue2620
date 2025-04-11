package com.entity.model;

import com.entity.JingzhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 基金净值
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JingzhiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 基金
     */
    private Integer jijinId;


    /**
     * 净值
     */
    private Double jingzhiMoney;


    /**
     * 日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
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
	 * 获取：基金
	 */
    public Integer getJijinId() {
        return jijinId;
    }


    /**
	 * 设置：基金
	 */
    public void setJijinId(Integer jijinId) {
        this.jijinId = jijinId;
    }
    /**
	 * 获取：净值
	 */
    public Double getJingzhiMoney() {
        return jingzhiMoney;
    }


    /**
	 * 设置：净值
	 */
    public void setJingzhiMoney(Double jingzhiMoney) {
        this.jingzhiMoney = jingzhiMoney;
    }
    /**
	 * 获取：日期
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：日期
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
