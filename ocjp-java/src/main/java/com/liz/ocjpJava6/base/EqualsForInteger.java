package com.liz.ocjpJava6.base;

import java.lang.reflect.Field;

/**
 * Created by lizhou on 2017/2/9
 */
public class EqualsForInteger {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Integer aa = 127;
        Integer bb = 127;
        System.out.println( aa == bb ); //true

        Integer cc = 128;
        Integer dd = 128;
        System.out.println( cc == dd ); //false

//        说明：
//        对于Integer var= ? 在-128至127之间的赋值，Integer对象是在IntegerCache.cache产生，会复用已有对象，这个区间内的Integer值可以直接使用==进行判断。
//        但是这个区间之外的所有数据，都会在堆上产生，并不会复用已有对象，这是一个大坑，推荐使用equals方法进行判断。



        Class cache = Integer.class.getDeclaredClasses()[0]; //1
        Field myCache = cache.getDeclaredField("cache"); //2
        myCache.setAccessible(true);//3
        Integer[] newCache = (Integer[]) myCache.get(cache); //4
        newCache[132] = newCache[133]; //5
        int a = 2;
        int b = a + a;
        System.out.printf("%d + %d = %d", a, a, b); //
    }
}
