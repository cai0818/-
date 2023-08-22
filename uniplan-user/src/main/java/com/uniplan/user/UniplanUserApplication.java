package com.uniplan.user;

import org.aspectj.lang.annotation.Aspect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


//@EnableFeignClients(basePackages = "com.uniplan.cloud.clients")
// 指定启动类包扫描范围
@MapperScan(basePackages = {"com.uniplan.user.mapper"})
@EnableAspectJAutoProxy
@SpringBootApplication(scanBasePackages = "com.uniplan.user")
public class UniplanUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UniplanUserApplication.class, args);
    }

}
