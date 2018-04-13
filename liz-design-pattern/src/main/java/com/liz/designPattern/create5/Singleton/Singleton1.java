package com.liz.designPattern.create5.Singleton;

/**
 * Created by lizhou on 2018年04月03日 21时05分
 * 懒汉式（线程安全、线程不安全）
 */
public class Singleton1 {

    private Singleton1(){}

    private static Singleton1 instance;

    /* 线程不安全 */
    private static Singleton1 getInstance(){
        if(null == instance){
            instance = new Singleton1();
        }
        return instance;
    }

    /* 线程安全 */
    private static  synchronized Singleton1 getInstanceSafe(){
        if(null == instance){
            instance = new Singleton1();
        }
        return instance;
    }
}
