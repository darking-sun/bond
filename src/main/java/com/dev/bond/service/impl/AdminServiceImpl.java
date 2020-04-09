package com.dev.bond.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dev.bond.entity.Admin;
import com.dev.bond.mapper.AdminMapper;
import com.dev.bond.service.IAdminService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wzj123
 * @since 2019-11-16
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

}
