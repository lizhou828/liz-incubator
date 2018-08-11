/*
 *Project: liz-incubator
 *File: com.liz.ocjpJava6.thread.mutilThread.ThreadPrintABCD.java <2018年04月12日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.ocjpJava6.thread.mutilThread;

/**
 * 使用join方法实现按顺序打印
 * 此种方式只能实现打印一轮，
 * 查看join()方法的源码得知： Waits for this thread to die.
 * @author lizhou
 * @version 1.0
 * @Date 2018年04月12日 15时19分
 */
public class ThreadPrintABCD {

    public static void main(String[] args) {


        // 线程A
        final Thread a = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("A");

            }
        });

        // 线程B
        final Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 执行b线程之前，加入a线程,让a线程执行
                    a.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("B");

            }
        });

        // 线程C
        final Thread c = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    // 执行c线程之前，加入b线程,让b线程执行
                    b.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("C");

            }
        });

        // 线程D
        Thread d = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    // 执行d线程之前，加入c线程,让c线程执行
                    c.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("D");
            }
        });

        // 启动四个线程
        a.start();
        b.start();
        c.start();
        d.start();

    }
}
