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
@TableName("entity_limit")
public class EntityLimit extends Model<EntityLimit> {

    private static final long serialVersionUID = 1L;

    /**
     * 机构号
     */
    @TableId("ENTITY_ID")
    private String entityId;
    /**
     * 债券代码
     */
    @TableField("BOND_CODE")
    private String bondCode;
    /**
     * 总限额
     */
    @TableField("TOTAL_SHARE")
    private BigDecimal totalShare;
    /**
     * 已卖限额
     */
    @TableField("SALE_SHARE")
    private BigDecimal saleShare;
    @TableField("BOND_NAME")
    private String bondName;
    @TableField("ENTITY_NAME")
    private String entityName;


    public String getEntityId() {
        return entityId;
    }

    public EntityLimit setEntityId(String entityId) {
        this.entityId = entityId;
        return this;
    }

    public String getBondCode() {
        return bondCode;
    }

    public EntityLimit setBondCode(String bondCode) {
        this.bondCode = bondCode;
        return this;
    }

    public BigDecimal getTotalShare() {
        return totalShare;
    }

    public EntityLimit setTotalShare(BigDecimal totalShare) {
        this.totalShare = totalShare;
        return this;
    }

    public BigDecimal getSaleShare() {
        return saleShare;
    }

    public EntityLimit setSaleShare(BigDecimal saleShare) {
        this.saleShare = saleShare;
        return this;
    }

    public String getBondName() {
        return bondName;
    }

    public EntityLimit setBondName(String bondName) {
        this.bondName = bondName;
        return this;
    }

    public String getEntityName() {
        return entityName;
    }

    public EntityLimit setEntityName(String entityName) {
        this.entityName = entityName;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.entityId;
    }

    @Override
    public String toString() {
        return "EntityLimit{" +
        ", entityId=" + entityId +
        ", bondCode=" + bondCode +
        ", totalShare=" + totalShare +
        ", saleShare=" + saleShare +
        ", bondName=" + bondName +
        ", entityName=" + entityName +
        "}";
    }
}
