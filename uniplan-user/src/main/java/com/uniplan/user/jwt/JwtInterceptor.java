package com.uniplan.user.jwt;

import com.uniplan.user.annotation.AuthCheck;
import com.uniplan.user.model.domain.UserGeneral;
import com.uniplan.user.service.UserGeneralService;
import com.uniplan.user.service.impl.UserGeneralServiceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author cai
 * @Description
 * @Date 2023/8/2210:32
 * @Description 校验jwt是否有效$
 * @Email :2904623189@qq.com
 * @return $
 **/

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.SignatureException;
import java.util.Arrays;
import java.util.List;

@Component
public class JwtInterceptor implements HandlerInterceptor {
    private static final String SECRET_KEY = "miyao";

    @Autowired
    private  UserGeneralService userGeneralService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        // 获取请求头中的Token
        String token = request.getHeader("Authorization");
        // 如果Token为空或不符合Bearer规范，则拦截请求
        if (token == null) {
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "Unauthorized");
            return false;
        }

        try {
            // 验证Token是否有效
            Jws<Claims> claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            Claims body = claims.getBody();
            String userid = body.getSubject();

            // 解析注解
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            RoleAuthorization roleAuthorization = handlerMethod.getMethodAnnotation(RoleAuthorization.class);
            //根据用户Id查找是否有角色权限
            if (roleAuthorization != null) {
                String[] roles = roleAuthorization.value();
                String role = userGeneralService.getUserById(userid).getRole();

                for (String s : roles) {
                    if (s.equals(role)) {
                        return true;
                    }
                }

                response.sendError(HttpStatus.FORBIDDEN.value(), "Forbidden"); // 鉴权失败返回状态码403 Forbidden
                return false;
            }

            return true;
        } catch (JwtException ex) {
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "Unauthorized");
            return false;
        }
    }
}