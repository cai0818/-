package com.uniplan.user.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @Author cai
 * @Description
 * @Date 2023/8/2123:38
 * @Description $
 * @Email :2904623189@qq.com
 * @return $
 **/
@Configuration
@EnableCaching // 开启缓存功能
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(caffeineCacheBuilder());
        return cacheManager;
    }

    // 配置Caffeine
    private Caffeine<Object, Object> caffeineCacheBuilder() {
        return Caffeine.newBuilder()
                .initialCapacity(100) // 初始容量
                .maximumSize(1000) // 最大容量
                .expireAfterAccess(30, TimeUnit.MINUTES) // 访问后的过期时间
                .recordStats(); // 启用统计信息
    }
}