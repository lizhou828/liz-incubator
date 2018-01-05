/*
 *Project: liz-incubator
 *File: com.liz.ocjpJava6.base.DateType.Index.java <2018年01月04日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.ocjpJava6.base.DateType;

/**
 *
 * Java语言提供了八种基本类型。
 * 一种布尔型。
 * 一种字符类型，
 * 六种数字类型（两个浮点型（默认是double 型）、四个整数型（默认是int 型）），
 *
 *
 *  bit：
 *  位、比特 ，一个二进制数据0或1，是1bit
 *
 *  byte：字节 （ 1 byte = 8 bit）
 *  存储空间的基本计量单位，如：MySQL中定义 VARCHAR(45)  即是指 45个字节；
 *   1 字母 = 1 byte = 8 bit
 *   1 汉字 = 2 byte = 16 bit
 *
 *
 * @author lizhou
 * @version 1.0
 * @Date 2018年01月04日 15时32分
 */
public class DataTypeOfJava {
    public static void main(String[] args) {


//        boolean：
//        boolean数据类型表示 1位 的信息；
//        只有两个取值：true和false；
//        这种类型只作为一种标志来记录true/false情况；
//        默认值是false；
//        例子：boolean one = true。
        boolean one = Boolean.TRUE;


//        char：
//        char类型是一个单一的16位Unicode字符；用 '' 表示一个字符。。java 内部使用Unicode字符集。。他有一些转义字符  ，2字节
//        最小值是’\u0000’（即为0）；
//        最大值是’\uffff’（即为65,535）；可以当整数来用，它的每一个字符都对应一个数字
//        char数据类型可以储存任何字符；
        char c1 = 'a';
        char c2 = '上';
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c1 + c2);
//        char 类型可以参与整型计算，然后转换成字符型
        int i=c1 + c2;
        char charcc=(char) (i);
        System.out.println(charcc);
        char[] c = new char[100];
        System.out.println("char[50]=" + c[50]);
        System.out.println("Character.MIN_VALUE="+ (int)Character.MIN_VALUE + "  ,Character.MAX_VALUE=" + (int)Character.MAX_VALUE + " ====================================================================\n");



//        byte：
//        byte数据类型是8位(bit比特)、有符号的，以二进制补码表示的整数；（256个数字），占1字节
//        最小值是-128（-2^7）；
//        最大值是127（2^7-1）；
//        默认值是0；
//        byte类型用在大型数组中节约空间，主要代替整数，因为byte变量占用的空间只有int类型的四分之一；
//        例子：byte a = 100，byte b = -50。
        byte[] bb = new byte[100];
        System.out.println("byte[50]=" + bb[50] + ",Byte.MIN_VALUE= " + Byte.MIN_VALUE + " , Byte.MAX_VALUE= " + Byte.MAX_VALUE + " ====================================================================\n");



//        short：
//        short数据类型是16位、有符号的以二进制补码表示的整数，占2字节
//        最小值是-32768（-2^15）；
//        最大值是32767（2^15 - 1）；
//        Short数据类型也可以像byte那样节省空间。一个short变量是int型变量所占空间的二分之一；
//        默认值是0；
//        例子：short s = 1000，short r = -20000。


//        int：
//        int数据类型是32位、有符号的以二进制补码表示的整数；占3字节
//        最小值是-2,147,483,648（-2^31）；
//        最大值是2,147,485,647（2^31 - 1）；
//        一般地整型变量默认为int类型；
//        默认值是0；
//        例子：int a = 100000, int b = -20000
        int ii [] = new int[100];
        System.out.println("int[10] = " + ii[10] + "  , Integer.MIN_VALUE = " + Integer.MIN_VALUE + "  ,  Integer.MAX_VALUE = " + Integer.MAX_VALUE + " ====================================================================\n");


//        long：
//        long数据类型是64位、有符号的以二进制补码表示的整数；占4字节
//        最小值是-9,223,372,036,854,775,808（-2^63）；
//        最大值是9,223,372,036,854,775,807（2^63 -1）；
//        这种类型主要使用在需要比较大整数的系统上；
//        默认值是0L；
//        例子：         long a = 100000L;
//        long a=111111111111111111111111;//(错误，整数型变量默认是int型)
        long a= 999999999999999999L;//(正确)
        System.out.println(" Long.MIN_VALUE = " + Long.MIN_VALUE + "  ,  Long.MAX_VALUE = " + Long.MAX_VALUE + " ====================================================================\n");


//        float：
//        float数据类型是单精度、32位、符合IEEE 754标准的浮点数；占4字节    -3.4*E38- 3.4*E38。。。浮点数是有舍入误差的
//        float在储存大型浮点数组的时候可节省内存空间；
//        默认值是0.0f；
//        浮点数不能用来表示精确的值，如货币；
//        例子：float f1 = 234.5f。
//        float f=6.26;//(编译错误：不兼容的类型，要求float却发现了double  浮点数默认类型是double类型)
        float ff=6.26F;//（转换正确，强制）
//        double d=4.55;//(正确)
        System.out.println(" Float.MIN_VALUE = " + Float.MIN_VALUE + "  ,  Float.MAX_VALUE = " + Float.MAX_VALUE + " ====================================================================\n");






//        double：
//        double数据类型是双精度、64位、符合IEEE 754标准的浮点数；
//        浮点数的默认类型为double类型；
//        double类型同样不能表示精确的值，如货币；
//        默认值是0.0d；
//        例子：double d1 = 123.4
        double dd [] = new double[100];
        System.out.println("double[10] = " + dd[10]);
        System.out.println(" Double.MIN_VALUE = " + Double.MIN_VALUE + "  ,  Double.MAX_VALUE = " + Double.MAX_VALUE + " ====================================================================\n");


        System.out.println("实际上，JAVA中还存在另外一种基本类型void，它也有对应的包装类 java.lang.Void，不过我们无法直接对它们进行操作。");
    }
}
