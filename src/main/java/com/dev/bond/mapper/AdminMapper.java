package com.dev.bond.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.dev.bond.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wzj123
 * @since 2019-11-16
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {


    public Admin findByAdminName(@Param("adminName") String adminName);


}
