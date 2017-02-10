package com.liz.questions_of_CV.光大银行面试题;

/**
 * Created by Frank on 2017/2/9
 */
public class Main {
    private static void changeStr(String str){
        str = "welcome";
    }

    private static boolean foo(char c){
        System.out.print(c);
        return true;
    }

    private static String getSubStr(String str,int a ,int b){
        return str.substring(a,b);
    }

    public static void main(String[] args) {
//        第一题
        String str = "1234";
        changeStr(str);
        System.out.println(str);
        System.out.println("==============================================");

//        第二题
        int i = 0;
        for(foo('A');foo('B') && (i < 2); foo('C')){
            foo('D');
            i++;
        }
        System.out.println("==============================================");

//        第三题
        String str1 = getSubStr("abcabc",0,1);
        String str2 = getSubStr("abcabc",3,4);
        System.out.println(str1 + "," + str2);
        if(str1 == str2){
            System.out.println("A");
        }else{
            System.out.println("B");
        }
        System.out.println("==============================================");

        String a = "11";
        String b = "11";
        System.out.println(a == b); //字符串字面量可以用 == 比较
        a = new String("22");
        b = new String("22");
        System.out.println(a == b); ////字符串对象 不可以用 == 比较

    }
}
