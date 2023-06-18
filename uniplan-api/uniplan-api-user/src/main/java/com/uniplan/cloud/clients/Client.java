package com.uniplan.cloud.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("userservice")
public interface Client {
    @GetMapping("/user/hello")
    String hello();
}