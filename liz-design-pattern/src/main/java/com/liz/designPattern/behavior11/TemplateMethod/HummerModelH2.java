package com.liz.designPattern.behavior11.TemplateMethod;

/**
 * Created by Frank on 2016/12/8.
 */
public class HummerModelH2 extends HummerModel {
    @Override
    protected void start() {
        System.out.println("悍马H2启动.........");
    }

    @Override
    protected void stop() {
        System.out.println("悍马H2停止.........");
    }

    @Override
    protected void alarm() {
        System.out.println("悍马H2鸣笛.........");
    }

    @Override
    protected void engineBoom() {
        System.out.println("悍马H2引擎轰隆声.........");
    }

    protected boolean isAlarm(){
        return false;
    }
}
