package com.liz.designPattern.create5.Singleton;

/**
 * Created by lizhou on 2018年04月03日 21时15分
 * 饿汉式
 */
public class Singleton2 {

    private Singleton2(){};
    /* 基于classloder机制避免了多线程的同步问题
    * 不过，instance在类装载时就实例化，虽然导致类装载的原因有很多种，
    * 在单例模式中大多数都是调用getInstance方法，
    * 但是也不能确定有其他的方式（或者其他的静态方法）导致类装载，
    * 这时候初始化instance显然没有达到lazy loading的效果。*/
    private static Singleton2 instance = new Singleton2();

    public static Singleton2 getInstance(){
        return instance;
    }


}
