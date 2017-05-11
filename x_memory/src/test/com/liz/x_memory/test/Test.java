/*
 *Project: liz-incubator
 *File: com.liz.x_memory.test.Test.java <2017年05月11日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.x_memory.test;

import com.liz.x_memory.domain.ScheduleJob;
import com.liz.x_memory.job.MyJob;
import com.liz.x_memory.service.CronJobService;
import com.liz.x_memory.service.SimpleJobService;
import org.quartz.SchedulerException;

import java.util.Date;

/**
 *
 * 测试时遇到的问题：
 1.在测试过程中循环建了1000个任务，然后同时执行，发现有漏掉任务，这个可以通过调整线程数量（org.quartz.threadPool.threadCount）和超时时间（org.quartz.jobStore.misfireThreshold）来解决
 2.SimpleTrigger和CronTrigger之间不能互转，开始建了一个任务使用的是CronTrigger，任务信息保存到数据库中，然后下次启动服务的时候想修改成SimpleTrigger，会报错，这种情况只能先删除该任务，然后重建。
 3.不能创建已过期的任务，比如现在是2017-1-1 14:30:00,不能创建这个时间之前的任务
 4.时间间隔这种CronTrigger不能很好的处理，使用SimpleTrigger，比如从现在开始隔90分钟执行一次，CronTrigger没法实现
 *
 * @author lizhou
 * @version 1.0
 * @Date 2017年05月11日 14时25分
 */
public class Test {

    public static void simpleJobTest(){
        ScheduleJob job = new ScheduleJob();
        job.setJobId("10001" );
        job.setJobName("test1");
        job.setJobGroup("test-group");
        job.setStartTime(new Date());
        job.setData("这里是传入job的数据");
        job.setTimeInterval(5);//每隔5秒执行一次
        job.setRepeatCount(1);//-1表示执行次数：无限重复
        try {
            SimpleJobService.addOrUpdateJob(job, MyJob.class);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public static void cronJobTest(){
        ScheduleJob job = new ScheduleJob();
        job.setJobId("10001");
        job.setJobName("test1");
        job.setJobGroup("test-group");
        job.setStartTime(new Date());
        job.setData("这里是传入job的数据");
        job.setCronExpression("30 * * * * ? ");//每分钟的第30秒执行(更多的cron表达式请见本项目下的cronExpression.md文件 )
        try {
            CronJobService.addOrUpdateJob(job, MyJob.class);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        simpleJobTest();
        cronJobTest();
    }
}
