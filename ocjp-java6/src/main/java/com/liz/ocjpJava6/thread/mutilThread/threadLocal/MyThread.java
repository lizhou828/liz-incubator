/*
 *Project: liz-incubator
 *File: com.liz.ocjpJava6.thread.mutilThread.threadLocal.TestThread.java <2017年05月26日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.ocjpJava6.thread.mutilThread.threadLocal;

/**
 * @author lizhou
 * @version 1.0
 * @Date 2017年05月26日 10时27分
 */
public class MyThread extends Thread{
    private MyThreadLocal myThreadLocal = new MyThreadLocal();

    public MyThread(MyThreadLocal myThreadLocal) {
        this.myThreadLocal = myThreadLocal;
    }

    @Override
    public void run() {
        for(int i = 0 ;i< 3 ;i++){
            System.out.println(Thread.currentThread().getName() + "," + myThreadLocal.getBean() + "," + myThreadLocal.getBean().showInfo());
        }
    }
}
