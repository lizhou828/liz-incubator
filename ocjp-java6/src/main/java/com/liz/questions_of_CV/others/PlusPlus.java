package com.liz.questions_of_CV.others;

/**
 * Created by Frank on 2017/2/18
 * 与++相关的面试题汇总
 */
public class PlusPlus {
    public static void main(String[] args) {
        int a = 1 ;
//        System.out.println(a++ + ++a);//4
        System.out.println(a++);//a++ 这个表达式的值是1，但是a的值是2
        System.out.println(++a);//前++之后，a先+1 ，++a的表达式值是3，a的值也是3
    }
}
