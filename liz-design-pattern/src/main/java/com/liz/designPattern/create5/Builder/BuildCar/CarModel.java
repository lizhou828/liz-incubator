/*
 *Project: liz-incubator
 *File: com.liz.designPattern.create5.Builder.BuildCar.CarModel.java <2017年04月12日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.designPattern.create5.Builder.BuildCar;

import java.util.ArrayList;

/**
 * 车辆模型的抽象类（使用了模板方法模式）
 *
 *
 CarModel的设计原理是这样的，setSequence方法是允许客户自己设置一个顺序，是要先
 启动响一下喇叭再跑起来，还是要先响一下喇叭再启动。对于一个具体的模型永远都固定
 的，但是对N多个模型就是动态的了。在子类中实现父类的基本方法，run()方法读取
 sequence，然后遍历sequence中的字符串，哪个字符串在先，就先执行哪个方法

 * @author lizhou
 * @version 1.0
 * @Date 2017年04月12日 14时17分
 */

public abstract class CarModel{
    public static final String START = "start";
    public static final String STOP = "stop";
    public static final String ALARM = "alarm";
    public static final String ENGINE_BOOM = "engineBoom";

    //这个参数是各个基本方法执行的顺序
    private ArrayList<String> sequenceList = new ArrayList<String>();

    protected  abstract void start();

    protected  abstract void stop();

    protected  abstract void alarm();

    protected  abstract void engineBoom();

    final public void run(){

        for(String sequence : this.sequenceList){
            if(START.equals(sequence)){
                this.start();
            }else if (STOP.equals(sequence)){
                this.stop();
            }else if (ALARM.equals(sequence)){
                this.alarm();
            }else if (ENGINE_BOOM.equals(sequence)){
                this.engineBoom();
            }
        }

    }

    //把传递过来的值传递到本类内
    final public void setSequenceList(ArrayList<String> sequenceList) {
        this.sequenceList = sequenceList;
    }
}
