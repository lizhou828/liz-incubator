package com.liz.ocjpJava6.advanced.reflection.demo1;

import java.util.Date;

/**
 * Created by lizhou on 2016/9/29.
 *   Java反射探索研究 (二) 反射常用工具类
 *
 *  （1）bean复制工具： 这里可以使用commons-beanutils中的copyProperties()方法，自己写是为了加深对反射的理解。
 *   http://blog.csdn.net/evankaka/article/details/49978481
 */
public class ReflectionDemo2Main {

    public static void main(String[] args){
        Car car = new Car();
        car.setAge(12);
        car.setDriverPeople(4);
        car.setId("YU1234");
        car.setMaxSpeed(13.66);
        car.setMinSpeed(1.09);
        car.setName("小车");
        car.setSellFlag(false);
        car.setDate(new Date());


        Bus bus = new Bus();
        BeanCopy.copy(car,bus);
        System.out.println(car);
        System.out.println(bus);

        System.out.println("除了不同的字段外，其它的都复制过去了，这在DTO、VO、DOMAIN对象转换时经常用到。");
    }
}
