package com.liz.ocjpJava6.advanced.reflection.demo1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by lizhou on 2016/9/29
 *
 * Java反射探索研究 (一) 基本操作
 * http://blog.csdn.net/evankaka/article/details/49978481
 */
public class ReflectionDemo1Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException {
        Dog dog = new Dog();
        System.out.println(dog.getClass());
        System.out.println(dog.getClass().getName());

        Class<?> dogClass = dog.getClass();
        Class<?> dogClass1 = Dog.class;
        Class<?> dogClass2 = Class.forName("com.liz.ocjpJava6.advanced.reflection.demo1.Dog");

        Method[] methods1 = dogClass.getMethods();
        System.out.println("====================通过getMethods取得方法开始====================");
        for (Method method : methods1) {
            System.out.println(method);
        }
        System.out.println("====================通过getMethods取得方法结束====================\n");
        Method[] methods2 = dogClass.getDeclaredMethods();
        System.out.println("====================通过getDeclaredMethods取得方法开始====================");
        for (Method method : methods2) {
            System.out.println(method);
        }
        System.out.println("====================通过getDeclaredMethods取得方法结束====================\n");


        System.out.println("====================取得函数的一些基本信息开始====================");
        dogClass = Dog.class;
        Method[] methods = dogClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("函数名："+method.getName() +"        函数类型："+ method.getModifiers()
                    + "         函数返回： "+ method.getReturnType() + "        函数参数个数：" + method.getParameterCount()
            );
        }
        System.out.println("====================取得函数的一些基本信息结束====================\n");




        Field[] fields = dogClass.getFields();
        System.out.println("====================通过getFields取得方法开始====================");
        for (Field field : fields) {
            System.out.println( field.getName() + "," + field.getModifiers() + "," + field.getType());
        }

        System.out.println("注意，getField只能取得public的字段");
        Field field1 = dogClass.getDeclaredField("name");//注意，getField只能取得public的字段
        field1.setAccessible(true);//私有变量必须先设置Accessible为true
        Dog dog1 = new Dog("狗狗1号", 12);
        System.out.println(dog1);
        System.out.println("原本狗名：" + field1.get(dog1));
        field1.set(dog1,"狗狗2号");
        System.out.println(dog1);

        System.out.println("====================通过getFields取得方法结束====================\n");









        Constructor<?>[] constructors = dogClass.getConstructors();
        System.out.println("====================列出所有的构造函数结束====================");
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("====================列出所有的构造函数结束====================\n");





        System.out.println("====================通过newInstance()来生成对象，一定要有默认构造函数====================");
        dog1 = (Dog) dogClass.newInstance();
        dog1.setName("狗狗1号");
        dog1.setAge(7);
        System.out.println(dog1);

        System.out.println("====================通过newInstance(参数)方法一来生成对象====================");
        Dog dog2 = (Dog)constructors[2].newInstance("狗狗2号");
        System.out.println(dog2);

        System.out.println("====================通过newInstance(参数)方法二来生成对象====================");
        Constructor con1 = dogClass.getConstructor(new  Class[]{String.class,int.class,int.class});     //主要就是这句了
        Dog dog3 = (Dog) con1.newInstance(new Object[]{"狗狗3号",14,4});
        System.out.println(dog3 + ",runSpeed = " + dog3.runSpeed() +"\n");




    }
}
