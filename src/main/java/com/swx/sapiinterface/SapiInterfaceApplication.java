package com.swx.sapiinterface;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.swx.sapiinterface.mapper")
public class SapiInterfaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SapiInterfaceApplication.class, args);
    }

}


