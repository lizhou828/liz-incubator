/*
 *Project: liz-incubator
 *File: com.liz.questions_of_CV.伽然.Test1.java <2019年02月19日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.questions_of_CV.伽然;

import java.util.Arrays;
import java.util.List;

/**
 * @author lizhou
 * @version 1.0
 * @Date 2019年02月19日 10时00分
 */
public class Test1 {
    public static void main(String[] args) {

//        5、以下程序执行结果，并说明原因
        String [] flag = {"1","2","3"};
        List<String> list = Arrays.asList(flag);
        list.add("4"); //此处抛出 “ java.lang.UnsupportedOperationException”
        for(String str:list){
            System.out.println(str);
        }
//        因为Arrays.asList() 返回的是Arrays类静态内部内ArrayList
//        虽然Arrays类j静态内部内ArrayList 也实现了List接口，但没有实现其add()、remove()方法
    }
}
