/*
 *Project: liz-incubator
 *File: com.liz.multipleThread.thread.threadLocal.Bean.java <2017年05月26日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.multipleThread.thread.threadLocal;

/**
 * @author lizhou
 * @version 1.0
 * @Date 2017年05月26日 10时46分
 */
public class Bean {
    private String id = "0";
    private String name = "none";

    public Bean() {
    }

    public Bean(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String showInfo() {
        return "Bean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
