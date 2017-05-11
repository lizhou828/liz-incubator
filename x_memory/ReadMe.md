# ReadMe

    This module is used to memory something that's important to you   based on The  H.Ebbinghaus Forgetting Curve.

    short memory: 5min 30min 12hours
    long  memory: 1day 2day 4day 7day  15day 30day

# Framework info

    Spring 4.3.5.RELEASE
    quartz 2.2.3
    
    quartz定时任务必须搞清楚几个概念：
    JobDetail——处理类
    Trigger——触发器，指定触发时间，必须要有JobDetail属性，即触发对象
    Scheduler——调度器，组织处理类和触发器，配置方式一般只需指定触发器（因为触发器已经指定了对应的处理类），代码方式则需同时指定触发对象和触发器。


# Domain

    Something like knowledge of computer,program,software , other domain ,etc. Especially you are not familiar with it.


# The architecture of this module as below:

    core:   push message on time based on The  H.Ebbinghaus Forgetting Curve.

    PC  :   editor online
            management system
            preparation works :
                analyze requirement
                analyze technology

    APP :   api
            app
            preparation works :
                analyze requirement
                analyze technology

# 业务模块

    1、记单词
        调用百度的接口，或者抓百度的网页

    2、知识、技术

