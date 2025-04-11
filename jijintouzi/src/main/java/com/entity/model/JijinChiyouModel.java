package com.entity.model;

import com.entity.JijinChiyouEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 持有基金
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JijinChiyouModel implements Serializable {
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
     * 持有份数
     */
    private Integer fenshu;


    /**
     * 总购买金额
     */
    private Double buySumMoney;


    /**
     * 总卖出金额
     */
    private Double sellSumMoney;


    /**
     * 创建时间
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
	 * 获取：持有份数
	 */
    public Integer getFenshu() {
        return fenshu;
    }


    /**
	 * 设置：持有份数
	 */
    public void setFenshu(Integer fenshu) {
        this.fenshu = fenshu;
    }
    /**
	 * 获取：总购买金额
	 */
    public Double getBuySumMoney() {
        return buySumMoney;
    }


    /**
	 * 设置：总购买金额
	 */
    public void setBuySumMoney(Double buySumMoney) {
        this.buySumMoney = buySumMoney;
    }
    /**
	 * 获取：总卖出金额
	 */
    public Double getSellSumMoney() {
        return sellSumMoney;
    }


    /**
	 * 设置：总卖出金额
	 */
    public void setSellSumMoney(Double sellSumMoney) {
        this.sellSumMoney = sellSumMoney;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：创建时间
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
