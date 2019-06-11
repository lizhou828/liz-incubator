/*
 *Project: liz-incubator
 *File: com.liz.ocjpJava6.base.Collection.list.ListDemo.java <2017年03月20日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.ocjpJava6.base.Collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhou
 * @version 1.0
 * @Date 2017年03月20日 16时53分
 */
public class ListDemo {
    public static void main(String[] args) {
        List<String> listA = new ArrayList<String>();
        listA.add("a");
        listA.add("b");
        listA.add("c");

        List<String> listB = new ArrayList<String>();
        listA.add("a");
        listA.add("d");
        listA.add("c");

        listA.retainAll(listB);
        System.out.println(listA);
    }
}
