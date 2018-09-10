package com.domain;

import org.springframework.stereotype.Component;

@Component
public class SparkJobInfo {
    private int jobId;
    private String status;
    private float numTasks;
    private float numCompletedTasks;

    public int getjobId() {
        return jobId;
    }

    public String getStatus() {
        return status;
    }

    public float getNumTasks() {
        return numTasks;
    }

    public float getNumCompletedTasks() {
        return numCompletedTasks;
    }
}
