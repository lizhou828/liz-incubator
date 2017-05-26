/*
 *Project: liz-incubator
 *File: com.liz.ocjpJava6.thread.mutilThread.threadLocal.MyThreadLocalTest.java <2017年05月26日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.ocjpJava6.thread.mutilThread.threadLocal;

/**
 * @author lizhou
 * @version 1.0
 * @Date 2017年05月26日 10时32分
 */
public class ClientMain {
    public static void main(String[] args) {
        MyThreadLocal tlt = new MyThreadLocal();
        Thread t1 = new MyThread(tlt);
        Thread t2 = new MyThread(tlt);
        Thread t3 = new MyThread(tlt);
        Thread t4 = new MyThread(tlt);
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // 运行结果如下：
//        Thread-1,com.liz.ocjpJava6.thread.mutilThread.threadLocal.Bean@1d51f311,Bean{id='0', name='none'}
//        Thread-1,com.liz.ocjpJava6.thread.mutilThread.threadLocal.Bean@1d51f311,Bean{id='0', name='none'}
//        Thread-1,com.liz.ocjpJava6.thread.mutilThread.threadLocal.Bean@1d51f311,Bean{id='0', name='none'}

//        Thread-0,com.liz.ocjpJava6.thread.mutilThread.threadLocal.Bean@8fe8fad,Bean{id='0', name='none'}
//        Thread-0,com.liz.ocjpJava6.thread.mutilThread.threadLocal.Bean@8fe8fad,Bean{id='0', name='none'}
//        Thread-0,com.liz.ocjpJava6.thread.mutilThread.threadLocal.Bean@8fe8fad,Bean{id='0', name='none'}

//        Thread-3,com.liz.ocjpJava6.thread.mutilThread.threadLocal.Bean@1b5ade43,Bean{id='0', name='none'}
//        Thread-3,com.liz.ocjpJava6.thread.mutilThread.threadLocal.Bean@1b5ade43,Bean{id='0', name='none'}
//        Thread-3,com.liz.ocjpJava6.thread.mutilThread.threadLocal.Bean@1b5ade43,Bean{id='0', name='none'}

//        Thread-2,com.liz.ocjpJava6.thread.mutilThread.threadLocal.Bean@120f6563,Bean{id='0', name='none'}
//        Thread-2,com.liz.ocjpJava6.thread.mutilThread.threadLocal.Bean@120f6563,Bean{id='0', name='none'}
//        Thread-2,com.liz.ocjpJava6.thread.mutilThread.threadLocal.Bean@120f6563,Bean{id='0', name='none'}

//        可以看出，4个线程有各自独立的实例的副本，互不影响

    }
}
