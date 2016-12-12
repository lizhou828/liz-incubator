package com.liz.designPattern.behavior11.ChainOfResponsibility.古代妇女的三从四德;

/**
 * Created by Frank on 2016/12/12.
 */
public class Husband extends Handler {

    /**
     * 丈夫只处理妻子的请求
     */
    public Husband() {
        super(Handler.HUSBAND_LEVEL_REQUEST);
    }

    /**
     * 丈夫的答复
     * @param iWomen
     */
    @Override
    protected void response(IWomen iWomen) {
        System.out.println("----妻子向丈夫请示----");
        System.out.println(iWomen.toString());
        System.out.println("丈夫的答复是：同意 \n");
    }
}
