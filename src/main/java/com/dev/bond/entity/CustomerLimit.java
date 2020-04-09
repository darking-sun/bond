package com.dev.bond.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author wzj123
 * @since 2020-03-16
 */
@TableName("customer_limit")
public class CustomerLimit extends Model<CustomerLimit> {

    private static final long serialVersionUID = 1L;

    /**
     * 托管账户号
     */
    @TableId("ACCOUNT_ID")
    private String accountId;
    /**
     * 总限额
     */
    @TableField("TOTAL_SHARE")
    private BigDecimal totalShare;
    /**
     * 已买限额
     */
    @TableField("BUY_SHARE")
    private BigDecimal buyShare;


    public String getAccountId() {
        return accountId;
    }

    public CustomerLimit setAccountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    public BigDecimal getTotalShare() {
        return totalShare;
    }

    public CustomerLimit setTotalShare(BigDecimal totalShare) {
        this.totalShare = totalShare;
        return this;
    }

    public BigDecimal getBuyShare() {
        return buyShare;
    }

    public CustomerLimit setBuyShare(BigDecimal buyShare) {
        this.buyShare = buyShare;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.accountId;
    }

    @Override
    public String toString() {
        return "CustomerLimit{" +
        ", accountId=" + accountId +
        ", totalShare=" + totalShare +
        ", buyShare=" + buyShare +
        "}";
    }
}
