package com.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
//import javax.persistence.En;

@Component
public class MonitorProgressReq {
    private String TaskType;
    private String web_url;
    private String yarn_id;
    private Integer jobId;

    public String getTaskType() {
        return TaskType;
    }

    public String getWeb_url() {
        return web_url;
    }

    public String getYarn_id() {
        return yarn_id;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setTaskType(String taskType) {
        TaskType = taskType;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public void setYarn_id(String yarn_id) {
        this.yarn_id = yarn_id;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }
}
