package com.entity.vo;

import com.entity.JiaoyijiluEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 交易记录
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiaoyijilu")
public class JiaoyijiluVO implements Serializable {
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
     * 交易份数
     */

    @TableField(value = "jiaoyijilu_fenshu")
    private Integer jiaoyijiluFenshu;


    /**
     * 总金额
     */

    @TableField(value = "jiaoyijilu_sum_money")
    private Double jiaoyijiluSumMoney;


    /**
     * 类型
     */

    @TableField(value = "jiaoyijilu_types")
    private Integer jiaoyijiluTypes;


    /**
     * 记录时间
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
	 * 设置：交易份数
	 */
    public Integer getJiaoyijiluFenshu() {
        return jiaoyijiluFenshu;
    }


    /**
	 * 获取：交易份数
	 */

    public void setJiaoyijiluFenshu(Integer jiaoyijiluFenshu) {
        this.jiaoyijiluFenshu = jiaoyijiluFenshu;
    }
    /**
	 * 设置：总金额
	 */
    public Double getJiaoyijiluSumMoney() {
        return jiaoyijiluSumMoney;
    }


    /**
	 * 获取：总金额
	 */

    public void setJiaoyijiluSumMoney(Double jiaoyijiluSumMoney) {
        this.jiaoyijiluSumMoney = jiaoyijiluSumMoney;
    }
    /**
	 * 设置：类型
	 */
    public Integer getJiaoyijiluTypes() {
        return jiaoyijiluTypes;
    }


    /**
	 * 获取：类型
	 */

    public void setJiaoyijiluTypes(Integer jiaoyijiluTypes) {
        this.jiaoyijiluTypes = jiaoyijiluTypes;
    }
    /**
	 * 设置：记录时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：记录时间
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
