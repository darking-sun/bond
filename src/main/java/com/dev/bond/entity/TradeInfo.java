package com.dev.bond.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author wzj123
 * @since 2020-04-17
 */
@TableName("trade_info")
public class TradeInfo extends Model<TradeInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 债券代码
     */
    @TableField("BOND_CODE")
    private String bondCode;
    /**
     * 债券名称
     */
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
    /**
     * 债券等级
     */
    @TableField("BOND_LEVEL")
    private String bondLevel;
    /**
     * 客户类型
     */
    @TableField("CUSTOMER_TYPE")
    private String customerType;
    /**
     * 证件类型
     */
    @TableField("CERTIFICATE_TYPE")
    private String certificateType;
    /**
     * 证件号码
     */
    @TableField("CERTIFICATE_NO")
    private String certificateNo;
    /**
     * 银行卡账户类型
     */
    @TableField("BANK_ACCOUNT_OPENING")
    private String bankAccountOpening;
    /**
     * 银行卡账号
     */
    @TableField("BANK_ACCOUNT_NUMBER")
    private String bankAccountNumber;
    /**
     * 客户姓名
     */
    @TableField("CUSTOMER_NAME")
    private String customerName;
    /**
     * 客户性别
     */
    @TableField("CUSTOMER_SEX")
    private String customerSex;
    /**
     * 客户电话
     */
    @TableField("CUSTOMER_MOBILE")
    private String customerMobile;
    /**
     * 客户邮箱
     */
    @TableField("CUSTOMER_EMAIL")
    private String customerEmail;
    /**
     * 客户地址
     */
    @TableField("CUSTOMER_ADDRESS")
    private String customerAddress;
    /**
     * 客户风险等级
     */
    @TableField("CUSTOMER_LEVEL")
    private String customerLevel;
    /**
     * 托管账号密码
     */
    @TableField("ACCOUNT_PASSWORD")
    private String accountPassword;
    /**
     * 账户状态
     */
    @TableField("ACCOUNT_STATUS")
    private String accountStatus;
    /**
     * 说明
     */
    @TableField("OTHER")
    private String other;
    /**
     * 托管账户号
     */
    @TableField("ACCOUNT_ID")
    private String accountId;
    /**
     * 手续费
     */
    @TableField("SERVICE_FEE")
    private BigDecimal serviceFee;
    /**
     * 交易日期
     */
    @TableField("DATE")
    private String date;
    /**
     * 交易份额
     */
    @TableField("BOND_SHARE")
    private BigDecimal bondShare;
    /**
     * 交易金额
     */
    @TableField("BOND_AMOUNT")
    private BigDecimal bondAmount;
    /**
     * 总金额
     */
    @TableField("TOTAL_AMOUNT")
    private BigDecimal totalAmount;
    /**
     * 机构ID
     */
    @TableField("ENTITY_ID")
    private String entityId;
    /**
     * 机构名称
     */
    @TableField("ENTITY_NAME")
    private String entityName;
    /**
     * 交易类型
     */
    @TableField("TRADE_TYPE")
    private String tradeType;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    public String getBondCode() {
        return bondCode;
    }

    public TradeInfo setBondCode(String bondCode) {
        this.bondCode = bondCode;
        return this;
    }

    public String getBondName() {
        return bondName;
    }

    public TradeInfo setBondName(String bondName) {
        this.bondName = bondName;
        return this;
    }

    public String getBondEndDate() {
        return bondEndDate;
    }

    public TradeInfo setBondEndDate(String bondEndDate) {
        this.bondEndDate = bondEndDate;
        return this;
    }

    public BigDecimal getBondRate() {
        return bondRate;
    }

    public TradeInfo setBondRate(BigDecimal bondRate) {
        this.bondRate = bondRate;
        return this;
    }

    public BigDecimal getBondBuyPrice() {
        return bondBuyPrice;
    }

    public TradeInfo setBondBuyPrice(BigDecimal bondBuyPrice) {
        this.bondBuyPrice = bondBuyPrice;
        return this;
    }

    public BigDecimal getBondSellPrice() {
        return bondSellPrice;
    }

    public TradeInfo setBondSellPrice(BigDecimal bondSellPrice) {
        this.bondSellPrice = bondSellPrice;
        return this;
    }

    public BigDecimal getBondPrice() {
        return bondPrice;
    }

    public TradeInfo setBondPrice(BigDecimal bondPrice) {
        this.bondPrice = bondPrice;
        return this;
    }

    public String getDayCount() {
        return dayCount;
    }

    public TradeInfo setDayCount(String dayCount) {
        this.dayCount = dayCount;
        return this;
    }

    public String getBondInterestPeriod() {
        return bondInterestPeriod;
    }

    public TradeInfo setBondInterestPeriod(String bondInterestPeriod) {
        this.bondInterestPeriod = bondInterestPeriod;
        return this;
    }

    public BigDecimal getBondIssuePrice() {
        return bondIssuePrice;
    }

    public TradeInfo setBondIssuePrice(BigDecimal bondIssuePrice) {
        this.bondIssuePrice = bondIssuePrice;
        return this;
    }

    public String getBondInterestStartDate() {
        return bondInterestStartDate;
    }

    public TradeInfo setBondInterestStartDate(String bondInterestStartDate) {
        this.bondInterestStartDate = bondInterestStartDate;
        return this;
    }

    public String getBondIssueDate() {
        return bondIssueDate;
    }

    public TradeInfo setBondIssueDate(String bondIssueDate) {
        this.bondIssueDate = bondIssueDate;
        return this;
    }

    public String getBondQuality() {
        return bondQuality;
    }

    public TradeInfo setBondQuality(String bondQuality) {
        this.bondQuality = bondQuality;
        return this;
    }

    public String getBondLevel() {
        return bondLevel;
    }

    public TradeInfo setBondLevel(String bondLevel) {
        this.bondLevel = bondLevel;
        return this;
    }

    public String getCustomerType() {
        return customerType;
    }

    public TradeInfo setCustomerType(String customerType) {
        this.customerType = customerType;
        return this;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public TradeInfo setCertificateType(String certificateType) {
        this.certificateType = certificateType;
        return this;
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public TradeInfo setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
        return this;
    }

    public String getBankAccountOpening() {
        return bankAccountOpening;
    }

    public TradeInfo setBankAccountOpening(String bankAccountOpening) {
        this.bankAccountOpening = bankAccountOpening;
        return this;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public TradeInfo setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
        return this;
    }

    public String getCustomerName() {
        return customerName;
    }

    public TradeInfo setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public String getCustomerSex() {
        return customerSex;
    }

    public TradeInfo setCustomerSex(String customerSex) {
        this.customerSex = customerSex;
        return this;
    }

    public String getCustomerMobile() {
        return customerMobile;
    }

    public TradeInfo setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
        return this;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public TradeInfo setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
        return this;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public TradeInfo setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
        return this;
    }

    public String getCustomerLevel() {
        return customerLevel;
    }

    public TradeInfo setCustomerLevel(String customerLevel) {
        this.customerLevel = customerLevel;
        return this;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public TradeInfo setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
        return this;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public TradeInfo setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
        return this;
    }

    public String getOther() {
        return other;
    }

    public TradeInfo setOther(String other) {
        this.other = other;
        return this;
    }

    public String getAccountId() {
        return accountId;
    }

    public TradeInfo setAccountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public TradeInfo setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
        return this;
    }

    public String getDate() {
        return date;
    }

    public TradeInfo setDate(String date) {
        this.date = date;
        return this;
    }

    public BigDecimal getBondShare() {
        return bondShare;
    }

    public TradeInfo setBondShare(BigDecimal bondShare) {
        this.bondShare = bondShare;
        return this;
    }

    public BigDecimal getBondAmount() {
        return bondAmount;
    }

    public TradeInfo setBondAmount(BigDecimal bondAmount) {
        this.bondAmount = bondAmount;
        return this;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public TradeInfo setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public String getEntityId() {
        return entityId;
    }

    public TradeInfo setEntityId(String entityId) {
        this.entityId = entityId;
        return this;
    }

    public String getEntityName() {
        return entityName;
    }

    public TradeInfo setEntityName(String entityName) {
        this.entityName = entityName;
        return this;
    }

    public String getTradeType() {
        return tradeType;
    }

    public TradeInfo setTradeType(String tradeType) {
        this.tradeType = tradeType;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public TradeInfo setId(Integer id) {
        this.id = id;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TradeInfo{" +
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
                ", customerType=" + customerType +
                ", certificateType=" + certificateType +
                ", certificateNo=" + certificateNo +
                ", bankAccountOpening=" + bankAccountOpening +
                ", bankAccountNumber=" + bankAccountNumber +
                ", customerName=" + customerName +
                ", customerSex=" + customerSex +
                ", customerMobile=" + customerMobile +
                ", customerEmail=" + customerEmail +
                ", customerAddress=" + customerAddress +
                ", customerLevel=" + customerLevel +
                ", accountPassword=" + accountPassword +
                ", accountStatus=" + accountStatus +
                ", other=" + other +
                ", accountId=" + accountId +
                ", serviceFee=" + serviceFee +
                ", date=" + date +
                ", bondShare=" + bondShare +
                ", bondAmount=" + bondAmount +
                ", totalAmount=" + totalAmount +
                ", entityId=" + entityId +
                ", entityName=" + entityName +
                ", tradeType=" + tradeType +
                ", id=" + id +
                "}";
    }
}
