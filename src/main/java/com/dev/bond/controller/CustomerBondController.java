package com.dev.bond.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dev.bond.entity.CustomerBond;
import com.dev.bond.entity.CustomerInfo;
import com.dev.bond.entity.OrderRecord;
import com.dev.bond.result.Result;
import com.dev.bond.service.ICustomerBondService;
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
public class CustomerBondController {
    @Autowired
    private ICustomerBondService customerBondService;

    @CrossOrigin
    @RequestMapping(value = "api/queryAccountBond",method = RequestMethod.POST)
    @ResponseBody
    public Result queryAccountBond(@RequestBody HashMap<String,String> data){
        String accountId = data.get("accountId");
        List<CustomerBond> customerBonds = customerBondService.selectList(new EntityWrapper<CustomerBond>().eq("ACCOUNT_ID", accountId));
        return new Result(200,"获取客户持仓成功",customerBonds);
    }

    @CrossOrigin
    @RequestMapping(value = "api/querycustomerBondList", method = RequestMethod.POST)
    @ResponseBody
    public Result customerBondList(@RequestBody CustomerInfo queryData) {
        String accountId = queryData.getAccountId();
        List<OrderRecord> orderRecords = customerBondService.selectBondList(accountId);
        return new Result(200,"获取成功",orderRecords);
    }
}

