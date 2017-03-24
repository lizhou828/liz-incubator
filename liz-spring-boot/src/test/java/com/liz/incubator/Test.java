/*
 *Project: liz-incubator
 *File: com.liz.incubator.Test.java <2017年03月23日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.incubator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhou
 * @version 1.0
 * @Date 2017年03月23日 13时52分
 */
public class Test {

    public void method(){
        List<String> list = new ArrayList<String>();
        list.add("aaaaa");
        list.add("bbbbb");
        list.add("ccccc");
        list.add("ddddd");
        method1(list);
        method2(list);
        System.out.println(list);
    }
    public void method1(List<String> list){
        list.add("eeeee");
    }
    public void method2(List<String> list){
        list.add("fffff");
    }

    public static void main(String[] args) {
//        科学计数法
        System.out.println(10E-6 == 0.00001);
        System.out.println(1E-5 == 0.00001);

        System.out.println("====================================================================================");

        String [] strings = {"1" ,"ad" ,"nba", "cba","usa","uk","china"};
        for(int i = 0 ;i < strings.length;i++){
            if("cba".equals(strings[i])){
//                break; //break 意思是 断掉本层循环
                continue; //continue 意思是 断掉本层循环中的本次循环
            }
            System.out.println(strings[i]);
        }

        System.out.println("====================================================================================");

        Test test = new Test();
        test.method();

    }
}
