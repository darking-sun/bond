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
 * @since 2020-02-19
 */
@TableName("enum")
public class Enum extends Model<Enum> {

    private static final long serialVersionUID = 1L;

    /**
     * 枚举名称
     */
    @TableId("ENUM_NAME")
    private String enumName;
    /**
     * 枚举值
     */
    @TableField("ENUM_VALUE")
    private String enumValue;
    /**
     * 枚举类型
     */
    @TableField("ENUM_TYPE")
    private String enumType;


    public String getEnumName() {
        return enumName;
    }

    public Enum setEnumName(String enumName) {
        this.enumName = enumName;
        return this;
    }

    public String getEnumValue() {
        return enumValue;
    }

    public Enum setEnumValue(String enumValue) {
        this.enumValue = enumValue;
        return this;
    }

    public String getEnumType() {
        return enumType;
    }

    public Enum setEnumType(String enumType) {
        this.enumType = enumType;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.enumName;
    }

    @Override
    public String toString() {
        return "Enum{" +
        ", enumName=" + enumName +
        ", enumValue=" + enumValue +
        ", enumType=" + enumType +
        "}";
    }
}
