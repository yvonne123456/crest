package com.hcc.crest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.hcc.crest.mapper")
@SpringBootApplication(scanBasePackages = {"com.hcc.crest"})
public class CRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CRestApplication.class, args);
    }
}
