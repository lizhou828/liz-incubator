package com.liz.designPattern.create5.Singleton;

/**
 * Created by lizhou on 2018年04月03日 21时21分
 */
public class Singleton22 {

    private Singleton22(){}

    //在类初始化即实例化instance。
    private static Singleton22 instance ;
    static{
        instance = new Singleton22();
    }

    public static Singleton22 getInstance(){
        return instance;
    }

}
