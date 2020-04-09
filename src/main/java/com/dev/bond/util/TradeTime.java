package com.dev.bond.util;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dev.bond.entity.SysParameter;
import com.dev.bond.service.ISysParameterService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TradeTime {
    ISysParameterService sysParameterService = (ISysParameterService)SpringUtil.getBean(ISysParameterService.class);

    public Boolean tradeFlag() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String timeNow = simpleDateFormat.format(new Date());

            Date timeNow1 = simpleDateFormat.parse(timeNow);

        SysParameter tradeTime = sysParameterService.selectOne(new EntityWrapper<SysParameter>().eq("TRADE_TYPE", "tradeTime"));
        String tradeStartTime = tradeTime.getTradeStartTime();
        Date startTime = simpleDateFormat.parse(tradeStartTime);
        String tradeEndTime = tradeTime.getTradeEndTime();
        Date endTime = simpleDateFormat.parse(tradeEndTime);
        if(timeNow1.after(startTime)&&timeNow1.before(endTime)){
            return true;
        }else {
            return false;
        }

    }
}
