/*
 *Project: liz-incubator
 *File: com.liz.x_memory.domain.ScheduleJob.java <2017年05月11日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.x_memory.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lizhou
 * @version 1.0
 * @Date 2017年05月11日 14时14分
 */
public class ScheduleJob implements Serializable{
    private static final long serialVersionUID = 3305520099523335732L;
    /* 公共参数 */
    private String jobId;
    private String jobName;
    private String jobGroup;
    private String jobStatus;
    private String desc;
    private Object data;

    /* SimpleJob */
    /* 开始执行时间 */
    private Date startTime;
    /* 重复间隔(单位;秒，如果该字段不填，默认只执行一次任务) */
    private int timeInterval;
    /* 重复次数 （-1表示执行次数：无限重复）*/
    private int repeatCount;



    /* ComplexJob */
    /* cron表达式 */
    private String cronExpression;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(int timeInterval) {
        this.timeInterval = timeInterval;
    }

    public int getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
    }

    @Override
    public String toString() {
        return "ScheduleJob{" +
                "jobId='" + jobId + '\'' +
                ", jobName='" + jobName + '\'' +
                ", jobGroup='" + jobGroup + '\'' +
                ", jobStatus='" + jobStatus + '\'' +
                ", desc='" + desc + '\'' +
                ", data=" + data +
                ", startTime=" + startTime +
                ", timeInterval=" + timeInterval +
                ", repeatCount=" + repeatCount +
                ", cronExpression='" + cronExpression + '\'' +
                '}';
    }
}
