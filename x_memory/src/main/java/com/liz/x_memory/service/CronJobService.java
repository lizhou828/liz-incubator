/*
 *Project: liz-incubator
 *File: com.liz.x_memory.service.JobService.java <2017年05月11日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.x_memory.service;

import java.util.List;

import com.liz.x_memory.domain.ScheduleJob;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lizhou
 * @version 1.0
 * @Date 2017年05月11日 14时16分
 */
public class CronJobService {
    static ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    static Scheduler scheduler = (Scheduler) context.getBean("scheduler");

    /**
     * 添加或修改任务
     * @param job
     * @param jobClass
     * @throws SchedulerException
     */
    public static void addOrUpdateJob(ScheduleJob job, Class<? extends Job> jobClass)
            throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(),job.getJobGroup());
        // 获取trigger
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

        // 不存在，创建一个
        if (null == trigger) {
            System.out.println("new");
            JobDetail jobDetail = JobBuilder.newJob(jobClass)
                    .withIdentity(job.getJobName(), job.getJobGroup()).build();

            jobDetail.getJobDataMap().put("data", job.getData());
            // 表达式调度构建器
          CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
//             按新的cronExpression表达式构建一个新的trigger
          trigger = TriggerBuilder.newTrigger()
                  .withIdentity(job.getJobName(), job.getJobGroup())
                  .withSchedule(scheduleBuilder).build();


        } else {
            System.out.println("reset");
//             Trigger已存在，那么更新相应的定时设置
//             表达式调度构建器
          CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
//             按新的cronExpression表达式重新构建trigger
          trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();

            // 按新的trigger重新设置job执行
            JobKey jobKey = JobKey.jobKey(job.getJobName(), job.getJobGroup());
            scheduler.getJobDetail(jobKey).getJobDataMap().put("data", job.getData());
            scheduler.rescheduleJob(triggerKey, trigger);


        }
    }

    /**
     * 暂停任务
     * @param job
     * @throws SchedulerException
     */
    public static void pauseJob(ScheduleJob job) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(job.getJobName(), job.getJobGroup());
        scheduler.pauseJob(jobKey);
    }

    /**
     * 恢复单个任务
     * @param job
     * @throws SchedulerException
     */
    public static void recoveryJob(ScheduleJob job) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(job.getJobName(), job.getJobGroup());
        scheduler.resumeJob(jobKey);
    }

    /**
     * 全部恢复
     * @throws SchedulerException
     */
    public static void resumeAll() throws SchedulerException{
        scheduler.resumeAll();
    }

    /**
     * 查询任务信息
     * @throws SchedulerException
     */
    public static void queryJob() throws SchedulerException {
        for (String groupName : scheduler.getJobGroupNames()) {
            for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {
                String jobName = jobKey.getName();
                String jobGroup = jobKey.getGroup();
                List<Trigger> triggers = (List<Trigger>) scheduler.getTriggersOfJob(jobKey);
                Trigger trigger = triggers.get(0);
                System.out.println("[jobName] : " + jobName
                                + " [groupName] : "+ jobGroup
                                + " [nextFireTime]: " + trigger.getNextFireTime()
                );
            }
        }
    }

    /**
     * 删除任务
     * @param job
     * @throws SchedulerException
     */
    public static void deleteJob(ScheduleJob job) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(job.getJobName(), job.getJobGroup());
        scheduler.deleteJob(jobKey);
    }

    /**
     * 同时删除任务和定时器
     * @param job
     * @throws SchedulerException
     */
    public static void deleteJobAndTrigger(ScheduleJob job) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(job.getJobName(), job.getJobGroup());
        TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(),job.getJobGroup());
        scheduler.pauseTrigger(triggerKey);
        scheduler.unscheduleJob(triggerKey);
        scheduler.deleteJob(jobKey);
    }
    /**
     * 立即执行
     * @param job
     * @throws SchedulerException
     */
    public static void triggerNow(ScheduleJob job) throws SchedulerException{
        JobKey jobKey = JobKey.jobKey(job.getJobName(), job.getJobGroup());
        scheduler.triggerJob(jobKey);
    }


    /**
     * 立即执行
     * @param job
     * @throws SchedulerException
     */
    public static void triggerNow(ScheduleJob job,JobDataMap data) throws SchedulerException{
        JobKey jobKey = JobKey.jobKey(job.getJobName(), job.getJobGroup());
        scheduler.triggerJob(jobKey,data);
    }
}
