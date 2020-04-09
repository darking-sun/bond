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
 * @since 2019-11-16
 */
@TableName("admin")
public class Admin extends Model<Admin> {

    private static final long serialVersionUID = 1L;

    @TableId("ADMIN_NAME")
    private String adminName;
    @TableField("ADMIN_PASSWORD")
    private String adminPassword;


    public String getAdminName() {
        return adminName;
    }

    public Admin setAdminName(String adminName) {
        this.adminName = adminName;
        return this;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public Admin setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.adminName;
    }

    @Override
    public String toString() {
        return "Admin{" +
        ", adminName=" + adminName +
        ", adminPassword=" + adminPassword +
        "}";
    }
}
