package com.liz.multipleThread.thread;

/**
 * Created by Frank on 2016/7/18.
 */
public class ThreadSleep {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(){
            @Override
            public void run() {
                while (true){
                    if(Thread.currentThread().isInterrupted()){
                        System.out.println(Thread.currentThread().getName()+"当前线程,已是被中断状态，即将退出循环！");
                        break;
                    }
                    try {
                        Thread.sleep(2000L);
                        System.out.println(Thread.currentThread().getName()+"当前线程,sleep(2000L)");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println("Interrupted when sleep in run() method...");

                        //加上下面这行代码，表示中断当前线程（看源码后，发现该方法会记录线程的中断状态）
                        Thread.currentThread().interrupt();
                    }
                }
            }
        };
        thread.start();
        Thread.sleep(1800L);
        System.out.println(Thread.currentThread().getName()+"当前线程,sleep(1800L)");
        thread.interrupt();
        System.out.println(Thread.currentThread().getName()+"当前线程,interrupt()");
    }
}
