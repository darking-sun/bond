package com.dev.bond.service.impl;

import com.dev.bond.entity.CustomerInfoHistory;
import com.dev.bond.mapper.CustomerInfoHistoryMapper;
import com.dev.bond.service.ICustomerInfoHistoryService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wzj123
 * @since 2020-04-08
 */
@Service
public class CustomerInfoHistoryServiceImpl extends ServiceImpl<CustomerInfoHistoryMapper, CustomerInfoHistory> implements ICustomerInfoHistoryService {

}
