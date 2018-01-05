package com.liz.ocjpJava6.base;

/**
 * Created by Frank on 2017/2/7
 */
public class Equals {
    public static void main(String[] args) {
        byte a  = 127;
        byte b  = 127;
        a += b;//(越界不转型)编译ok
//      a = a+b; //(越界转型)编译报错 ：不兼容的类型：要求byte，却发现了int
        System.out.println("a="+a);  //a = -2


        byte b1=1;
//        b1=b1+1;//编译报错：不兼容的类型：要求byte，却发现了int(解释：1默认为int类型,b1自动转型为int与1做加法，结果是int类型的。把int类型赋给byte类型b1)
        b1 += 1;// b = (byte)(b+1);底层会对这个结果进行强转的
        System.out.println("b1=" + b1);

    }
}
