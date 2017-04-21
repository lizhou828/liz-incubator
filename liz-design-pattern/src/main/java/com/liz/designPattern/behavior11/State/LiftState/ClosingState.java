/*
 *Project: liz-incubator
 *File: com.liz.designPattern.behavior11.State.LiftState.ClosingState.java <2017年04月21日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.designPattern.behavior11.State.LiftState;

/**
 * @author lizhou
 * @version 1.0
 * @Date 2017年04月21日 11时57分
 */
public class ClosingState extends LiftState {

    //电梯门关了，可以再打开
    @Override
    public void open() {
        super.context.setLiftState(Context.openingState);
        super.context.getLiftState().open();
    }

    @Override
    public void close() {
        System.out.println("电梯门关闭");
    }

    //电梯门关了之后 ，按下楼层，就可以运行
    @Override
    public void run() {
        super.context.setLiftState(Context.runningState);
        super.context.getLiftState().run();
    }

    //电梯门关了之后 ，没按楼层，就停止了
    @Override
    public void stop() {
        super.context.setLiftState(Context.stoppingState);
        super.context.getLiftState().stop();
    }
}
