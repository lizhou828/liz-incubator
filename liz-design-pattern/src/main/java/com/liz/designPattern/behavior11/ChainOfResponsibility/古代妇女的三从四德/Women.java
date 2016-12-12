package com.liz.designPattern.behavior11.ChainOfResponsibility.古代妇女的三从四德;

/**
 * Created by Frank on 2016/12/12.
 */
public class Women implements IWomen{

    /**
     * 通过一个int类型的参数 来描述妇女的个人状况：
     * 1：未出嫁
     * 2：出嫁
     * 3：丈夫死去
     */
    private int type;

    /* 妇女的请求 */
    private String request;

    /* 构造函数传递过来的请求 */
    public Women(int _type ,String _request){
        this.type = _type;
        this.request = _request;
    }

    /**
     * 获得自己的状况
     * @return
     */
    @Override
    public int getType() {
        return this.type;
    }

    @Override
    public String getRequest() {
        return this.request;
    }

    @Override
    public String toString() {
        return "当前妇女信息{" +
                "类型=" + type +
                ", 请求='" + request + '\'' +
                '}';
    }
}
