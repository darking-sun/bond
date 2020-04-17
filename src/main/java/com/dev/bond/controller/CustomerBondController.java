package com.dev.bond.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dev.bond.entity.CustomerBond;
import com.dev.bond.entity.CustomerInfo;
import com.dev.bond.entity.CustomerLimit;
import com.dev.bond.entity.OrderRecord;
import com.dev.bond.result.Result;
import com.dev.bond.service.ICustomerBondService;
import com.dev.bond.service.ICustomerLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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

    @Autowired
    private ICustomerLimitService customerLimitService;

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

    @CrossOrigin
    @RequestMapping(value = "api/bondNonTrade", method = RequestMethod.POST)
    @ResponseBody
    public Result bondNonTrade(@RequestBody HashMap<String,String> hashMap) {
        String accountId = hashMap.get("accountId");
        String toAccountId = hashMap.get("toAccountId");
        BigDecimal bondShare = new BigDecimal(hashMap.get("bondShare"));
        String bondCode = hashMap.get("bondCode");
        String transferReason = hashMap.get("transferReason");
        String bookNumber = hashMap.get("bookNumber");
        String entityId = hashMap.get("entityId");
        String entityName = hashMap.get("entityName");
        CustomerBond customerBond = customerBondService.selectOne(new EntityWrapper<CustomerBond>().eq("ACCOUNT_ID", accountId).eq("BOND_CODE", bondCode));
        CustomerBond toCustomerBond = customerBondService.selectOne(new EntityWrapper<CustomerBond>().eq("ACCOUNT_ID", toAccountId).eq("BOND_CODE", bondCode));
        customerBond.setTotalShare(customerBond.getTotalShare().subtract(bondShare));
        customerBond.setTradeShare(customerBond.getTradeShare().subtract(bondShare));
        CustomerLimit customerLimit = customerLimitService.selectOne(new EntityWrapper<CustomerLimit>().eq("ACCOUNT_ID", toAccountId));

        customerBondService.update(customerBond,new EntityWrapper<CustomerBond>().eq("ACCOUNT_ID", accountId).eq("BOND_CODE", bondCode) );
        List<CustomerBond> customerBonds = customerBondService.selectList(new EntityWrapper<CustomerBond>().eq("ACCOUNT_ID", toAccountId));
        BigDecimal customerToatlShare = BigDecimal.valueOf(0);
        for(CustomerBond i: customerBonds){
            customerToatlShare = customerToatlShare.add(i.getTotalShare());
        }
        BigDecimal customerUseShare = customerLimit.getTotalShare().subtract(customerToatlShare);
        if(bondShare.compareTo(customerUseShare) > 0) {
            return new Result(202, "过户债券额度超出个人可购额度");
        }else if (toCustomerBond == null){
            toCustomerBond.setTradeShare(bondShare);
            toCustomerBond.setTotalShare(bondShare);
            toCustomerBond.setBondCode(bondCode);
            toCustomerBond.setAccountId(toAccountId);
            toCustomerBond.setBondName(customerBond.getBondName());
            toCustomerBond.setFrozenShare(BigDecimal.valueOf(0));
            toCustomerBond.setEntityId(entityId);
            toCustomerBond.setEntityName(entityName);
            customerBondService.insert(toCustomerBond);
        }else {
            toCustomerBond.setTradeShare(toCustomerBond.getTradeShare().add(bondShare));
            toCustomerBond.setTotalShare(toCustomerBond.getTotalShare().add(bondShare));
            customerBondService.update(toCustomerBond,new EntityWrapper<CustomerBond>().eq("ACCOUNT_ID", accountId).eq("BOND_CODE", bondCode));

        }
        return new Result(200,"非交易过户成功");
    }

}

