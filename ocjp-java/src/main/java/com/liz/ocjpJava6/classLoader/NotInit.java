/*
 *Project: liz-incubator
 *File: com.liz.ocjpJava6.classLoader.NotInit.java <2018年01月04日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.ocjpJava6.classLoader;

/**
 * @author lizhou
 * @version 1.0
 * @Date 2018年01月04日 10时56分
 */
public class NotInit {
    public static void main (String[] args) {
        System.out.println(ConstClass.HELLO);
//        这里不触发ConstClass的初始化，这是因为这编译阶段通过常量传播优化，把hello world的值存储到了NotInit类的常量池中了，
//        也就是说，实际NotInit中并没有ConstClass的引用！



//        -------------------接口的加载---------------------
//
//         接口中不能使用static{}语句块，但编译器仍为接口生成<clinit>()类构造器，用于初始化接口中所定义的成员变量。
//        接口的初始化场景与类基本相同，不过接口不同的是当其加载时，其父接口不会加载，除非子接口使用了父接口。
    }
}

class ConstClass{
    static {
        System.out.println("ConstClass static init");
    }

    static final String HELLO = "hello world";
}
