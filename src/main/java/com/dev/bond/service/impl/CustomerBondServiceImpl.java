package com.dev.bond.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dev.bond.entity.CustomerBond;
import com.dev.bond.entity.OrderRecord;
import com.dev.bond.mapper.CustomerBondMapper;
import com.dev.bond.service.ICustomerBondService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wzj123
 * @since 2020-03-16
 */
@Service
public class CustomerBondServiceImpl extends ServiceImpl<CustomerBondMapper, CustomerBond> implements ICustomerBondService {
    @Resource
    private CustomerBondMapper customerBondMapper;

    @Override
    public List<OrderRecord> selectBondList(String accountId){
        return customerBondMapper.selectBondList(accountId);
    }
}
