package com.dev.bond.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dev.bond.entity.Enum;
import com.dev.bond.mapper.EnumMapper;
import com.dev.bond.service.IEnumService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wzj123
 * @since 2020-02-19
 */
@Service
public class EnumServiceImpl extends ServiceImpl<EnumMapper, Enum> implements IEnumService {
    @Resource
    private EnumMapper enumMapper;

    @Override
    public boolean insertService(Enum serviceFee) throws Exception{
        Integer integer = enumMapper.valiteService(serviceFee);
        System.out.println(integer);
        if(integer ==  0){
           return enumMapper.insertService(serviceFee);
        }else{
            return false;
        }

    }

    @Override
    public void updateService(Enum serviceFee) throws Exception{
        enumMapper.updateService(serviceFee);
    }

    @Override
    public void deleteService(Enum serviceFee) throws Exception{
        enumMapper.deleteService(serviceFee);
    }
}
