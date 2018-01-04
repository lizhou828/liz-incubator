/*
 *Project: liz-incubator
 *File: com.liz.ocjpJava6.classLoader.NotInitialization.java <2018年01月04日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.ocjpJava6.classLoader;

/**
 * @author lizhou
 * @version 1.0
 * @Date 2018年01月04日 10时35分
 */
public class NotInitialization {
    public static void main(String[] args) {

        System.out.println(SubClass.value);
        //对于静态字段，只有直接定义这个字段的类才会被初始化
        //因此通过其子类来引用父类中定义的静态字段，只会触发父类的初始化而不会触发子类的初始化。


        System.out.println("============================================================================================");
        //这里如果把value放在SubClass中，就会输出SubClass static init了！

        System.out.println("============================================================================================");
        SuperClass[] su = new SuperClass[10];//定义数组不会加载类
//        不过，这里有个重点,这段代码会触发一个由虚拟机自动生成的，直接继承于Object的子类的加载(通过newarraay指令触发)，这个自动生成的类代表了一维数组，其中有length属性和clone()方法。
//        这就是为什么数组能直接使用length的原因，由此还看出使用clone()方法可以直接复制数组！

        System.out.println("============================================================================================");


    }
}

class SuperClass {

    static {
        System.out.println("SuperClass static init!");
    }

    public static int value = 123;

    public SuperClass() {
        System.out.println("init SuperClass");
    }
}

class SubClass extends SuperClass {

//    public static int value = 123456; //会覆盖父类同名的静态变量

    static {
        System.out.println("SubClass static init");
    }

    public SubClass() {
        System.out.println("init SubClass");
    }
}