package com.liz.incubator.config;

import com.liz.incubator.filter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lizhou on 2016/5/24
 */

@Configuration
public class WebConfig {

    /**
     * spring boot 接入 自定义的过滤器
     * @param myFilter
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean(MyFilter myFilter){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(myFilter);
        filterRegistrationBean.setEnabled(true);
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }
}
