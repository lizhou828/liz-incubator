package com.liz.designPattern.construct7.Proxy.cglibDynamicProxy;

import com.liz.designPattern.construct7.Proxy.Math;

/**
 * Created by lizhou on 2017年03月26日 21时59分
 */
public class ClientMain {
    public static void main(String[] args) {
        Math math = (Math) new CglibDynamicProxy().getProxyObject(new Math());
        int a = 100 ,b = 5 ;
        math.add(a,b);
        math.sub(a,b);
        math.mut(a,b);
        math.div(a,b);
    }

}
