package com.dev.bond.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wzj123
 * @since 2020-03-16
 */
@TableName("bond_frozen")
public class BondFrozen extends Model<BondFrozen> {

    private static final long serialVersionUID = 1L;

    /**
     * 债券代码
     */
    @TableId("BOND_CODE")
    private String bondCode;
    @TableField("BOND_NAME")
    private String bondName;
    /**
     * 债券份额
     */
    @TableField("BOND_SHARE")
    private String bondShare;
    /**
     * 债券金额
     */
    @TableField("BOND_AMOUNT")
    private String bondAmount;
    /**
     * 托管账户号
     */
    @TableField("ACCOUNT_ID")
    private String accountId;
    @TableField("ENTITY_ID")
    private String entityId;
    @TableField("ENTITY_NAME")
    private String entityName;


    public String getBondCode() {
        return bondCode;
    }

    public BondFrozen setBondCode(String bondCode) {
        this.bondCode = bondCode;
        return this;
    }

    public String getBondName() {
        return bondName;
    }

    public BondFrozen setBondName(String bondName) {
        this.bondName = bondName;
        return this;
    }

    public String getBondShare() {
        return bondShare;
    }

    public BondFrozen setBondShare(String bondShare) {
        this.bondShare = bondShare;
        return this;
    }

    public String getBondAmount() {
        return bondAmount;
    }

    public BondFrozen setBondAmount(String bondAmount) {
        this.bondAmount = bondAmount;
        return this;
    }

    public String getAccountId() {
        return accountId;
    }

    public BondFrozen setAccountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    public String getEntityId() {
        return entityId;
    }

    public BondFrozen setEntityId(String entityId) {
        this.entityId = entityId;
        return this;
    }

    public String getEntityName() {
        return entityName;
    }

    public BondFrozen setEntityName(String entityName) {
        this.entityName = entityName;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.bondCode;
    }

    @Override
    public String toString() {
        return "BondFrozen{" +
        ", bondCode=" + bondCode +
        ", bondName=" + bondName +
        ", bondShare=" + bondShare +
        ", bondAmount=" + bondAmount +
        ", accountId=" + accountId +
        ", entityId=" + entityId +
        ", entityName=" + entityName +
        "}";
    }
}
