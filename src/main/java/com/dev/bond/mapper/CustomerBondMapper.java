package com.dev.bond.mapper;

import com.dev.bond.entity.CustomerBond;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.dev.bond.entity.OrderRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wzj123
 * @since 2020-03-16
 */
@Mapper
public interface CustomerBondMapper extends BaseMapper<CustomerBond> {
    List<OrderRecord> selectBondList(@Param("accountId") String accountId);
}
