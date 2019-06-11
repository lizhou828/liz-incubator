/*
 *Project: liz-incubator
 *File: com.liz.ocjpJava6.base.variableArgumentType.TestVarArgus.java <2018年01月30日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.ocjpJava6.base.variableArgumentType;

/**
 * Java可变参数，及其与数组的区别
 * 方法的参数个数可以不确定，用"..."定义
 * @author lizhou
 * @version 1.0
 * @Date 2018年01月30日 10时16分
 */
public class TestVarArgus {
    public static void dealArrayVarArgus(int... intArray) {
        for (int i : intArray)
            System.out.print(i + " ");

        System.out.println();
    }



    public static void main(String args[]) {
        dealArrayVarArgus();
        dealArrayVarArgus(1);
        dealArrayVarArgus(1, 2, 3);
//        输出：
//        1
//        1 2 3
//        通过main方法里的调用，可以看出来这个可变参数既可以是没有参数（空参数），也可以是不定长的。看到这里估计都能明白，这个不定长的参数其实和数组参数挺像的。
//      事实上，也确实是这么回事儿。编译器会在悄悄地把这最后一个形参转化为一个数组形参，并在编译出的class文件里作上一个记号，表明这是个实参个数可变的方法。
//      请看代码：
//        dealArrayVarArgus();//dealArray(int[] intArray{});
//        dealArrayVarArgus(1);//dealArray(int[] intArray{1});
//        dealArrayVarArgus(1,2,3);//dealArray(int[] intArray{1, 2, 3});

//        看看是不是这个可变参数就是数组类参数？









        int[] intArray = { 1, 2, 3 };
        dealArrayList(intArray);// 通过编译，正常运行
//        dealArrayList(1, 2, 3);// 编译错误
//        从上面这两段代码可以看出来，可变参数是兼容数组类参数的，但是数组类参数却无法兼容可变参数。
//        其实对于第二段代码而言，编译器并不知道什么可变不可变，在它看来，需要定义一个dealArray(int, int, int)类的方法。
//        所以，自然就无法去匹配数组类参数的dealArray方法了。








        dealArrayArgus(1, 2);
//        都知道是输出2，而不是1。这里需要记住：能匹配定长的方法，那么优先匹配该方法。含有不定参数的那个重载方法是最后被选中的。

    }






//    public static void dealArrayVarArgus(int[] intArray) {
// 会有Duplicate method dealArray(int[]) in type TestVarArgus的错误
//        for (int i : intArray)
//            System.out.print(i + " ");
//
//        System.out.println();
//    }

//    从上面这段代码可以看出，这两个方法是冲突的，是无法重载的








    public static void dealArrayList(int[] intArray) {
        for (int i : intArray)
            System.out.print(i + " ");

        System.out.println();
    }








    public static void dealArray(int count, int... intArray) {
    }
//    public static void dealArray(int... intArray, int count) {
        // 编译报错，可变参数类型应该作为参数列表的最后一项
//    这段代码说明了，可变参数类型必须作为参数列表的最后一项，而不能放在定长参数的前面。估计你会想到一个词“优先级”。
// 因为没有确切的说明，只是这样一种规定，这里可以借用“优先级”这个词来理解一下，请看下面的代码：
//    }








    public static void dealArrayArgus(int... intArray) {
        System.out.println("1");
    }
    public static void dealArrayArgus(int count, int count2) {
        System.out.println("2");
    }
}
