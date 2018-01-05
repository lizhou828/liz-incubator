package com.liz.ocjpJava6.base;

/**
 * Created by Frank on 2017/2/18
 * 与++相关的面试题汇总
 */
public class PlusPlus {
    public static void main(String[] args) {
        int a = 1;
        System.out.println("a=" + a + " ,++a = " + (++a) + "  ,a=" + a + "  ,结论是：前加加 ++a 先自增,再赋值");
        System.out.println(" ++a : 先把 a 自己增加值 ，然后a的值作为 a++ 表达式的值（前加加、前面就加）");

        a = 1;
        System.out.println("a=" + a + " ,a++ = " + (a++) + "  ,a=" + a + "  ,结论是：后加加 a++ 先赋值,再自增");
        System.out.println(" a++ : 先把a的值作为 a++ 表达式的值，然后 a 自己增加值（后加加、后面才加）");
        System.out.println(" ++ 里有两层含义：自增 和 赋值 ，它在变量的前后位置不同，有不同的含义");

        a = 1;
        System.out.println(a++ + ++a);//4

//        a = 1;
//        System.out.println(a++);//a++ 这个表达式的值是1，但是a的值是2
//        System.out.println(++a);//前++之后，a先+1 ，++a的表达式值是3，a的值也是3

        a = 5;
        System.out.println(a-- - --a);//2
    }
}
