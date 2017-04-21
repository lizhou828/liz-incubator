/*
 *Project: liz-incubator
 *File: com.liz.designPattern.behavior11.State.LiftState.StopingState.java <2017年04月21日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.designPattern.behavior11.State.LiftState;

/**
 * @author lizhou
 * @version 1.0
 * @Date 2017年04月21日 11时58分
 */
public class StoppingState extends LiftState {
    //停止状态必须可以开门，这是基本功能
    @Override
    public void open() {
        super.context.setLiftState(Context.openingState);
        super.context.getLiftState().open();
    }

    @Override
    public void close() {
        //do nothing
    }

    @Override
    public void run() {
        super.context.setLiftState(Context.runningState);
        super.context.getLiftState().run();
    }

    @Override
    public void stop() {
        System.out.println("电梯停止了..");
    }
}
