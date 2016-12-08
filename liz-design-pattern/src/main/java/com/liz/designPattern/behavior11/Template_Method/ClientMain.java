package com.liz.designPattern.behavior11.Template_Method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Frank on 2016/12/8.
 */
public class ClientMain {

    public static void main(String[] args) throws IOException {

        /**
         *
         * 模板使用场景：
         * 1、多个子类有公有的方法，并且逻辑基本相同时
         * 2、重要、复杂的算法，可以把核心的算法设计为模板方法，周边的相关袭击功能则由各个子类实现
         * 3、重构时，模板方法是一个常用的模式，把相同的代码提取到父类中，然后通过钩子函数 约束其行为
         *
         *
         * 模板方法优点：
         * 1、封装不变部分，扩展可变部分
         * 2、提取公共部分代码，便于维护
         * 3、行为由父类控制，子类实现
         *
         *
         * 模板方法缺点：
         * 子类的实现 会对父类产生影响。
         *
         */

        System.out.println(".........悍马H1启动.........");
        System.out.println("悍马H1是否需要鸣笛？ 0 - 不需要 1 - 需要");

        String type = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        HummerModelH1 h1 = new HummerModelH1();
        if("0".equals(type)){
            h1.setAlarm(false);
        }
        h1.run();


        System.out.println(".........悍马H2.........");
        HummerModelH2 h2 = new HummerModelH2();
        h2.run();
    }
}
