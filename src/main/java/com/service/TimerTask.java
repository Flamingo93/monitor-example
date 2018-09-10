package com.service;

import com.domain.MonitorProgressReq;

import java.util.Date;

public class TimerTask extends java.util.TimerTask {

    private MonitorProgressReq monitorProgressReq;
    private RedisService redisService;

    public TimerTask(MonitorProgressReq monitorProgressReq, RedisService redisService) {
        this.monitorProgressReq = monitorProgressReq;
        this.redisService = redisService;
    }

    @Override
    public void run() {
//        Date date = new Date(this.scheduledExecutionTime());
        new MonitorSparkService(redisService, monitorProgressReq).monitor();
    }
}
