package com.liz.designPattern.construct7.Proxy.cglibDynamicProxy;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 动态代理，使用cglib实现
 * CGLIB(Code Generation Library)是一个开源项目,是一个强大的，高性能，高质量的Code生成类库，它可以在运行期扩展Java类与实现Java接口，通俗说cglib可以在运行时动态生成字节码。
 *
 * 先在项目中添加Cglib的依赖：
 <!-- https://mvnrepository.com/artifact/cglib/cglib -->
 <dependency>
    <groupId>cglib</groupId>
    <artifactId>cglib</artifactId>
    <version>3.2.4</version>
 </dependency>
 *
 *
 * 原理：cglib继承被代理的类，重写方法，织入通知，动态生成字节码并运行，因为是继承所以final类是没有办法动态代理的。
 *
 *
 * Created by Administrator on 2017/3/22 0022
 */
public class CglibDynamicProxy implements MethodInterceptor{

    /* 被代理的对象 */
    Object tartgetObject;

    public Object getProxyObject(Object object){
        this.tartgetObject = object;

        /* 增强器，动态代码生成器 */
        Enhancer enhancer = new Enhancer();

        /* 回调方法 */
        enhancer.setCallback(this);

        /* 设置生成类的父类 类型 */
        enhancer.setSuperclass(tartgetObject.getClass());

        /* 动态生成字节码，并返回代理对象 */
        return enhancer.create();

    }

    /**
     * 拦截方法
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        /* 被织入的横切内容，开始时间 before */
        long start = System.currentTimeMillis();

        /* 调用方法 */
        Object result = methodProxy.invoke(tartgetObject,objects);

        /* 被织入的横切内容，结束时间 */
        long span = System.currentTimeMillis() - start;
        System.out.println("总共耗时：" + span + "毫秒");
        return result;
    }
}
