/*
 *Project: liz-incubator
 *File: com.liz.designPattern.behavior11.State.LiftState.Context.java <2017年04月21日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.designPattern.behavior11.State.LiftState;

/**
 * 电梯状态的 上下文类
 * @author lizhou
 * @version 1.0
 * @Date 2017年04月21日 11时53分
 */
public class Context {

    //定义出所有的电梯状态
    public  final static OpeningState openingState = new OpeningState();
    public  final static ClosingState closingState = new ClosingState();
    public  final static RunningState runningState = new RunningState();
    public  final static StoppingState stoppingState = new StoppingState();

    //当前电梯状态
    private LiftState liftState;

    public LiftState getLiftState() {
        return liftState;
    }

    public void setLiftState(LiftState liftState) {
        this.liftState = liftState;
        this.liftState.setContext(this);
    }

    public void open(){
        this.liftState.open();
    }
    public void close(){
        this.liftState.close();
    }
    public void run(){
        this.liftState.run();
    }
    public void stop(){
        this.liftState.stop();
    }

}
