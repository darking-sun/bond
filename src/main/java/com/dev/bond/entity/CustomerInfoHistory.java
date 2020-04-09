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
 * @since 2020-04-08
 */
@TableName("customer_info_history")
public class CustomerInfoHistory extends Model<CustomerInfoHistory> {

    private static final long serialVersionUID = 1L;

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
     * 客户密码
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
     * 托管账号
     */
    @TableId("ACCOUNT_ID")
    private String accountId;
    /**
     * 手续费
     */
    @TableField("SERVICE_FEE")
    private String serviceFee;
    /**
     * 时间
     */
    @TableField("DATE")
    private String date;


    public String getCustomerType() {
        return customerType;
    }

    public CustomerInfoHistory setCustomerType(String customerType) {
        this.customerType = customerType;
        return this;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public CustomerInfoHistory setCertificateType(String certificateType) {
        this.certificateType = certificateType;
        return this;
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public CustomerInfoHistory setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
        return this;
    }

    public String getBankAccountOpening() {
        return bankAccountOpening;
    }

    public CustomerInfoHistory setBankAccountOpening(String bankAccountOpening) {
        this.bankAccountOpening = bankAccountOpening;
        return this;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public CustomerInfoHistory setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
        return this;
    }

    public String getCustomerName() {
        return customerName;
    }

    public CustomerInfoHistory setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public String getCustomerSex() {
        return customerSex;
    }

    public CustomerInfoHistory setCustomerSex(String customerSex) {
        this.customerSex = customerSex;
        return this;
    }

    public String getCustomerMobile() {
        return customerMobile;
    }

    public CustomerInfoHistory setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
        return this;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public CustomerInfoHistory setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
        return this;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public CustomerInfoHistory setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
        return this;
    }

    public String getCustomerLevel() {
        return customerLevel;
    }

    public CustomerInfoHistory setCustomerLevel(String customerLevel) {
        this.customerLevel = customerLevel;
        return this;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public CustomerInfoHistory setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
        return this;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public CustomerInfoHistory setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
        return this;
    }

    public String getOther() {
        return other;
    }

    public CustomerInfoHistory setOther(String other) {
        this.other = other;
        return this;
    }

    public String getAccountId() {
        return accountId;
    }

    public CustomerInfoHistory setAccountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    public String getServiceFee() {
        return serviceFee;
    }

    public CustomerInfoHistory setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
        return this;
    }

    public String getDate() {
        return date;
    }

    public CustomerInfoHistory setDate(String date) {
        this.date = date;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.accountId;
    }

    @Override
    public String toString() {
        return "CustomerInfoHistory{" +
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
        "}";
    }
}
