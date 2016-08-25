package com.liz.incubator.controller;

import com.liz.common.component.cache.MemcacheClient;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;

/**
 * Created by lizhou on 2015/12/4
 */
@Controller
public class BaseController implements ApplicationContextAware {

    @Autowired
    public MemcacheClient memcacheClient;

    private  ApplicationContext context;

    public ApplicationContext getContext() {
        return context;
    }


    public Object getBean(String beanId) {
        return context.getBean(beanId);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
