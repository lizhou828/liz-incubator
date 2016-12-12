package com.liz.designPattern.behavior11.ChainOfResponsibility.古代妇女的三从四德;

/**
 * Created by Frank on 2016/12/12.
 */
public class Father extends Handler {

    /* 父亲只处理女儿的请求 */
    public Father() {
        super(Handler.FATHER_LEVEL_REQUEST);
    }

    /**
     * 父亲的答复
     * @param iWomen
     */
    @Override
    protected void response(IWomen iWomen) {
        System.out.println("----女儿向父亲请示----");
        System.out.println(iWomen.toString());
        System.out.println("父亲的答复是：同意  \n");
    }
}
