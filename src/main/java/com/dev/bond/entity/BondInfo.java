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
@TableName("bond_info")
public class BondInfo extends Model<BondInfo> {

    private static final long serialVersionUID = 1L;

    @TableId("BOND_CODE")
    private String bondCode;
    @TableField("BOND_NAME")
    private String bondName;
    /**
     * 债券到期日
     */
    @TableField("BOND_END_DATE")
    private String bondEndDate;
    /**
     * 债券利率
     */
    @TableField("BOND_RATE")
    private String bondRate;
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
    @TableField("ENTITY_ID")
    private String entityId;
    @TableField("ENTITY_NAME")
    private String entityName;


    public String getBondCode() {
        return bondCode;
    }

    public BondInfo setBondCode(String bondCode) {
        this.bondCode = bondCode;
        return this;
    }

    public String getBondName() {
        return bondName;
    }

    public BondInfo setBondName(String bondName) {
        this.bondName = bondName;
        return this;
    }

    public String getBondEndDate() {
        return bondEndDate;
    }

    public BondInfo setBondEndDate(String bondEndDate) {
        this.bondEndDate = bondEndDate;
        return this;
    }

    public String getBondRate() {
        return bondRate;
    }

    public BondInfo setBondRate(String bondRate) {
        this.bondRate = bondRate;
        return this;
    }



    public BigDecimal getBondPrice() {
        return bondPrice;
    }

    public BondInfo setBondPrice(BigDecimal bondPrice) {
        this.bondPrice = bondPrice;
        return this;
    }

    public String getDayCount() {
        return dayCount;
    }

    public BondInfo setDayCount(String dayCount) {
        this.dayCount = dayCount;
        return this;
    }

    public String getBondInterestPeriod() {
        return bondInterestPeriod;
    }

    public BondInfo setBondInterestPeriod(String bondInterestPeriod) {
        this.bondInterestPeriod = bondInterestPeriod;
        return this;
    }

    public BigDecimal getBondIssuePrice() {
        return bondIssuePrice;
    }

    public BondInfo setBondIssuePrice(BigDecimal bondIssuePrice) {
        this.bondIssuePrice = bondIssuePrice;
        return this;
    }

    public String getBondInterestStartDate() {
        return bondInterestStartDate;
    }

    public BondInfo setBondInterestStartDate(String bondInterestStartDate) {
        this.bondInterestStartDate = bondInterestStartDate;
        return this;
    }

    public String getBondIssueDate() {
        return bondIssueDate;
    }

    public BondInfo setBondIssueDate(String bondIssueDate) {
        this.bondIssueDate = bondIssueDate;
        return this;
    }

    public String getBondQuality() {
        return bondQuality;
    }

    public BondInfo setBondQuality(String bondQuality) {
        this.bondQuality = bondQuality;
        return this;
    }

    public String getBondLevel() {
        return bondLevel;
    }

    public BondInfo setBondLevel(String bondLevel) {
        this.bondLevel = bondLevel;
        return this;
    }

    public String getEntityId() {
        return entityId;
    }

    public BondInfo setEntityId(String entityId) {
        this.entityId = entityId;
        return this;
    }

    public String getEntityName() {
        return entityName;
    }

    public BondInfo setEntityName(String entityName) {
        this.entityName = entityName;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.bondCode;
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

    @Override
    public String toString() {
        return "BondInfo{" +
        ", bondCode=" + bondCode +
        ", bondName=" + bondName +
        ", bondEndDate=" + bondEndDate +
        ", bondRate=" + bondRate +
        ", bondBuyPrice=" + bondBuyPrice +
        ", bondSellPrice=" + bondSellPrice +
        ", bondPrice=" + bondPrice +
        ", dayCount=" + dayCount +
        ", bondInterestPeriod=" + bondInterestPeriod +
        ", bondIssuePrice=" + bondIssuePrice +
        ", bondInterestStartDate=" + bondInterestStartDate +
        ", bondIssueDate=" + bondIssueDate +
        ", bondQuality=" + bondQuality +
        ", bondLevel=" + bondLevel +
        ", entityId=" + entityId +
        ", entityName=" + entityName +
        "}";
    }
}
