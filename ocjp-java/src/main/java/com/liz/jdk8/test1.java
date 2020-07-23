package com.liz.jdk8;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author: Created by lizhou
 * @create: 2020-07-23 14:54
 **/
public class test1 {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1,null,3,4,null,6);
        stream.filter(num -> num != null).count();
    }
}
