package com.dev.bond.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wzj123
 * @since 2020-04-06
 */
@TableName("sys_parameter")
public class SysParameter extends Model<SysParameter> {

    private static final long serialVersionUID = 1L;

    @TableField("TRADE_START_TIME")
    private String tradeStartTime;
    @TableField("TRADE_END_TIME")
    private String tradeEndTime;
    @TableField("TRADE_TYPE")
    private String tradeType;


    public String getTradeStartTime() {
        return tradeStartTime;
    }

    public SysParameter setTradeStartTime(String tradeStartTime) {
        this.tradeStartTime = tradeStartTime;
        return this;
    }

    public String getTradeEndTime() {
        return tradeEndTime;
    }

    public SysParameter setTradeEndTime(String tradeEndTime) {
        this.tradeEndTime = tradeEndTime;
        return this;
    }

    @Override
    public String toString() {
        return "SysParameter{" +
                "tradeStartTime='" + tradeStartTime + '\'' +
                ", tradeEndTime='" + tradeEndTime + '\'' +
                ", tradeType='" + tradeType + '\'' +
                '}';
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }


    @Override
    protected Serializable pkVal() {
        return this.tradeType;
    }

}
