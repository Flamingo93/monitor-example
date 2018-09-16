package com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    private StringRedisTemplate template;

    @Autowired
    public RedisService(StringRedisTemplate template) {
        this.template = template;
    }

    public void writeRedis(String jobId, String progress) {
        template.opsForValue().set(jobId,progress);
    }
}
