/*
 *Project: liz-incubator
 *File: com.liz.ocjpJava6.classLoader.Base.java <2018年01月04日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.ocjpJava6.classLoader;

/**
 * 类加载及初始化顺序
 * @author lizhou
 * @version 1.0
 * @Date 2018年01月04日 15时07分
 */
public class Base {

    private String baseName = "base";

    public Base() {
        callName();
    }

    public void callName() {
        System.out.println(baseName);
    }

    static class Sub extends Base {
        private String baseName = "sub";

        public Sub() {
            System.out.println("子类构造器");
        }

        public void callName() {
            System.out.println(baseName);
        }
    }

    public static void main(String[] args) {
        Base b = new Sub();

//        这道题无非就是考察我们三个知识点，
//        第一，类的加载机制以及类的初始化过程；
//        第二，继承的相关知识，其中这里涉及到子类继承父类的时候，同名的属性不会覆盖父类，只是会将父类的同名属性隐藏；
//        第三，多态性，多态性就是让实现与接口进行分离，
//        在这道题目中，在父类的构造方法中调用了虚函数造成多态

//        可以用DEBUG模式运行代码后验证下
    }
}
