package com.liz.ocjpJava6.base;

/**
 * Created by Frank on 2017/2/7
 */
public class Equals {
    public static void main(String[] args) {
        byte a  = 127;
        byte b  = 127;
        a += b;//编译ok
//      a = a+b; //编译报错
        System.out.println("a="+a);


        char[] c = new char[100];
        System.out.println("c[50]=" + c[50]);


        int ii [] = new int[100];
        System.out.println("ii[10] = " + ii[10]);
    }
}
