/*
 *Project: liz-incubator
 *File: com.liz.designPattern.behavior11.State.LiftState.OpenningState.java <2017年04月21日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.designPattern.behavior11.State.LiftState;

/**
 * @author lizhou
 * @version 1.0
 * @Date 2017年04月21日 11时56分
 */
public class OpeningState extends LiftState {
    @Override
    public void open() {
        System.out.println("电梯门打开了...");
    }

    @Override
    public void close() {
        super.context.setLiftState(Context.closingState);
        super.context.getLiftState().close();
    }

    @Override
    public void run() {
        //do nothing
    }

    @Override
    public void stop() {
        //do nothing
    }
}
