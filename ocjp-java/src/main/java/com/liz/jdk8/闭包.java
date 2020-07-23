package com.liz.jdk8;

import java.util.stream.Stream;

/**
 * @author: Created by lizhou
 * @create: 2020-07-23 15:33
 **/
public class 闭包 {

    public static void main(String[] args) {
        Stream.generate(Math::random);
    }
}
