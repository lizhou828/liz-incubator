package com.liz.ocjpJava6.base.String;

/**
 * String特性及其String对象的创建
 * Created by Administrator on 2017/3/2 0002.
 */
public class StringDemoTest {
    public static void main(String[] args){
//        1.   栈(stack)与堆(heap)都是Java用来在Ram中存放数据的地方。
//              与C++不同，Java自动管理栈和堆，程序员不能直接地设置栈或堆。
//
//        2.   栈的优势是，存取速度比堆要快，仅次于直接位于CPU中的寄存器。但缺点是，存在栈中的数据大小与生存期必须是确定的，缺乏灵活性。另外，栈数据可以共享，详见第3点。
//        堆的优势是可以动态地分配内存大小，生存期也不必事先告诉编译器，Java的垃圾收集器会自动收走这些不再使用的数据。但缺点是，由于要在运行时动态分配内存，存取速度较慢。

//
//        首先，我们先来看一下java中变量的语义：
//        java的变量有两种语义，原始类型的变量是值语义（value），也就是说，你给一个原始类型变量赋值，就改变了这个数据值本身。对象类型的变量是引用语义，也就是说，给一个对象类型的变量赋值只是让它指向另一个对象，但不改变原来引用的那个对象的值。
//        然后，我们了解一下String的特性以及java对于Sting特别的处理方式：
//
//
//
//        《String的特性》
//
//        1、String类是final的，不可被继承。
//        2、String类是的本质是字符数组char[], 并且其值不可改变。
//        3、String类对象有个特殊的创建的方式，就是直接指定比如String x = "abc"，"abc"就表示一个字符串对象。而x是"abc"对象的地址，也叫做"abc"对象的引用。
//        4、String对象可以通过“+”串联。串联后会生成新的字符串。
//        5、Java运行时会维护一个String Pool（String池），JavaDoc翻译很模糊“字符串缓冲区”。String池用来存放运行时中产生的各种字符串，并且池中的字符串的内容不重复。而一般对象不存在这个缓冲池，并且创建的对象仅仅存在于方法的堆栈区。
//
//        6、创建字符串的方式很多，归纳起来有三类：
//        其一，使用new关键字创建字符串，比如String s1 = new String("abc");
//        其二，直接指定。比如String s2 = "abc";
//        其三，使用串联生成新的字符串。比如String s3 = "ab" + "c";
//


//        《String对象的创建》
//        String对象的创建也有很多门道，关键是要明白其原理。
//
//        原理1：当使用任何方式来创建一个字符串对象s=X时，Java运行时（运行中JVM）会拿着这个X在String池中找是否存在内容相同的字符串对象，如果不存在，则在池中创建一个字符串s，否则，不在池中添加。
//
//        原理2：Java中，只要使用new关键字来创建对象，则一定会（在堆区或栈区）创建一个新的对象。
//
//        原理3：使用直接指定或者使用纯字符串串联来创建String对象，则仅仅会检查维护String池中的字符串，池中没有就在池中创建一个，有则罢了！但绝不会在堆栈区再去创建该String对象。
//
//        原理4：使用包含变量的表达式来创建String对象，则不仅会检查维护String池，而且还会在堆栈区创建一个String对象。
//
//
//        《不可变类》
//
//        JAVA为了提高效率，对String类型进行了特别的处理－－－为string类型提供了串池
//        定义一个string类型的变量有两种方式：
//
//
//        string name= "tom ";(String name="t"+"o"+"m"的效果和此处是相同的)
//        string name =new string( "tom ")
//
//
//        如果你使用了第一种方式，那么当你在声明一个内容也是 "tom "的string时，它将使用串池里原来的那个内存，而不会重新分配内存，也就是说，string saname= "tom ",将会指向同一块内存。而如果用第二种方式，不管串池里有没有"tom"，它都会在堆中重新分配一块内存，定义一个新的对象。
//
//        另外关于string类型是不可改变的问题： string类型是不可改变的，也就是说，当你想改变一个string对象的时候，比如name= "madding " 那么虚拟机不会改变原来的对象，而是生成一个新的string对象，然后让name去指向它，如果原来的那个 "tom "没有任何对象去引用它，虚拟机的垃圾回收机制将接收它。
//
//
//
//        最后，关于定义String的堆栈问题
//
//        String s =new String()分析堆与栈,是先定义S,还是先new string()
//        1.
        String str1 = "abc";
        System.out.println(str1 == "abc");//true  地址值相同
//        步骤：
//        1) 栈中开辟一块空间存放引用str1；
//        2) String池中开辟一块空间，存放String常量"abc"；
//        3) 引用str1指向池中String常量"abc"；
//        4) str1所指代的地址即常量"abc"所在地址，输出为true；
//
//
////
//        2、
        String str2 = new String("abc");
        System.out.println(str2 == "abc");// false  String对象地址、字面量常量地址
//        步骤：
//        1) 栈中开辟一块空间存放引用str2；
//        2) 堆中开辟一块空间存放一个新建的String对象"abc"；
//        3) 引用str2指向堆中的新建的String对象"abc"；
//        4) str2所指代的对象地址为堆中地址，而常量"abc"地址在池中，输出为false；
//
//
//
//        3.
          String str3 = new String("abc");
          System.out.println(str3 == str2);  //false new完之后，是两个不同的String对象
//        步骤：
//        1) 栈中开辟一块空间存放引用str3；
//        2) 堆中开辟一块新空间存放另外一个(不同于str2所指)新建的String对象；
//        3) 引用str3指向另外新建的那个String对象 ；
//        4) str3和str2指向堆中不同的String对象，地址也不相同，输出为false；
//
//
//
//        4.
        String str4 = "a" + "b";
        System.out.println(str4 == "ab");  // true 编译器 合并已知量 的优化功能(先问下有米有该常量，有的话就不创建，没有的话就创建)
//        步骤：
//        1) 栈中开辟一块空间存放引用str4；
//        2) 根据编译器合并已知量的优化功能，池中开辟一块空间，存放合并后的String常量"ab"；
//        3) 引用str4指向池中常量"ab"；
//        4) str4所指即池中常量"ab"，输出为true；
//
//
//
//        5.
         final String s = "a"; //注意:这里s用final修饰，相当于一个常量
        String str5 = s + "b";
        System.out.println(str5 == "ab");//true
//        步骤：
//        同四
//
//
//
//        6.
        String s1 = "a";
        String s2 = "b";
        String str6 = s1 + s2;
        System.out.println(str6 == "ab");
//        步骤：
//        1) 栈中开辟一块中间存放引用s1，s1指向池中String常量"a"，
//        2) 栈中开辟一块中间存放引用s2，s2指向池中String常量"b"，
//        3) 栈中开辟一块中间存放引用str5，
//        4) s1 + s2通过StringBuilder的最后一步toString()方法还原一个新的String对象"ab"，因此堆中开辟一块空间存放此对象，
//        5) 引用str6指向堆中(s1 + s2)所还原的新String对象，
//        6) str6指向的对象在堆中，而常量"ab"在池中，输出为false
//        可以通过  javap -c  com.liz.ocjpJava6.base.String.StringDemoTest.class 命令查看运行过程

//
//
//
//        7. String str7 = "abc".substring(0, 2);
//        步骤：
//        1) 栈中开辟一块空间存放引用str7，
//        2) substring()方法还原一个新的String对象"ab"（不同于str6所指），堆中开辟一块空间存放此对象，
//        3) 引用str7指向堆中的新String对象，
//
//
//
//        8. String str8 = "abc".toUpperCase();
//        步骤：
//        1) 栈中开辟一块空间存放引用str6，
//        2) toUpperCase()方法还原一个新的String对象"ABC"，池中并未开辟新的空间存放String常量"ABC"，
//        3) 引用str8指向堆中的新String对象
//
//
//
//        9.String s="abc";
//
//        String s1=s;
//
//        System.out.println(s1=="abc");
//
//        s=s+"hello";
//
//        System.out.println(s1=="abc");
//
//        System.out.println(s=="abc");
//
//        步骤：
//
//        1）栈中开辟一块空间存放s；
//
//        2）Sting池中开辟一块空间用于存放"abc"，栈中开辟一块空间存放变量s1；
//
//        3）系统输出true，在堆中开辟一块空间用于存放"abchello"；
//
//        4）引用s指向堆中的"abchello"；
//
//        5）系统输出true，然后输出false；
//







//        String str111 = "hello";
//        String str222 = "he" + new String("llo");
//        System.out.println(str111 == str222);     // == 是比较两个对象的地址值，如果不同，内存给这两个对象分配了不同的地址，说明是两个不同的对象
//        System.out.println(str111.equals(str222));//查看String类重新的equal方法，是比较两个字符串的char是否一致

    }

}
