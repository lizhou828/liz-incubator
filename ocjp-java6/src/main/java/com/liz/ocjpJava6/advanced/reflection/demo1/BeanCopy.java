package com.liz.ocjpJava6.advanced.reflection.demo1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by lizhou on 2016/9/29.
 */
public class BeanCopy {
    private static String GET = "get";
    private static String SET = "set";

    /**
     *
     * @param source
     * @param target
     * @throws Exception
     */
    public static void copy(Object source,Object target){
        Class<?> sourceClz = source.getClass();
        Class<?> targetClz = target.getClass();
        // 得到Class对象所表征的类的所有属性(包括私有属性)
        Field[] sourceFields = sourceClz.getDeclaredFields();
        if (sourceFields.length == 0) {
            sourceFields = sourceClz.getSuperclass().getDeclaredFields();
        }

        int len = sourceFields.length;
        for (int i = 0; i < len; i++) {
            String fieldName = sourceFields[i].getName();
            Field targetField = null;
            // 得到targetClz对象所表征的类的名为fieldName的属性，不存在就进入下次循环
            try {
                targetField = targetClz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                try {
                    targetField = targetClz.getSuperclass().getDeclaredField(fieldName);
                } catch (NoSuchFieldException e1) {
                    e1.printStackTrace();
                } catch (SecurityException e1) {
                    e1.printStackTrace();
                }
            }

            if (targetField == null) {
                continue;
            }

            // 判断sourceClz字段类型和targetClz同名字段类型是否相同
            if (sourceFields[i].getType() == targetField.getType()) {
                // 由属性名字得到对应get和set方法的名字
                String getMethodName = GET + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                String setMethodName = SET + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                // 由方法的名字得到get和set方法的Method对象
                Method getMethod;
                Method setMethod;
                try {
                    try {
                        getMethod = sourceClz.getDeclaredMethod(getMethodName,new Class[] {});//get方法入參為空
                    } catch (NoSuchMethodException e) {
                        getMethod = sourceClz.getSuperclass().getDeclaredMethod(getMethodName,new Class[] {});
                    }
                    try {
                        setMethod = targetClz.getDeclaredMethod(setMethodName,sourceFields[i].getType());//set方法入參不為空

                    } catch (NoSuchMethodException e) {
                        setMethod = targetClz.getSuperclass().getDeclaredMethod(setMethodName,sourceFields[i].getType());
                    }
                    // 调用source对象的getMethod方法
                    Object result = getMethod.invoke(source, new Object[] {});
                    // 调用target对象的setMethod方法
                    setMethod.invoke(target, result);

                } catch (SecurityException e) {
                    e.printStackTrace();

                } catch (NoSuchMethodException e) {
                    e.printStackTrace();

                } catch (IllegalArgumentException e) {
                    e.printStackTrace();

                } catch (IllegalAccessException e) {
                    e.printStackTrace();

                } catch (InvocationTargetException e) {
                    e.printStackTrace();

                }
            } else {
                continue;

            }

        }

    }
}
