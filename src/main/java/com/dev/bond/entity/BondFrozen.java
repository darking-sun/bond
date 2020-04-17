package com.dev.bond.entity;

/**
 * ---------------------------
 *  (BondFrozen)
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-04-16 22:46:40
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class BondFrozen {

    /** 债券代码 */
    private String bondCode;
    /** 债券名称 */
    private String bondName;
    /** 债券份额 */
    private Double bondShare;
    /** 债券金额 */
    private Double bondAmount;
    /** 托管账户号 */
    private String accountId;
    /** 机构ID */
    private String entityId;
    /** 机构名称 */
    private String entityName;

    public String getBondCode() {
        return bondCode;
    }

    public void setBondCode(String bondCode) {
        this.bondCode = bondCode;
    }

    public String getBondName() {
        return bondName;
    }

    public void setBondName(String bondName) {
        this.bondName = bondName;
    }

    public Double getBondShare() {
        return bondShare;
    }

    public void setBondShare(Double bondShare) {
        this.bondShare = bondShare;
    }

    public Double getBondAmount() {
        return bondAmount;
    }

    public void setBondAmount(Double bondAmount) {
        this.bondAmount = bondAmount;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

}