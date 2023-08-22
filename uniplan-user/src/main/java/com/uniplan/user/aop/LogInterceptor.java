package com.uniplan.user.aop;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 请求响应日志 AOP
 **/
@Aspect
@Component
@Slf4j
public class LogInterceptor {

    /**
     * 执行拦截
     */
    // 创建线程池，将日志输出任务提交给线程池处理
    ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Around("execution(* com.uniplan.user.controller.*.*(..))")
    public Object doInterceptor(ProceedingJoinPoint point) throws Throwable {
        // 获取请求路径
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) requestAttributes).getRequest();

        // 生成请求唯一 id
        String requestId = UUID.randomUUID().toString();
        String url = httpServletRequest.getRequestURI();

        // 获取请求参数
        Object[] args = point.getArgs();
        String reqParam = "[" + StringUtils.join(args, ", ") + "]";

        // 输出请求日志
        log.info("request start，id: {}, path: {}, ip: {}, params: {}", requestId, url,
                httpServletRequest.getRemoteHost(), reqParam);

        // 计时
        long startTime = System.nanoTime();

        // 执行原方法
        Object result = point.proceed();

        // 计算执行时间
        long endTime = System.nanoTime();
        long totalTimeNanos = endTime - startTime;
        long totalTimeMillis = TimeUnit.NANOSECONDS.toMillis(totalTimeNanos);

        // 异步输出响应日志
        executorService.execute(() -> {
            // 输出响应日志
            log.info("request end, id: {}, cost: {}ms", requestId, totalTimeMillis);
        });

        return result;
    }
}

