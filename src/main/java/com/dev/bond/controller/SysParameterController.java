package com.dev.bond.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dev.bond.entity.SysParameter;
import com.dev.bond.result.Result;
import com.dev.bond.service.ISysParameterService;
import com.dev.bond.util.TradeTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wzj123
 * @since 2020-04-06
 */
@RestController
public class SysParameterController {
    @Autowired
    public ISysParameterService sysParameterService;
    @CrossOrigin
    @RequestMapping(value = "api/queryTradeTime", method = RequestMethod.POST)
    @ResponseBody
    public Result queryTradeTime(@RequestBody HashMap<String, String> queryData) {
        SysParameter tradeTime = sysParameterService.selectOne(new EntityWrapper<SysParameter>().eq("TRADE_TYPE", queryData.get("tradeType")));
        return new Result(200,"查询交易时间成功",tradeTime  );
    }


    @CrossOrigin
    @RequestMapping(value = "api/resetTradeTime", method = RequestMethod.POST)
    @ResponseBody
    public Result resetTradeTime(@RequestBody SysParameter sysParameter) throws ParseException {
        TradeTime tradeTime = new TradeTime();
        Boolean timeFlag = tradeTime.tradeFlag();
        if(timeFlag){
            boolean flag = sysParameterService.update(sysParameter,new EntityWrapper<SysParameter>().eq("TRADE_TYPE", sysParameter.getTradeType()));
            if(flag){
                return new Result(200,"重置交易时间成功");
            }else {
                return new Result(-1,"重置交易时间失败");
            }
        }else {
            return new Result(201,"不在交易时间内");
        }


    }

}

