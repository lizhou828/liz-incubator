/*
 *Project: liz-incubator
 *File: com.liz.ocjpJava6.thread.mutilThread.threadLocal.MyThreadLocal.java <2017年05月26日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.ocjpJava6.thread.mutilThread.threadLocal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 模拟实现ThreadLocal
 * @author lizhou
 * @version 1.0
 * @Date 2017年05月26日 10时25分
 */
public class MyThreadLocal {

    //定义了一个ThreadLocal变量，用来保存int或Integer数据
    private ThreadLocal<Bean> threadLocal = new ThreadLocal<Bean>(){
        @Override
        protected Bean initialValue() {
            return new Bean();
        }
    };

    @Override
    public String toString() {
        return "MyThreadLocal{" +
                "threadLocal=" + threadLocal +
                '}';
    }

    public Bean getBean() {
        return threadLocal.get();
    }

}

class ThreadLocal<T>{

    private Map<Thread,T> map = Collections.synchronizedMap(new HashMap<Thread, T>());

    public ThreadLocal() {
    }

    protected T initialValue() {
        return null;
    }

    public T get() {
        Thread t = Thread.currentThread();
        T obj = map.get(t);
        if (obj == null && !map.containsKey(t)) {
            obj = initialValue();
            map.put(t, obj);
        }
        return obj;
    }

    public void set(T value) {
        map.put(Thread.currentThread(), value);
    }

    public void remove() {
        map.remove(Thread.currentThread());
    }

}