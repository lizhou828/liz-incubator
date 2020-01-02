/*
 *Project: liz-incubator
 *File: com.liz.ocjpJava6.thread.mutilThread.Threads3.java <2018年04月08日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.multipleThread.thread.多个线程顺序打印ABCD;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 3个并发的线程依次打印ABC
 * @author lizhou
 * @version 1.0
 * @Date 2018年04月08日 14时46分
 */
public class ThreadsABC {
    public static void main(String argv[]) {

        AtomicInteger atomicInteger = new AtomicInteger(0);

        TestPrint a = new TestPrint(atomicInteger, "A", 0);
        TestPrint b = new TestPrint(atomicInteger, "B", 1);
        TestPrint c = new TestPrint(atomicInteger, "C", 2);
        TestPrint d = new TestPrint(atomicInteger, "D", 3);

        a.start();
        b.start();
        c.start();
        d.start();
    }
}


class TestPrint extends Thread {

    private AtomicInteger atomicInteger;
    private String name;
    private int flag;

    private int count = 0;

    public TestPrint(AtomicInteger atomicInteger, String name, int flag) {
        this.atomicInteger = atomicInteger;
        this.name = name;
        this.flag = flag;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (atomicInteger) {
                if (atomicInteger.get() % 4 == flag) {
                    atomicInteger.set(atomicInteger.get() + 1);
                    System.out.println(name);
                    count++;
                    atomicInteger.notifyAll();
                    if (count == 10) {
                        break;
                    }
                } else {
                    try {
                        atomicInteger.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}