package com.uniplan.user.config;

import com.uniplan.user.jwt.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author cai
 * @Description
 * @Date 2023/8/2211:29
 * @Description $
 * @Email :2904623189@qq.com
 * @return $
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private JwtInterceptor jwtInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册自定义的JwtInterceptor拦截器，将其添加到拦截器链中
        InterceptorRegistration registration = registry.addInterceptor(jwtInterceptor);
        registration.addPathPatterns("/**") // 设置需要拦截的请求路径
                .excludePathPatterns("/user/login/**") // 设置不需要拦截的请求路径
                .excludePathPatterns("/user/register/**");

    }
}