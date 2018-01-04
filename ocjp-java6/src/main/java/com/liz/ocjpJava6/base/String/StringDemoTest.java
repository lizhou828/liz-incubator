package com.liz.ocjpJava6.base.String;

/**
 * Created by Administrator on 2017/3/2 0002.
 */
public class StringDemoTest {
    public static void main(String[] args){
        String str1 = "hello";
        String str2 = "he" + new String("llo");
        System.err.println(str1 == str2);     // == 是比较两个对象的地址值，如果不同，内存给这两个对象分配了不同的地址，说明是两个不同的对象
        System.err.println(str1.equals(str2));//查看String类重新的equal方法，是比较两个字符串的char是否一致

    }

}
