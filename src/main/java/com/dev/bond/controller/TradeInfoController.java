package com.dev.bond.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dev.bond.entity.*;
import com.dev.bond.result.Result;
import com.dev.bond.service.*;
import com.dev.bond.util.tradeInfoInsert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class TradeInfoController {
    @Autowired
    private IBondInfoService bondInfoService;
    @Autowired
    private ICustomerInfoService customerInfoService;
    @Autowired
    private ICustomerBondService customerBondService;
    @Autowired
    private IEntityLimitService entityLimitService;
    @Autowired
    private ICustomerLimitService customerLimitService;
    @Autowired
    private ITradeInfoService tradeInfoService;

    @CrossOrigin
    @RequestMapping(value = "api/bondOrder", method = RequestMethod.POST)
    @ResponseBody
    public Result bondOrder(@RequestBody HashMap<String, String> queryData) {
        System.out.println(queryData);
        System.out.println("--------");
        String bondCode = queryData.get("bondCode");
        String entityId = queryData.get("entityId");
        String accountID = queryData.get("accountId");
        String bondShare = queryData.get("bondShare");
        BigDecimal orderShare = new BigDecimal(bondShare);
        CustomerInfo customerInfo = customerInfoService.selectOne(new EntityWrapper<CustomerInfo>().eq("ACCOUNT_ID", accountID));
        if (!customerInfo.getAccountStatus().equals("NORMAL")){
            return new Result(201,"账户状态异常，不可以交易");
        }else {
            BondInfo bondInfo = bondInfoService.selectOne(new EntityWrapper<BondInfo>().eq("BOND_CODE", bondCode).eq("ENTITY_ID", entityId));
            EntityLimit entityLimit = entityLimitService.selectOne(new EntityWrapper<EntityLimit>().eq("BOND_CODE", bondCode).eq("ENTITY_ID", entityId));
            CustomerLimit customerLimit = customerLimitService.selectOne(new EntityWrapper<CustomerLimit>().eq("ACCOUNT_ID", accountID));
            CustomerBond customerBond = customerBondService.selectOne(new EntityWrapper<CustomerBond>().eq("ACCOUNT_ID", accountID).eq("BOND_CODE", bondCode));

                BigDecimal useShare = entityLimit.getTotalShare().subtract(entityLimit.getSaleShare());
                BigDecimal customerUseShare = customerLimit.getTotalShare().subtract(customerLimit.getBuyShare());
                TradeInfo tradeInfo = new TradeInfo();
                if(orderShare.compareTo(useShare) > 0){
                    return new Result(201, "购买债券额度超出机构可售额度");
                }else  if(orderShare.compareTo(customerUseShare) > 0){
                    return new Result(202, "购买债券额度超出个人可购额度");
                }else {
                    if(customerBond == null){
                        CustomerBond customerBond1 = new CustomerBond();
                        customerBond1.setTotalShare(orderShare);
                        customerBond1.setFrozenShare(orderShare);
                        customerBond1.setTradeShare(new BigDecimal("0"));
                        customerBond1.setEntityName(entityLimit.getEntityName());
                        customerBond1.setEntityId(entityId);
                        customerBond1.setBondCode(bondCode);
                        customerBond1.setBondName(bondInfo.getBondName());
                        customerBond1.setAccountId(accountID);
                        customerBondService.insert(customerBond1);
                    }else{
                        customerBond.setTotalShare(customerBond.getTotalShare().add(orderShare));
                        customerBond.setFrozenShare(customerBond.getFrozenShare().add(orderShare));
                        customerBondService.update(customerBond,new EntityWrapper<CustomerBond>().eq("ACCOUNT_ID",accountID).eq("BOND_CODE",bondCode));

                    }
                  customerLimit.setBuyShare(customerLimit.getBuyShare().add(orderShare));
                    customerLimitService.updateById(customerLimit);
                    entityLimit.setSaleShare(entityLimit.getSaleShare().add(orderShare));
                    entityLimitService.update(entityLimit,new EntityWrapper<EntityLimit>().eq("ENTITY_ID",entityId).eq("BOND_CODE",bondCode));
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
                    String datetime = simpleDateFormat.format(new Date());
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("accountId", accountID);
                    hashMap.put("tradeType", "债券申购");
                    hashMap.put("bondCode",bondCode);
//                    EnumController enumController = (EnumController) SpringUtil.getBean(EnumController.class);
//                    String serviceFee = (String) enumController.getService(hashMap).getData();
                    hashMap.put("serviceFee", queryData.get("serviceFee"));
                    hashMap.put("date", datetime);//申购时间
                    hashMap.put("bondShare", queryData.get("bondShare"));
                    hashMap.put("bondAmount", queryData.get("bondAmount"));
                    hashMap.put("totalAmount",queryData.get("totalAmount"));
                    tradeInfoInsert tradeInfoInsert = new tradeInfoInsert();
                    tradeInfoInsert.insertTradeInfo(hashMap);
                    return new Result(200, "申购债券成功");
                }


        }


    }

    @CrossOrigin
    @RequestMapping(value = "api/bondBuy", method = RequestMethod.POST)
    @ResponseBody
    public Result bondBuy(@RequestBody HashMap<String, String> queryData) {
        System.out.println(queryData);
        System.out.println("--------");
        String bondCode = queryData.get("bondCode");
        String entityId = queryData.get("entityId");
        String accountID = queryData.get("accountId");
        String bondShare = queryData.get("bondShare");
        BigDecimal orderShare = new BigDecimal(bondShare);
        EntityLimit entityLimit = entityLimitService.selectOne(new EntityWrapper<EntityLimit>().eq("BOND_CODE", bondCode).eq("ENTITY_ID", entityId));
        CustomerLimit customerLimit = customerLimitService.selectOne(new EntityWrapper<CustomerLimit>().eq("ACCOUNT_ID", accountID));
        List<CustomerBond> customerBonds = customerBondService.selectList(new EntityWrapper<CustomerBond>().eq("ACCOUNT_ID", accountID));
        CustomerBond customerBond = customerBondService.selectOne(new EntityWrapper<CustomerBond>().eq("ACCOUNT_ID", accountID).eq("BOND_CODE", bondCode));
        BigDecimal customerToatlShare = BigDecimal.valueOf(0);
        for(CustomerBond i: customerBonds){
            customerToatlShare = customerToatlShare.add(i.getTotalShare());
        }
        BigDecimal useShare = entityLimit.getTotalShare().subtract(entityLimit.getSaleShare());

        BigDecimal customerUseShare = customerLimit.getTotalShare().subtract(customerToatlShare);
        if(orderShare.compareTo(useShare) > 0){
            return new Result(201, "购买债券额度超出机构可售额度");
        }else  if(orderShare.compareTo(customerUseShare) > 0){
            return new Result(202, "购买债券额度超出个人可购额度");
        }else {
            customerBond.setTotalShare(customerBond.getTotalShare().add(orderShare));
            customerBond.setTradeShare(customerBond.getTradeShare().add(orderShare));
            entityLimit.setSaleShare(entityLimit.getSaleShare().add(orderShare));
            customerBondService.update(customerBond,new EntityWrapper<CustomerBond>().eq("ACCOUNT_ID",accountID).eq("BOND_CODE",bondCode));
            entityLimitService.update(entityLimit,new EntityWrapper<EntityLimit>().eq("ENTITY_ID",entityId).eq("BOND_CODE",bondCode));
            return new Result(200, "购买债券成功");

        }
    }


    @CrossOrigin
    @RequestMapping(value = "api/queryAccountTrade", method = RequestMethod.POST)
    @ResponseBody
    public Result accountTradeQuery(@RequestBody HashMap<String, String> queryData) {
        String accountId = queryData.get("accountId");
        List<TradeInfo> tradeInfos = tradeInfoService.selectList(new EntityWrapper<TradeInfo>().eq("ACCOUNT_ID", accountId).eq("SERVICE_TYPE", "accountType"));
        return new Result(200,"查询交易信息成功",tradeInfos);
    }

    @CrossOrigin
    @RequestMapping(value = "api/queryBondTrade", method = RequestMethod.POST)
    @ResponseBody
    public Result tradeTradeQuery(@RequestBody HashMap<String, String> queryData) {
        String accountId = queryData.get("accountId");
        List<TradeInfo> tradeInfos = tradeInfoService.selectList(new EntityWrapper<TradeInfo>().eq("ACCOUNT_ID", accountId).eq("SERVICE_TYPE", "tradeType"));
        return new Result(200,"查询交易信息成功",tradeInfos);
    }

    @CrossOrigin
    @RequestMapping(value = "api/bondSell", method = RequestMethod.POST)
    @ResponseBody
    public Result bondSell(@RequestBody HashMap<String, String> queryData) {
        String accountId = queryData.get("accountId");
        String bondCode =queryData.get("bondCode");
        BigDecimal tradeShare = new BigDecimal(queryData.get("tradeShare"));
        BigDecimal sellShare = new BigDecimal(queryData.get("sellShare"));
        BigDecimal totalShare = new BigDecimal(queryData.get("totalShare"));
        BigDecimal remainShare = tradeShare.subtract(sellShare);
        BigDecimal remainTotal = totalShare.subtract(sellShare);
        CustomerBond customerBond = new CustomerBond();
        customerBond.setTotalShare(remainTotal);
        customerBond.setAccountId(accountId);
        customerBond.setBondCode(bondCode);
        customerBond.setTradeShare(remainShare);
        boolean flag = customerBondService.update(customerBond,new EntityWrapper<CustomerBond>().eq("ACCOUNT_ID",accountId).eq("BOND_CODE",bondCode));
        if (flag){
            return new Result(200,"债券卖出成功");
        }else {
            return new Result(-1,"卖出债券失败");
        }

    }


}

