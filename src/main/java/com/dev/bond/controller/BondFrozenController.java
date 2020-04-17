package com.dev.bond.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dev.bond.entity.CustomerBond;
import com.dev.bond.entity.CustomerInfo;
import com.dev.bond.result.Result;
import com.dev.bond.service.ICustomerBondService;
import com.dev.bond.service.ICustomerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wzj123
 * @since 2020-03-16
 */
@RestController
public class BondFrozenController {
    @Autowired
    private ICustomerBondService customerBondService;

    @Autowired
    private ICustomerInfoService customerInfoService;

    @CrossOrigin
    @RequestMapping(value = "api/bondFrozen", method = RequestMethod.POST)
    public Result bondFrozen(@RequestBody HashMap<String,String> hashMap) {
        String accountId = hashMap.get("accountId");
        BigDecimal bondShare = new BigDecimal(hashMap.get("bondShare"));
        String bondCode = hashMap.get("bondCode");
        String frozenReason = hashMap.get("frozenReason");
        String bookNumber = hashMap.get("bookNumber");
//        String entityId = hashMap.get("entityId");
//        String entityName = hashMap.get("entityName");
        CustomerInfo customerInfo = customerInfoService.selectOne(new EntityWrapper<CustomerInfo>().eq("ACCOUNT_ID", accountId));
        if (customerInfo == null || !customerInfo.getAccountStatus().equals("NORMAL")) {
            return new Result(202, "托管账户状态异常");
        } else {
            CustomerBond customerBond = customerBondService.selectOne(new EntityWrapper<CustomerBond>().eq("ACCOUNT_ID", accountId).eq("BOND_CODE", bondCode));
            customerBond.setFrozenShare(customerBond.getFrozenShare().add(bondShare));
            customerBond.setTradeShare(customerBond.getTradeShare().subtract(bondShare));
            customerBondService.update(customerBond, new EntityWrapper<CustomerBond>().eq("ACCOUNT_ID", accountId).eq("BOND_CODE", bondCode));
            return new Result(200, "债券冻结成功");
        }
    }
    }

