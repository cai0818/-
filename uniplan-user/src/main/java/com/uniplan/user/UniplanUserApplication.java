package com.uniplan.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@EnableFeignClients(basePackages = "com.uniplan.cloud.clients")
// 指定启动类包扫描范围
@MapperScan(basePackages = {"com.uniplan.user.mapper"})
@SpringBootApplication(scanBasePackages = "com.uniplan.user")
public class UniplanUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UniplanUserApplication.class, args);
    }

}
