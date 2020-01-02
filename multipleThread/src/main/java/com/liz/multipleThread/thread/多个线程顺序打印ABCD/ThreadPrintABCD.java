/*
 *Project: liz-incubator
 *File: com.liz.multipleThread.thread.多个线程顺序打印ABCD.ThreadPrintABCD.java <2018年04月12日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.multipleThread.thread.多个线程顺序打印ABCD;

/**
 * 使用join方法实现按顺序打印
 * 此种方式只能实现打印一轮，
 * 查看join()方法的源码得知： Waits for this thread to die.
 * @author lizhou
 * @version 1.0
 * @Date 2018年04月12日 15时19分
 */
public class ThreadPrintABCD {

    public static void main(String[] args) throws InterruptedException {


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
        d.start();
        a.start();
        b.start();
//        Thread.sleep(1000L);
        c.start();

//TODO 特别注意！！！深入理解！！！！！
//TODO 加上83行的 Thread.sleep(1000L); 之后，会有两种打印结果：DABC  和ADBC，结果分析如下：
//        c线程在1秒后才启动，所以在最后打印C
//        b线程中 有了a.join() ，源码中解释为：Waits for this thread to die. ,就是说执行b线程之前，必须执行完（中途加入的）a线程，  所以B永远是在A之后打印出来
//        d线程和 a线程、b线程 由于没有任何关联，d线程几乎同时与a线程去竞争、获取CPU资源，谁先抢到CPU的时间片，就先执行谁。所以打印A 和D的顺序不确定





    }
}
