package com.domain;

import org.springframework.stereotype.Component;

@Component
public class SparkAppInfo {
    private SparkJobInfo sparkJobInfo;

    public SparkJobInfo getSparkJobInfo() {
        return sparkJobInfo;
    }

    public void setSparkJobInfo(SparkJobInfo sparkJobInfo) {
        this.sparkJobInfo = sparkJobInfo;
    }
}
