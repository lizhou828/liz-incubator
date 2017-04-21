/*
 *Project: liz-incubator
 *File: com.liz.designPattern.behavior11.State.LiftState.ClientMain.java <2017年04月21日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.designPattern.behavior11.State.LiftState;

/**
 * @author lizhou
 * @version 1.0
 * @Date 2017年04月21日 13时52分
 */
public class ClientMain {
    public static void main(String[] args) {
        Context context = new Context();
        context.setLiftState(new ClosingState());//设置一个初始状态

        context.open();
        context.close();
        context.run();
        context.stop();

//        看到没？我们已经隐藏了状态的变化过程，它的切换引起了行为的变化。对外来说，我
//        们只看到行为的发生改变，而不用知道是状态变化引起的。

        //场景类太简单了，只要定义一个电梯的初始状态，然后调用相关的方法，就完成
//        了，完全不用考虑状态的变更
    }
}
