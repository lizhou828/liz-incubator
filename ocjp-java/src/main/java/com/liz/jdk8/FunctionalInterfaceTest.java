package com.liz.jdk8;

/**
 * 函数式接口 @FunctionalInterface
 * JDK8引入，只允许有一个未实现方法，否则报错：不是函数接口，找到多个非覆盖抽象方法
 * 使用命令：
 *      javac FunctionalInterfaceTest.java
 *      javap -v FunctionalInterfaceTest.class
 * 使用JDK自带的反编译命令 javap 可以查看到，该未实现的方法，已变成抽象方法
 * @author: Created by lizhou
 * @create: 2020-07-23 15:06
 **/
@FunctionalInterface
public interface FunctionalInterfaceTest {

    void add();

//    void substract();

    default int test(){
        int a = 1;
        a += 1;
        String aa = a + "";
        String.valueOf(1);
        new String("1".getBytes());
        return a;
    }
}
