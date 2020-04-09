package com.dev.bond;

import groovy.util.logging.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//SpringBootTest 是springboot 用于测试的注解，可指定启动类或者测试环境等，这里直接默认。
@SpringBootTest
@Slf4j
public class test {


    @Test
    public void testSerFeeXml(){
        String tradeType = "BOND_BUY";
//        List<HashMap<String,Object>> serviceFeeList = serviceFeeMapper.selectServiceFeeByTradeType();

//        System.out.println(serviceFeeList);
//        System.out.println(serviceFeeList.toString());
    }
}
