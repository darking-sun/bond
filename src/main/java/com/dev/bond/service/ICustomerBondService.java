package com.dev.bond.service;

import com.dev.bond.entity.CustomerBond;
import com.baomidou.mybatisplus.service.IService;
import com.dev.bond.entity.OrderRecord;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wzj123
 * @since 2020-03-16
 */
public interface ICustomerBondService extends IService<CustomerBond> {
   List<OrderRecord> selectBondList(String accountId);
}
