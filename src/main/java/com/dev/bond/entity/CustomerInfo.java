package com.dev.bond.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wzj123
 * @since 2020-02-25
 */
@TableName("customer_info")
public class CustomerInfo extends Model<CustomerInfo> implements Cloneable{

    private static final long serialVersionUID = 1L;

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
    @TableId("CERTIFICATE_NO")
    private String certificateNo;
    /**
     * 银行卡账户类型
     */
    @TableField("BANK_ACCOUNT_OPENING")
    private String bankAccountOpening;
    @TableField("BANK_ACCOUNT_NUMBER")
    private String bankAccountNumber;
    @TableField("CUSTOMER_NAME")
    private String customerName;
    @TableField("CUSTOMER_SEX")
    private String customerSex;
    @TableField("CUSTOMER_MOBILE")
    private String customerMobile;
    @TableField("CUSTOMER_EMAIL")
    private String customerEmail;
    @TableField("CUSTOMER_ADDRESS")
    private String customerAddress;
    @TableField("CUSTOMER_LEVEL")
    private String customerLevel;
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
    @TableField("ACCOUNT_ID")
    private String accountId;
    @TableField("SERVICE_FEE")
    private String serviceFee;
    @TableField("DATE")
    private String date;


    public String getCustomerType() {
        return customerType;
    }

    public CustomerInfo setCustomerType(String customerType) {
        this.customerType = customerType;
        return this;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public CustomerInfo setCertificateType(String certificateType) {
        this.certificateType = certificateType;
        return this;
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public CustomerInfo setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
        return this;
    }

    public String getBankAccountOpening() {
        return bankAccountOpening;
    }

    public CustomerInfo setBankAccountOpening(String bankAccountOpening) {
        this.bankAccountOpening = bankAccountOpening;
        return this;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public CustomerInfo setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
        return this;
    }

    public String getCustomerName() {
        return customerName;
    }

    public CustomerInfo setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public String getCustomerSex() {
        return customerSex;
    }

    public CustomerInfo setCustomerSex(String customerSex) {
        this.customerSex = customerSex;
        return this;
    }

    public String getCustomerMobile() {
        return customerMobile;
    }

    public CustomerInfo setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
        return this;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public CustomerInfo setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
        return this;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public CustomerInfo setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
        return this;
    }

    public String getCustomerLevel() {
        return customerLevel;
    }

    public CustomerInfo setCustomerLevel(String customerLevel) {
        this.customerLevel = customerLevel;
        return this;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public CustomerInfo setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
        return this;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public CustomerInfo setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
        return this;
    }

    public String getOther() {
        return other;
    }

    public CustomerInfo setOther(String other) {
        this.other = other;
        return this;
    }

    public String getAccountId() {
        return accountId;
    }

    public CustomerInfo setAccountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    public String getServiceFee() {
        return serviceFee;
    }

    public CustomerInfo setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
        return this;
    }

    public String getDate() {
        return date;
    }

    public CustomerInfo setDate(String date) {
        this.date = date;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.certificateNo;
    }

    @Override
    public String toString() {
        return "CustomerInfo{" +
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

    @Override
    public Object clone(){
        CustomerInfo customerInfo = null;
        try {
            customerInfo = (CustomerInfo)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return customerInfo;
    }
}
