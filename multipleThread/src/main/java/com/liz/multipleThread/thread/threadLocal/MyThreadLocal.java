/*
 *Project: liz-incubator
 *File: com.liz.multipleThread.thread.threadLocal.MyThreadLocal.java <2017年05月26日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.multipleThread.thread.threadLocal;

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

    //定义了一个ThreadLocal变量，用来保存数据
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



    /**
     * 关于initialValue 这个方法 ，java源码中的描述如下：
     *
     * Returns the current thread's "initial value" for this
     * thread-local variable.  This method will be invoked the first
     * time a thread accesses the variable with the {@link #get}
     * method, unless the thread previously invoked the {@link #set}
     * method, in which case the {@code initialValue} method will not
     * be invoked for the thread.  Normally, this method is invoked at
     * most once per thread, but it may be invoked again in case of
     * subsequent invocations of {@link #remove} followed by {@link #get}.
     *
     * <p>This implementation simply returns {@code null}; if the
     * programmer desires thread-local variables to have an initial
     * value other than {@code null}, {@code ThreadLocal} must be
     * subclassed, and this method overridden.  Typically, an
     * anonymous inner class will be used.
     *
     * @return the initial value for this thread-local
     */
    protected T initialValue() {
        //do nothing ，由外部去实现
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