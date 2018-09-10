package com.web;

import com.domain.MonitorProgressReq;
import com.service.RedisService;
import com.service.TimerTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Timer;


@Controller
public class ProgressMonitorController {

    private final RedisService redisService;

    @Autowired
    public ProgressMonitorController(RedisService redisService) {
        this.redisService = redisService;
    }

    @RequestMapping("/")
    public @ResponseBody void monitoring(MonitorProgressReq monitorProgressReq) {

        try {
            if (monitorProgressReq.getTaskType().equals("SPARK")) {
                Timer timer;
                timer = new Timer();
                timer.schedule(new TimerTask(monitorProgressReq, redisService), 0, 2000);
//                new TimerTask(monitorProgressReq, redisService).run();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
