package com.liz.multipleThread.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * CountDownLatch位于包java.util.concurrent下面，
 * 应用场景是：有一个任务，需要等待其他几个任务完成之后才能继续执行
 * Created by lizhou on 2018年08月10日 21时37分
 */
public class CountDownLatchTest {
    private static CountDownLatch sCountDownLatch = null;
    private static final int THREAD_NUMBER = 3;

    /**
     * @param args
     */
    public static void main(String[] args) {
        sCountDownLatch = new CountDownLatch(THREAD_NUMBER);
        //线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(THREAD_NUMBER);

        fixedThreadPool.execute(new ConsumeRunnable("two"));
        fixedThreadPool.execute(new ConsumeRunnable("three"));
        System.out.println("等待3个子线程执行完毕...");
        try {
            //sCountDownLatch.await()方法在源码中的注释
            //Causes the current thread to wait until the latch has counted down to
            // zero, unless the thread is {@linkplain Thread#interrupt interrupted}.
            sCountDownLatch.await();//导致当前线程（即主线程）等待直到latch的计数降为0（除非子线程被打断）
            System.out.println("3个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class ConsumeRunnable implements Runnable {
        private String mName;

        public ConsumeRunnable(String name) {
            this.mName = name;
        }
        public void run() {
            System.out.println("子线程" + mName + "正在执行");
            try {
                Thread.sleep(3000);// 模拟耗时操作
                System.out.println("子线程" + mName + "执行完毕");
                sCountDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
