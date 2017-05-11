/*
 *Project: liz-incubator
 *File: com.liz.x_memory.job.MyJob.java <2017年05月11日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.x_memory.job;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lizhou
 * @version 1.0
 * @Date 2017年05月11日 14时16分
 */

//这里注解的意思是: 任务是否可以并发 加上注解表示不可以并发
@DisallowConcurrentExecution
public class MyJob implements Job{

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //在任务里 可以通过getJobDataMap()传自己需要用的一些数据
        JobDataMap jdm = context.getJobDetail().getJobDataMap();
        //TODO
        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,sss").format(new Date());
        System.out.println("now:"+now+ "    data:" + jdm.get("data"));
    }

}
