package com.liz.jdk8;

import java.util.stream.Stream;

/**
 * 闭包：把方法作为参数进行传递
 * @author: Created by lizhou
 * @create: 2020-07-23 15:33
 **/
public class 闭包 {

    public static void main(String[] args) {
        Stream.generate(Math::random);
    }
}
