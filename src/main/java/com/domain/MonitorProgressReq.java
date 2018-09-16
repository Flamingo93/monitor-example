package com.domain;

public class MonitorProgressReq {

    private String taskType;
    private String webUrl;
    private String yarnId;
    private Integer jobId;

    public String getTaskType() {
        return taskType;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public String getYarnId() {
        return yarnId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public void setYarnId(String yarnId) {
        this.yarnId = yarnId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }
}
