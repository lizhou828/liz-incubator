package com.liz.multipleThread.thread.sync;

import java.util.HashSet;
import java.util.Set;

/**
 * 多线程对共享变量的读写问题
 * 程序运行出现结果：[(1,1), (1,0), (0,1), (0,0)]
 * 原因：
 *      1、处理器的指令重排序
 *          JMM规范认为在不影响单线程运行结果的前提下，允许处理进行指令重排序（对于程序员、不同的处理器，JSR专家组的折中解决规范）
 *          JMM的核心：happens-before（JMM允许指令重排序的实现）
 *
 * 在对变量 x,y加上 volatile关键字后，程序结果也是：[(1,1), (1,0), (0,1), (0,0)]
 *
 * 原因
 *      2、内存的可见性
 *          线程间共享的变量，存在主内存
 *          线程内部的变量，仅存放在线程内部的工作内存，并会把该变量刷新到主内存中
 *
 *
 * 另外，在对变量 a,b加上 volatile关键字后，程序结果永远是：[(1,1), (1,0), (0,1)]
 *  原因
 *      被volatile修饰的变量，在线程的工作内存和主内存中的值是一致的（具有可见性）
 *
 * Created by lizhou on 2018年08月14日 22时09分
 */
public class VolatileTest {
    public volatile static int x,y = 0;
    public  static int a ,b = 0;
    public static Set<String> resultSet = new HashSet<String>();

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        while (true){
            Thread two = new Thread(new Runnable() {
                @Override
                public void run() {
                    b = 1 ;
                    x = a;
                }
            });
            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {
                    a = 1;
                    y = b;
                }
            });
            one.start();
            two.start();
            one.join();
            two.join();
            String result = "(" + x +  "," + y + ")";
            resultSet.add(result);
            System.out.println(resultSet);
            x= 0;
            y= 0;
            a= 0;
            b= 0;
            if(resultSet.size() > 3 ){
                long end = System.currentTimeMillis();
                System.out.println("处理完成，耗时：" + ( end - start )+ "毫秒");
                return;
            }
        }


    }
}
