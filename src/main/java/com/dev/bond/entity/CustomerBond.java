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
@TableName("customer_bond")
public class CustomerBond extends Model<CustomerBond> {

    private static final long serialVersionUID = 1L;

    /**
     * 总份额
     */
    @TableField("TOTAL_SHARE")
    private BigDecimal totalShare;
    /**
     * 托管账户号
     */
    @TableId("ACCOUNT_ID")
    private String accountId;
    /**
     * 可交易份额
     */
    @TableField("TRADE_SHARE")
    private BigDecimal tradeShare;
    /**
     * 冻结份额
     */
    @TableField("FROZEN_SHARE")
    private BigDecimal frozenShare;
    @TableField("BOND_CODE")
    private String bondCode;
    @TableField("BOND_NAME")
    private String bondName;
    @TableField("ENTITY_ID")
    private String entityId;
    @TableField("ENTITY_NAME")
    private String entityName;


    public BigDecimal getTotalShare() {
        return totalShare;
    }

    public CustomerBond setTotalShare(BigDecimal totalShare) {
        this.totalShare = totalShare;
        return this;
    }

    public String getAccountId() {
        return accountId;
    }

    public CustomerBond setAccountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    public BigDecimal getTradeShare() {
        return tradeShare;
    }

    public CustomerBond setTradeShare(BigDecimal tradeShare) {
        this.tradeShare = tradeShare;
        return this;
    }

    public BigDecimal getFrozenShare() {
        return frozenShare;
    }

    public CustomerBond setFrozenShare(BigDecimal frozenShare) {
        this.frozenShare = frozenShare;
        return this;
    }

    public String getBondCode() {
        return bondCode;
    }

    public CustomerBond setBondCode(String bondCode) {
        this.bondCode = bondCode;
        return this;
    }

    public String getBondName() {
        return bondName;
    }

    public CustomerBond setBondName(String bondName) {
        this.bondName = bondName;
        return this;
    }

    public String getEntityId() {
        return entityId;
    }

    public CustomerBond setEntityId(String entityId) {
        this.entityId = entityId;
        return this;
    }

    public String getEntityName() {
        return entityName;
    }

    public CustomerBond setEntityName(String entityName) {
        this.entityName = entityName;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.accountId;
    }

    @Override
    public String toString() {
        return "CustomerBond{" +
        ", totalShare=" + totalShare +
        ", accountId=" + accountId +
        ", tradeShare=" + tradeShare +
        ", frozenShare=" + frozenShare +
        ", bondCode=" + bondCode +
        ", bondName=" + bondName +
        ", entityId=" + entityId +
        ", entityName=" + entityName +
        "}";
    }
}
