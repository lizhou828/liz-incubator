/*
 *Project: liz-incubator
 *File: com.liz.ocjpJava6.thread.mutilThread.Threads3.java <2018年04月08日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.ocjpJava6.thread.mutilThread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 3个并发的线程依次打印ABC
 * @author lizhou
 * @version 1.0
 * @Date 2018年04月08日 14时46分
 */
public class ThreadsABC {
    public static void main(String argv[]) {

        AtomicInteger synObj = new AtomicInteger(0);

        TestPrint a = new TestPrint(synObj, "A", 0);
        TestPrint b = new TestPrint(synObj, "B", 1);
        TestPrint c = new TestPrint(synObj, "C", 2);

        a.start();
        b.start();
        c.start();
    }
}


class TestPrint extends Thread {

    private AtomicInteger synObj;
    private String name;
    private int flag;

    private int count = 0;

    public TestPrint(AtomicInteger synObj, String name, int flag) {
        this.synObj = synObj;
        this.name = name;
        this.flag = flag;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (synObj) {
                if (synObj.get() % 3 == flag) {
                    synObj.set(synObj.get() + 1);
                    System.out.println(name);
                    count++;
                    synObj.notifyAll();
                    if (count == 10) {
                        break;
                    }
                } else {
                    try {
                        synObj.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}