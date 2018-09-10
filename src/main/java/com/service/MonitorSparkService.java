package com.service;

import com.domain.MonitorProgressReq;
import com.domain.SparkJobInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.NumberFormat;


@Service
public class MonitorSparkService {

    private final RedisService redisService;
    private MonitorProgressReq monitorProgressReq;

    public MonitorSparkService(RedisService redisService, MonitorProgressReq monitorProgressReq) {
        this.redisService = redisService;
        this.monitorProgressReq = monitorProgressReq;
    }

    public void monitor() {
        String url = monitorProgressReq.getWeb_url() + "/api/v1/applications/" + monitorProgressReq.getYarn_id() + "/jobs/";

        RestTemplate restTemplate = new RestTemplate();
        NumberFormat format = NumberFormat.getPercentInstance();
        format.setMaximumFractionDigits(0);

        ResponseEntity<SparkJobInfo[]> responseEntity = restTemplate.getForEntity(url, SparkJobInfo[].class);
        SparkJobInfo[] sparkJobInfos = responseEntity.getBody();

        Float progress = sparkJobInfos[0].getNumCompletedTasks()/sparkJobInfos[0].getNumTasks();
        System.out.println(progress.toString());
        redisService.writeRedis("test-key", "test-value");

    }
}
