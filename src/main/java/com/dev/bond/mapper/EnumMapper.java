package com.dev.bond.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.dev.bond.entity.Enum;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wzj123
 * @since 2020-02-19
 */
@Mapper
public interface EnumMapper extends BaseMapper<Enum> {
    List<Enum> selectServiceFeeByEnumName(@Param("enumName") String enumName);
    Integer valiteService(Enum serviceFee);
    boolean insertService(Enum serviceFee);
    void updateService(Enum serviceFee);
    void deleteService(Enum serviceFee);

}
