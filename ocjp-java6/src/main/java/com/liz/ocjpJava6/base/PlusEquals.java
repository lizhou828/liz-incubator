package com.liz.ocjpJava6.base;

/**
 * Created by Frank on 2017/2/7
 */
public class PlusEquals {
    public static void main(String[] args) {
        byte a  = 127;
        byte b  = 127;
        a += b;//(越界不转型)编译ok
//      a = a+b; //(越界转型)编译报错 ：不兼容的类型：要求byte，却发现了int
        System.out.println("a="+a);  //a = -2

        b = ++b;
//        b = ++b,这个运算的过程是:先进行++b的运算，再把运算后的结果赋给b，++b计算后是一个int类型的，
//        不管结果等于多少，底层会进行一个强转，也就是说++b就相当于 b = (byte)(b+1)，所以这个编译也没有问题，但是如果你
//        搞个byte b = 127; b = ++b; 这时超过了byte类型的最大范围了，怎么办？这时候底层会强转，把int类型的
//        前面三个高位丢弃，丢弃后，如果剩下的一位中，最高位为1，则取反加一，就成了负数了，如果最高位为0，直接把值赋给b

        System.out.println( "b=" + b);


        byte b1=1;
//        b1=b1+1;//编译报错：不兼容的类型：要求byte，却发现了int(解释：1默认为int类型,b1自动转型为int与1做加法，结果是int类型的。把int类型赋给byte类型b1)
        b1 += 1;// b = (byte)(b+1);底层会对这个结果进行强转的
        System.out.println("b1=" + b1);

    }
}
