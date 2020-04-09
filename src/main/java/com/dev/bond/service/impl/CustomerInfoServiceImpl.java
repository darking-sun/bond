package com.dev.bond.service.impl;

import com.dev.bond.entity.CustomerInfo;
import com.dev.bond.mapper.CustomerInfoMapper;
import com.dev.bond.service.ICustomerInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wzj123
 * @since 2020-02-25
 */
@Service
public class CustomerInfoServiceImpl extends ServiceImpl<CustomerInfoMapper, CustomerInfo> implements ICustomerInfoService {

}
