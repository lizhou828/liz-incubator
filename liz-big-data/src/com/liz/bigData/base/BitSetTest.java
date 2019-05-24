/*
 *Project: liz-incubator
 *File: com.liz.bigData.base.BitSetTest.java <2018年09月05日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.bigData.base;

import java.util.BitSet;

/**
 * @author lizhou
 * @version 1.0
 * @Date 2018年09月05日 15时50分
 */
public class BitSetTest {
    public static void main(String[] args) {
        int [] array = new int[]{3,1,2,55,0,5};
        BitSet bitSet = new BitSet(array.length);
        for(int i = 0 ;i< array.length;i++){
            bitSet.set(array[i],true);
        }
        System.out.println(bitSet.size());
        System.out.println(bitSet.get(3));
    }
}
