package com.web;

import com.domain.MonitorProgressReq;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import java.util.Timer;

@Controller
public class ProgressMonitorController {

    private final RedisService redisService;
    private Timer timer = new Timer("Timer");
    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    public ProgressMonitorController(RedisService redisService) {
        this.redisService = redisService;
    }

    @RequestMapping("/")
    public @ResponseBody
    void monitoring(MonitorProgressReq monitorProgressReq) {
        timer.scheduleAtFixedRate(new MonitorTimerTask(monitorProgressReq, redisService, restTemplate), 0, 2000);
    }
}
