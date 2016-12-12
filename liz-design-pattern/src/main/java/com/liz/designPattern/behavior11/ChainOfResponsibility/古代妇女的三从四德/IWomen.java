package com.liz.designPattern.behavior11.ChainOfResponsibility.古代妇女的三从四德;

/**
 * Created by Frank on 2016/12/12.
 */
public interface IWomen {
    /* 获得个人状况 */
    public int getType();

    /* 获得个人请示，你要干什么？出去逛街？约会？还是看电影？  */
    public String getRequest();
}
