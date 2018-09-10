package com.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

public class CachingConfigurerSupport {
//    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
//        StringRedisTemplate template = new StringRedisTemplate(factory);
    @Bean(name = "testredis")
    public RedisTemplate<String, String> redisTemplate() {
        RedisTemplate template = new RedisTemplate();

//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

        template.afterPropertiesSet();
        return template;
    }
}
