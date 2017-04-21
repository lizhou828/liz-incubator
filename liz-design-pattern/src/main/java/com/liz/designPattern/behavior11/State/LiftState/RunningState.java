/*
 *Project: liz-incubator
 *File: com.liz.designPattern.behavior11.State.LiftState.RuningState.java <2017年04月21日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.designPattern.behavior11.State.LiftState;

/**
 * @author lizhou
 * @version 1.0
 * @Date 2017年04月21日 11时57分
 */
public class RunningState extends LiftState{
    @Override
    public void open() {
        //do nothing 电梯运行的时，不能打开
    }

    @Override
    public void close() {
        //do nothing 电梯运行的时，肯定是关闭的
    }

    @Override
    public void run() {
        System.out.println("电梯正在运行...");
    }


    @Override
    public void stop() {
        super.context.setLiftState(Context.stoppingState);
        super.context.getLiftState().stop();
    }
}
