package com.liz.designPattern.behavior11.ChainOfResponsibility.古代妇女的三从四德;

/**
 * Created by Frank on 2016/12/12.
 */
public class Son extends Handler {

    /**
     * 儿子值处理母亲的请求
     */
    public Son() {
        super(Handler.SON_LEVEL_REQUEST);
    }

    /**
     * 儿子的答复
     * @param iWomen
     */
    @Override
    protected void response(IWomen iWomen) {
        System.out.println("----母亲向儿子请示----");
        System.out.println(iWomen.toString());
        System.out.println("儿子的答复是：同意 \n");
    }
}
