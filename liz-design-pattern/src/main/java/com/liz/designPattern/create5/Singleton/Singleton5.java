package com.liz.designPattern.create5.Singleton;

/**
 * Created by lizhou on 2018年04月03日 21时44分
 * 双重校验锁
 * 由懒汉式(线程安全)演化而来
 */
public class Singleton5 {
    private Singleton5(){}

    //volatile的一个语义是禁止指令重排序优化
    //也就保证了instance变量被赋值的时候对象已经是初始化过的
    private static volatile Singleton5 instance = null;

    public static Singleton5 getInstance(){
        if(null == instance ){
            //由于单例对象只需要创建一次，
            // 如果后面再次调用getInstance()只需要直接返回单例对象。
            // 因此，大部分情况下，
            // 调用getInstance()都不会执行到同步代码块，从而提高了程序性能
            synchronized (Singleton5.class){
                if(null == instance ){
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }

}
