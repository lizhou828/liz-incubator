/*
 *Project: liz-incubator
 *File: com.liz.designPattern.behavior11.State.LiftState.LiftState.java <2017年04月21日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.designPattern.behavior11.State.LiftState;

/**
 * 抽象的电梯状态
 * @author lizhou
 * @version 1.0
 * @Date 2017年04月21日 11时51分
 */
public abstract class LiftState {

    //定义一个环境角色，也就是封装了状态的变化引起行为变化
    protected  Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    /* 电梯开门 */
    public abstract void open();

    /* 电梯关门 */
    public abstract void close();

    /* 电梯运行 */
    public abstract void run();

    /* 电梯停止 */
    public abstract void stop();
}
