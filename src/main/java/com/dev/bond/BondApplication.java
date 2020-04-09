package com.dev.bond;

import com.dev.bond.util.SpringUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SpringUtil.class)
@MapperScan("com.dev.bond.mapper")
public class BondApplication {

    public static void main(String[] args) {
        SpringApplication.run(BondApplication.class, args);
    }

}
