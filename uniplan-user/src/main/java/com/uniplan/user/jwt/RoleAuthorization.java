package com.uniplan.user.jwt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author cai
 * @Description
 * @Date 2023/8/2210:31
 * @Description jwt注解$
 * @Email :2904623189@qq.com
 * @return $
 **/

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RoleAuthorization {
    String[] value() default {};
}