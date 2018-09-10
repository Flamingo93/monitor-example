package com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate template;

    public void writeRedis(String jobId, String progress) {
        System.out.println("before set");
        template.opsForValue().set(jobId, progress);
        System.out.println("after set");
    }
}
