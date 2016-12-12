package com.liz.designPattern.behavior11.ChainOfResponsibility.古代妇女的三从四德;

/**
 * Created by Frank on 2016/12/12.
 */
public abstract class Handler {

    public static final int FATHER_LEVEL_REQUEST = 1;

    public static final int HUSBAND_LEVEL_REQUEST = 2;

    public static final int SON_LEVEL_REQUEST = 3;

    /* 能处理的级别 */
    private int level;

    /* 责任传递，下一个责任人是谁 */
    private Handler nextHandler;

    /* 每一个实现的子类  都要说明一下 自己能处理哪个级别的请求 */
    public Handler(int handleLevel){
        this.level = handleLevel;
    }

    /**
     * 如果不属于你处理的请求，你应该让他找下一个环节的人，如果女儿出嫁了，
     * 还向父亲请示是否可以逛街，那父亲就应该告诉女儿，应该找丈夫请示
     * @param handler
     */
    public void setNextHandler(Handler handler){
        this.nextHandler = handler;
    }

    /**
     * 有请示那当然就要有回应
     * @param iWomen
     */
    protected abstract void response(IWomen iWomen);

    /**
     * 核心处理
     * 一个女性(女儿、妻子或者是母亲)要求逛街、看电影等，你要处理这个请求
     * 注意该方法的 final 关键字，类似于模板方法
     * @param iWomen
     */
    public final void handleMessage(IWomen iWomen){
        if (this.level == iWomen.getType()) {
            this.response(iWomen);
        } else {
            /* 有后续环节，才把请求往后传递 */
            if(null !=  this.nextHandler){
                this.nextHandler.handleMessage(iWomen);
            }else{
                //已经没有后续处理人了，不用处理了。
                System.out.println(iWomen.toString());
                System.out.println("----没地方请示了，按不同意处理----\n");
            }
        }
    }

}
