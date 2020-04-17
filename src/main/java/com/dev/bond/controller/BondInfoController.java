package com.dev.bond.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dev.bond.entity.BondInfo;
import com.dev.bond.result.Result;
import com.dev.bond.service.IBondInfoService;
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
public class BondInfoController {
    @Autowired
    private IBondInfoService bondInfoService;

    @CrossOrigin
    @RequestMapping(value = "api/queryBondInfo", method = RequestMethod.POST)
    public Result queryBondInfo(@RequestBody HashMap<String, String> queryData) {
        System.out.println(queryData);
        System.out.println("--------");
        List<BondInfo> bondInfos = bondInfoService.selectList(new EntityWrapper<BondInfo>().eq(!StringUtils.isNullOrEmpty(queryData.get("bondCode")), "BOND_CODE", queryData.get("bondCode")).eq(!StringUtils.isNullOrEmpty(queryData.get("bondName")), "BOND_NAME", queryData.get("bondName")).eq(!StringUtils.isNullOrEmpty(queryData.get("entityName")), "ENTITY_NAME", queryData.get("entityName")));
        return new Result(200, "查询债券信息成功", bondInfos);
    }

    @CrossOrigin
    @RequestMapping(value = "api/deleteBond", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteBondInfo(@RequestBody HashMap<String, String> queryData) {
        System.out.println(queryData);
        System.out.println("--------");
        String bondCode = queryData.get("bondCode");
//        String entityName = queryData.get("entityName");
//        BondInfo entity_name = bondInfoService.selectOne(new EntityWrapper<BondInfo>().eq("ENTITY_NAME", entityName));
        boolean flag = bondInfoService.deleteById(bondCode);
        if (flag){
            return new Result(200, "下架成功");
        }else {
            return new Result(-1, "下架失败");
        }
//        return new Result(200,"",entity_name);

    }

    @CrossOrigin
    @RequestMapping(value = "api/changeBondInfo", method = RequestMethod.POST)
    @ResponseBody
    public Result changeBondInfo(@RequestBody BondInfo bondInfo) {
        boolean flag = bondInfoService.updateById(bondInfo);
        if(flag){
            return new Result(200, "修改债券信息成功");
        }else {
            return new Result(-1, "修改债券信息失败");
        }

    }
}

