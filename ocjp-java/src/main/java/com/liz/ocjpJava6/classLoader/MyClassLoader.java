/*
 *Project: liz-incubator
 *File: com.liz.ocjpJava6.classLoader.MyClassLoader.java <2018年01月04日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.ocjpJava6.classLoader;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author lizhou
 * @version 1.0
 * @Date 2018年01月04日 11时03分
 */
public class MyClassLoader {


    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader my = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                InputStream is = getClass().getResourceAsStream(fileName);
                if (is == null) {
                    return super.loadClass(name);
                }
                byte[] b;
                try {
                    b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                return null;
            }
        };

        Object obj = my.loadClass("com.liz.ocjpJava6.classLoader.MyClassLoader");
        System.out.println(obj.getClass());
        System.out.println(obj instanceof MyClassLoader);

//        两个类相同的条件是，同一个类加载器，相同的全限定名。
//        即使两个类来源于同一个class文件，被同一个虚拟机加载，只要加载他们的类加载器不同，那这两个类就不相等。
//        这两个所指的"相等"包括代表Class对象的equals(),isAssignableFrom(),和isInstance()方法，也包括使用instanceof关键字做对象所属关系的判定。
    }
}
