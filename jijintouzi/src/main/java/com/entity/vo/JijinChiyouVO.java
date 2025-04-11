package com.entity.vo;

import com.entity.JijinChiyouEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 持有基金
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jijin_chiyou")
public class JijinChiyouVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 基金
     */

    @TableField(value = "jijin_id")
    private Integer jijinId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 持有份数
     */

    @TableField(value = "fenshu")
    private Integer fenshu;


    /**
     * 总购买金额
     */

    @TableField(value = "buy_sum_money")
    private Double buySumMoney;


    /**
     * 总卖出金额
     */

    @TableField(value = "sell_sum_money")
    private Double sellSumMoney;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
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
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：持有份数
	 */
    public Integer getFenshu() {
        return fenshu;
    }


    /**
	 * 获取：持有份数
	 */

    public void setFenshu(Integer fenshu) {
        this.fenshu = fenshu;
    }
    /**
	 * 设置：总购买金额
	 */
    public Double getBuySumMoney() {
        return buySumMoney;
    }


    /**
	 * 获取：总购买金额
	 */

    public void setBuySumMoney(Double buySumMoney) {
        this.buySumMoney = buySumMoney;
    }
    /**
	 * 设置：总卖出金额
	 */
    public Double getSellSumMoney() {
        return sellSumMoney;
    }


    /**
	 * 获取：总卖出金额
	 */

    public void setSellSumMoney(Double sellSumMoney) {
        this.sellSumMoney = sellSumMoney;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：创建时间
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

}
