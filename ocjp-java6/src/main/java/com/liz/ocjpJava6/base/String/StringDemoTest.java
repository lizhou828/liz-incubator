package com.liz.ocjpJava6.base.String;

/**
 * Created by Administrator on 2017/3/2 0002.
 */
public class StringDemoTest {
    public static void main(String[] args){
        String str1 = "hello";
        String str2 = "he" + new String("llo");
        System.err.println(str1 == str2);
    }

}
