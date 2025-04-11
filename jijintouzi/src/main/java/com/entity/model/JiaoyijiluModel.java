package com.entity.model;

import com.entity.JiaoyijiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 交易记录
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiaoyijiluModel implements Serializable {
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
     * 用户
     */
    private Integer yonghuId;


    /**
     * 交易份数
     */
    private Integer jiaoyijiluFenshu;


    /**
     * 总金额
     */
    private Double jiaoyijiluSumMoney;


    /**
     * 类型
     */
    private Integer jiaoyijiluTypes;


    /**
     * 记录时间
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
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：交易份数
	 */
    public Integer getJiaoyijiluFenshu() {
        return jiaoyijiluFenshu;
    }


    /**
	 * 设置：交易份数
	 */
    public void setJiaoyijiluFenshu(Integer jiaoyijiluFenshu) {
        this.jiaoyijiluFenshu = jiaoyijiluFenshu;
    }
    /**
	 * 获取：总金额
	 */
    public Double getJiaoyijiluSumMoney() {
        return jiaoyijiluSumMoney;
    }


    /**
	 * 设置：总金额
	 */
    public void setJiaoyijiluSumMoney(Double jiaoyijiluSumMoney) {
        this.jiaoyijiluSumMoney = jiaoyijiluSumMoney;
    }
    /**
	 * 获取：类型
	 */
    public Integer getJiaoyijiluTypes() {
        return jiaoyijiluTypes;
    }


    /**
	 * 设置：类型
	 */
    public void setJiaoyijiluTypes(Integer jiaoyijiluTypes) {
        this.jiaoyijiluTypes = jiaoyijiluTypes;
    }
    /**
	 * 获取：记录时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：记录时间
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
