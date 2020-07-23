package com.liz.jdk8;

/**
 * https://blog.csdn.net/qq_35835624/article/details/80196932
 *
 * JDK8新增关键字 default
 * 允许接口有默认的实现方法
 *
 * 也可称为Virtualextension methods——虚拟扩展方法。
 * 是指，在接口内部包含了一些默认的方法实现（也就是接口中可以包含方法体，这打破了Java之前版本对接口的语法限制），从而使得接口在进行扩展的时候，不会破坏与接口相关的实现类代码
 * @author: Created by lizhou
 * @create: 2020-07-23 15:47
 **/
public class DefaultTest {
    public static void main(String[] args) {
//        如何使用default关键字?

//        1、调用父接口实现
        MyImplement myImplement = new MyImplement();
        myImplement.helloWorld(); //直接调用helloWorld()方法

//        2、同时继承两个接口
        MyImplement1 myImplement1 = new MyImplement1();
        myImplement1.helloWorld();

//        3、类优先于接口
        MyImplement2 myImplement2 = new MyImplement2();
        myImplement2.helloWorld();
    }
}

interface Interface1{
    default void helloWorld() {
        System.out.println("hi i'm from Interface1");
    }
}
interface Interface2{
    default void helloWorld() {
        System.out.println("hi i'm from Interface2");
    }
}

class MyImplement implements Interface1{

}

class MyImplement1 implements Interface1,Interface2{

    //因为两个接口的默认方法签名相同，必须要实现接口
//    不然编译器就懵逼了，当我们在MyImplement类中调用方法时，它不知道该去调用Interface1的默认方法还是去调用Interface2的方法
    @Override
    public void helloWorld() {
        System.out.println("hi i'm from MyImplement1");
    }
}

class MyImplement2 extends MyImplement1 implements Interface2{
//    MyImplement2 继承了MyImplement1 ,也实现了Interface2
//    那myImplement2.helloWorld()到底调用的是哪个接口呢,因为类优先于接口 会执行MyImplement1中的方法

}

