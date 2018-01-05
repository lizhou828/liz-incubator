/*
 *Project: liz-incubator
 *File: com.liz.ocjpJava6.base.String.StringDemoTest1.java <2018年01月05日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.ocjpJava6.base.String;

/**
 * String s = new String("XYZ") + new String("XYZ");到底创建几个对象?
 * 原文地址：http://blog.sina.com.cn/s/blog_61af23120100xsrd.html
 * @author lizhou
 * @version 1.0
 * @Date 2018年01月05日 17时58分
 */
public class StringDemoTest1 {
//    最近在论坛上看到关于String s = new String("XYZ") + new String("XYZ");到底创建几个对象的讨论，觉得比较有意思，在此总结一下。
//
//    在JAVA中除了8种基本类型之外，其他的都是类对象及其引用。所以 "XYZ"在JAVA中是一个String对象，对于String类对象来说它的对象值是不能修改的，也就是具有不变性。
//
//    但是在下面一段程序中：
//
//
//
//    view plainprint?
//    public class TestString {
//        public static void main(String args[]) {
//            String s = "Hello";
//            s = "Java";
//            String s1 = "Java";
//            String s2 = new String("Java");
//            System.out.println(s);
//            System.out.println(s == s1);
//            System.out.println(s == s2);
//        }
//    }
//
//    打印出s的结果是"Java"，看起来s所引用的String变量好像是被修改了，但是如果你了解JVM(Java虚拟机)处理String变量时的机制，你就会知道事实并非如此。
//    在JVM的工作过程中，会创建一片的内存空间专门存入String对象，我们把这片内存空间叫做String池。
//
//    对于语句String s= "Hello";，当JVM看到"Hello"时，会在String池创建String对象存储它，并将它的引用返回给String变量s。
//    语句s = "Java";，当JVM看到"Java"时，会在String池创建新的String对象存储它，再把新建的String对象的引用返回给String变量s。而原先的String对象"Hello"仍然在String池内，并没有消失，它是不能被修改的。
//
//    所以我们仅仅是改变了变量s的引用，而没有改变它所引用的对象，因为String对象的值是不能被修改的。
//
//    String s1 = "Java";，JVM首先在String池里面看能否找到字符串"Java"，如果找到则返回它的引用给s1，否则创建新的String对象，放到String池里。
// 这里由于有s = "Java"，所以对象已经被引用，所以依据规则s和s1都是引用同一个对象。所以s==s1返回true。(注： 比较运算符==，对于非基本类型，是比较两引用是否引用内存中的同一个对象)。
//
//    String s2 = new String( "Java");，JVM首先还是在String池里面看能否找到字符串 "Java"，如果找到，不做任何事情；否则创建新的String对象，放到String池里面。
// 由于遇到了new关键字，还会在内存上（不是String池里面）创建String对象存储 "Java"，并将内存上的（不是String池里面的）String对象返回给s2。所以s==s2将返回false，因为它们引用的不是同一个对象。
//
//
//    所以对于语句String s = new String("XYZ") + new String("XYZ");
//
//    JVM先在String池中创建一个String对象存储"XYZ"，然后由于遇到new关键字，再在内存上创建一个String对象存储"XYZ"；
//
//    接着由于String池中已经有了"XYZ"的对象，所以第二个new语句不会在String池中创建对象，而只会在内存上创建一个String对象；
//
//    最后两个字符串相加会在String池中创建一个String对象"XYZXYZ"，并将其引用传给s。
//
//    所以总共会创建4个String对象。
//
//
//
//
//
//    注意：“最后两个字符串相加会在String池中创建一个String对象"XYZXYZ"，并将其引用传给s。”最后这句话可能有问题！
//
//    public static void main(String[] args) {
//        String xyzxyzOne = "xyzxyz";
//        String xyzOne = new String("xyz");
//        String xyzTwo = new String("xyz");
//        String xyzxyzTwo = xyzOne + xyzTwo;
//        System.out.println("(xyzxyzOne == xyzxyzTwo):"
//                + (xyzxyzOne == xyzxyzTwo));
//    }
//    输出为：(xyzxyzOne == xyzxyzTwo):false
//    所以应该是在内存中创建的String对象。


}
