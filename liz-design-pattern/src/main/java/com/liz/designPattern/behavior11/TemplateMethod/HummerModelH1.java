package com.liz.designPattern.behavior11.TemplateMethod;

/**
 * Created by Frank on 2016/12/8.
 */
public class HummerModelH1 extends HummerModel {

    private boolean alarmFlag = true;

    @Override
    protected void start() {
        System.out.println("悍马H1启动.........");
    }

    @Override
    protected void stop() {
        System.out.println("悍马H1停车.........");
    }

    @Override
    protected void alarm() {
        System.out.println("悍马H1鸣笛.........");
    }

    @Override
    protected void engineBoom() {
        System.out.println("悍马H1引擎轰隆声.........");
    }

    //重写了父类的方法
    protected boolean isAlarm(){
        return this.alarmFlag;
    }

    public void setAlarm(boolean alarmFlag) {
        this.alarmFlag = alarmFlag;
    }
}
