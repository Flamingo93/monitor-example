package com.service;

import com.domain.MonitorProgressReq;
import com.domain.SparkJobInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.text.NumberFormat;
import  java.util.TimerTask;

public class MonitorTimerTask extends TimerTask {

    private MonitorProgressReq monitorProgressReq;
    private RedisService redisService;
    private RestTemplate restTemplate;

    public MonitorTimerTask(MonitorProgressReq monitorProgressReq, RedisService redisService, RestTemplate restTemplate) {
        this.monitorProgressReq = monitorProgressReq;
        this.redisService = redisService;
        this.restTemplate = restTemplate;
    }

    @Override
    public void run() {
        String url = monitorProgressReq.getWebUrl() + "/api/v1/applications/" + monitorProgressReq.getYarnId() + "/jobs/";
        ResponseEntity<SparkJobInfo[]> responseEntity = restTemplate.getForEntity(url, SparkJobInfo[].class);

        SparkJobInfo sparkJobInfos = responseEntity.getBody()[0];
        Float progress = sparkJobInfos.getNumCompletedTasks()/sparkJobInfos.getNumTasks();
        NumberFormat format = NumberFormat.getPercentInstance();
        format.setMaximumFractionDigits(0);
        redisService.writeRedis(monitorProgressReq.getYarnId(), format.format(progress));
        System.out.println("redis write");//For test

        if (sparkJobInfos.getStatus().equals("SUCCEEDED"))
            cancel();
    }
}
