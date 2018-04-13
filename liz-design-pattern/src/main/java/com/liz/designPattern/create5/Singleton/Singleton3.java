package com.liz.designPattern.create5.Singleton;

/**
 * Created by lizhou on 2018年04月03日 21时25分
 *
 * 静态内部类
 *
 */
public class Singleton3 {

    private Singleton3(){}

    //这种方式是Singleton类被装载了，instance不一定被初始化。
    // 因为SingletonHolder类没有被主动使用，
    // 只有显示通过调用getInstance方法时，
    // 才会显示装载SingletonHolder类，从而实例化instance
    public static final Singleton3 getInstance(){
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder{
        private static final Singleton3 INSTANCE = new Singleton3();
    }

}
