package com.liz.incubator.filter;

import org.apache.log4j.MDC;
import org.apache.log4j.NDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by lizhou on 2016/5/24
 */

@Component("myFilter")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter.init() is running...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter.doFilter() is running...");
//        servletRequest.setAttribute("username","Sky Walker");
        MDC.put("username","Sky Walker");
        // 获得客户的网络地址
        String address = servletRequest.getRemoteAddr();
        // 把网络地址放入NDC中. 那么在在layout pattern 中通过使用 %x，就可在每条日之中增加网络地址的信息.
        MDC.put("address",address);
        //继续处理其他的filter链.
        filterChain.doFilter(servletRequest, servletResponse);
        // 从MDC的堆栈中删除网络地址.
        MDC.clear();
    }

    @Override
    public void destroy() {
        System.out.println("MyFilter.destroy() is running...");
    }
}
