package com.dev.bond.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.math.BigDecimal;

public class OrderRecord  {
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
    /**
     * 债券到期日
     */
    @TableField("BOND_END_DATE")
    private String bondEndDate;
    /**
     * 债券利率
     */
    @TableField("BOND_RATE")
    private BigDecimal bondRate;
    /**
     * 债券买入净价
     */
    @TableField("BOND_BUY_PRICE")
    private BigDecimal bondBuyPrice;
    /**
     * 债券卖出净价
     */
    @TableField("BOND_SELL_PRICE")
    private BigDecimal bondSellPrice;
    /**
     * 债券面值
     */
    @TableField("BOND_PRICE")
    private BigDecimal bondPrice;
    /**
     * 付息方式
     */
    @TableField("DAY_COUNT")
    private String dayCount;
    /**
     * 付息周期
     */
    @TableField("BOND_INTEREST_PERIOD")
    private String bondInterestPeriod;
    /**
     * 债券发行价
     */
    @TableField("BOND_ISSUE_PRICE")
    private BigDecimal bondIssuePrice;
    /**
     * 债券起息日
     */
    @TableField("BOND_INTEREST_START_DATE")
    private String bondInterestStartDate;
    /**
     * 债券认购日
     */
    @TableField("BOND_ISSUE_DATE")
    private String bondIssueDate;
    /**
     * 债券性质
     */
    @TableField("BOND_QUALITY")
    private String bondQuality;
    @TableField("BOND_LEVEL")
    private String bondLevel;



    public BigDecimal getTotalShare() {
        return totalShare;
    }

    public void setTotalShare(BigDecimal totalShare) {
        this.totalShare = totalShare;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getTradeShare() {
        return tradeShare;
    }

    public void setTradeShare(BigDecimal tradeShare) {
        this.tradeShare = tradeShare;
    }

    public BigDecimal getFrozenShare() {
        return frozenShare;
    }

    public void setFrozenShare(BigDecimal frozenShare) {
        this.frozenShare = frozenShare;
    }

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

    public String getBondEndDate() {
        return bondEndDate;
    }

    public void setBondEndDate(String bondEndDate) {
        this.bondEndDate = bondEndDate;
    }

    public BigDecimal getBondRate() {
        return bondRate;
    }

    public void setBondRate(BigDecimal bondRate) {
        this.bondRate = bondRate;
    }

    public BigDecimal getBondBuyPrice() {
        return bondBuyPrice;
    }

    public void setBondBuyPrice(BigDecimal bondBuyPrice) {
        this.bondBuyPrice = bondBuyPrice;
    }

    public BigDecimal getBondSellPrice() {
        return bondSellPrice;
    }

    public void setBondSellPrice(BigDecimal bondSellPrice) {
        this.bondSellPrice = bondSellPrice;
    }

    public String getBondInterestStartDate() {
        return bondInterestStartDate;
    }

    public void setBondInterestStartDate(String bondInterestStartDate) {
        this.bondInterestStartDate = bondInterestStartDate;
    }

    public String getBondIssueDate() {
        return bondIssueDate;
    }

    public void setBondIssueDate(String bondIssueDate) {
        this.bondIssueDate = bondIssueDate;
    }

    public BigDecimal getBondPrice() {
        return bondPrice;
    }

    public void setBondPrice(BigDecimal bondPrice) {
        this.bondPrice = bondPrice;
    }

    public String getDayCount() {
        return dayCount;
    }

    public void setDayCount(String dayCount) {
        this.dayCount = dayCount;
    }

    public String getBondInterestPeriod() {
        return bondInterestPeriod;
    }

    public void setBondInterestPeriod(String bondInterestPeriod) {
        this.bondInterestPeriod = bondInterestPeriod;
    }

    public BigDecimal getBondIssuePrice() {
        return bondIssuePrice;
    }

    public void setBondIssuePrice(BigDecimal bondIssuePrice) {
        this.bondIssuePrice = bondIssuePrice;
    }


    public String getBondQuality() {
        return bondQuality;
    }

    public void setBondQuality(String bondQuality) {
        this.bondQuality = bondQuality;
    }

    public String getBondLevel() {
        return bondLevel;
    }

    public void setBondLevel(String bondLevel) {
        this.bondLevel = bondLevel;
    }

    @Override
    public String toString() {
        return "OrderRecord{" +
                "totalShare=" + totalShare +
                ", accountId='" + accountId + '\'' +
                ", tradeShare=" + tradeShare +
                ", frozenShare=" + frozenShare +
                ", bondCode='" + bondCode + '\'' +
                ", bondName='" + bondName + '\'' +
                ", entityId='" + entityId + '\'' +
                ", entityName='" + entityName + '\'' +
                ", bondEndDate=" + bondEndDate +
                ", bondRate='" + bondRate + '\'' +
                ", bondBuyPrice='" + bondBuyPrice + '\'' +
                ", bondSellPrice='" + bondSellPrice + '\'' +
                ", bondPrice=" + bondPrice +
                ", dayCount='" + dayCount + '\'' +
                ", bondInterestPeriod='" + bondInterestPeriod + '\'' +
                ", bondIssuePrice=" + bondIssuePrice +
                ", bondInterestStartDate=" + bondInterestStartDate +
                ", bondIssueDate=" + bondIssueDate +
                ", bondQuality='" + bondQuality + '\'' +
                ", bondLevel='" + bondLevel + '\'' +
                '}';
    }
}
