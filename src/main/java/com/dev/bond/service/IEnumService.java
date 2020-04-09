package com.dev.bond.service;

import com.dev.bond.entity.Enum;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wzj123
 * @since 2020-02-19
 */
public interface IEnumService extends IService<Enum> {
    boolean insertService(Enum serviceFee) throws Exception;
    void updateService(Enum serviceFee) throws Exception;
    void deleteService(Enum serviceFee) throws Exception;

}
