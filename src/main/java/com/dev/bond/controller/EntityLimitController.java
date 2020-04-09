package com.dev.bond.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dev.bond.entity.EntityLimit;
import com.dev.bond.result.Result;
import com.dev.bond.service.IEntityLimitService;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wzj123
 * @since 2020-03-16
 */
@RestController
public class EntityLimitController {
    @Autowired
    private IEntityLimitService entityLimitService;

    @CrossOrigin
    @RequestMapping(value = "api/queryEntityInfo", method = RequestMethod.POST)
    @ResponseBody
    public Result queryBondInfo(@RequestBody HashMap<String, String> queryData) {
        List<EntityLimit> entityLimits = entityLimitService.selectList(new EntityWrapper<EntityLimit>().eq(!StringUtils.isNullOrEmpty(queryData.get("entityId")), "ENTITY_ID", queryData.get("entityId")).eq(!StringUtils.isNullOrEmpty(queryData.get("entityName")), "ENTITY_NAME", queryData.get("entityName")));
        return new Result(200, "查询机构信息成功", entityLimits);
    }
}

