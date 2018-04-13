package com.liz.designPattern.create5.Singleton;

/**
 * Created by lizhou on 2018年04月03日 21时34分
 * 枚举方式
 * 不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象
 */
public enum  Singleton4 {

    INSTANCE;

    public void whateverMethod(){

    }

}
