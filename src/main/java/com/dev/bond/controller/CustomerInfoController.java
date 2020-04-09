package com.dev.bond.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dev.bond.entity.CustomerInfo;
import com.dev.bond.entity.CustomerInfoHistory;
import com.dev.bond.result.Result;
import com.dev.bond.service.ICustomerBondService;
import com.dev.bond.service.ICustomerInfoHistoryService;
import com.dev.bond.service.ICustomerInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wzj123
 * @since 2020-02-25
 */
@RestController
public class CustomerInfoController {
    @Autowired
    private ICustomerInfoService customerInfoService;
    @Autowired
    private ICustomerBondService customerBondService;
    @Autowired
    private ICustomerInfoHistoryService customerInfoHistoryService;

    @CrossOrigin
    @RequestMapping(value = "api/addAccount",method = RequestMethod.POST)
    @ResponseBody
    public Result insertCustomer(@RequestBody CustomerInfo customerInfo){
        System.out.println(customerInfo);
        CustomerInfo valitCustomerInfo = customerInfoService.selectOne(new EntityWrapper<CustomerInfo>().eq("CERTIFICATE_NO", customerInfo.getCertificateNo()).eq("CERTIFICATE_TYPE", customerInfo.getCertificateType()));
        if(valitCustomerInfo == null ){
            String accountData = customerInfo.getDate();
            String dataFormat = accountData.substring(0,10).replaceAll("-","");
            String accountCertificateNo = customerInfo.getCertificateNo();
            String accountId = dataFormat.concat(accountCertificateNo);
            customerInfo.setAccountId(accountId);
            customerInfo.setAccountStatus("1");
            boolean insert = customerInfoService.insert(customerInfo);
            if(insert){
                return new Result(200,"开户成功");
            }else {
                return new Result(201,"开户失败");
            }
        }else{
            return new Result(202,"用户已存在，不能再次开户");
        }


    }
    @CrossOrigin
    @RequestMapping(value = "api/queryPassword",method = RequestMethod.POST)
    @ResponseBody
    public Result queryAccountPassword(@RequestBody CustomerInfo queryData){
        String accountId = queryData.getAccountId();
        CustomerInfo customerInfo = customerInfoService.selectOne(new EntityWrapper<CustomerInfo>().eq("ACCOUNT_ID",accountId));
        if(customerInfo != null){
            String accountPassword = customerInfo.getAccountPassword();
            return new Result(200,"查询密码成功",accountPassword);
        }else {
            return new Result(-1);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "api/queryAccountInfo",method = RequestMethod.POST)
    @ResponseBody
    public Result queryAccountInfo(@RequestBody CustomerInfo queryData){

        String accountId = queryData.getAccountId();
        CustomerInfo customerInfo = customerInfoService.selectOne(new EntityWrapper<CustomerInfo>().eq("ACCOUNT_ID",accountId));
        List<CustomerInfo> list = new ArrayList<>();
        list.add(customerInfo);
        if(customerInfo != null){
            return new Result(200,"查询客户信息成功",list);
        }else {
            return new Result(-1);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "api/queryClosedAccount",method = RequestMethod.POST)
    @ResponseBody
    public Result queryClosedAccount(){
        List<CustomerInfo> list = customerInfoService.selectList(new EntityWrapper<CustomerInfo>().eq("ACCOUNT_STATUS", 0));
        return new Result(200,"查询注销客户信息成功",list);

    }

    @CrossOrigin
    @RequestMapping(value = "api/batchMoveAccount",method = RequestMethod.POST)
    @ResponseBody
    public Result batchMoveAccount(){
        List<CustomerInfo> list = customerInfoService.selectList(new EntityWrapper<CustomerInfo>().eq("ACCOUNT_STATUS", 0));

        List<CustomerInfoHistory> customerInfoHistoryList = new ArrayList<>();
        for (CustomerInfo i : list){
            HashMap<String,Object> hashMap = new HashMap<>();
            String accountId = i.getAccountId();
            hashMap.put("ACCOUNT_ID",accountId);
            hashMap.put("ACCOUNT_Status",0);
            CustomerInfoHistory customerInfoHistory = new CustomerInfoHistory();
            BeanUtils.copyProperties(i,customerInfoHistory);
            customerInfoHistoryList.add(customerInfoHistory);
            customerInfoService.deleteByMap(hashMap);
        }
        customerInfoHistoryService.insertBatch(customerInfoHistoryList);
        return new Result(200,"迁移客户成功");

    }

    @CrossOrigin
    @RequestMapping(value = "api/updateAccountInfo",method = RequestMethod.POST)
    @ResponseBody
    public Result updateAccountInfo(@RequestBody CustomerInfo customerData){
        String accountId = customerData.getAccountId();
        boolean updadeAccount = customerInfoService.updateById(customerData);
        if(updadeAccount == true){
            return new Result(200,"更新客户信息成功");
        }else {
            return new Result(-1);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "api/queryOneAccount",method = RequestMethod.POST)
    @ResponseBody
    public Result queryOneAccount(@RequestBody CustomerInfo queryData){
        String accountId = queryData.getAccountId();
        CustomerInfo customerInfo = customerInfoService.selectOne(new EntityWrapper<CustomerInfo>().eq("ACCOUNT_ID",accountId));
        if(customerInfo != null){
            return new Result(200,"查询客户信息成功",customerInfo);
        }else {
            return new Result(-1);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "api/closeAccount",method = RequestMethod.POST)
    @ResponseBody
    public Result closeAccount(@RequestBody HashMap<String,String> json){
       String accountId = json.get("accountId");
        System.out.println("======================");
        System.out.println(accountId);
            CustomerInfo customerInfo = customerInfoService.selectOne(new EntityWrapper<CustomerInfo>().eq("ACCOUNT_ID", accountId));
        String accountStatus = customerInfo.getAccountStatus();
        if(accountStatus.equals("1")){
            customerInfo.setAccountStatus("0");
            boolean response = customerInfoService.updateById(customerInfo);
            if(response){
                return new Result(200,"注销成功");
            }else {
                return new Result(201,"注销失败");
            }
        }else {
            return new Result(202,"用户不可销户");
        }
   }
}

