package com.liz.designPattern.behavior11.Template_Method;

/**
 * Created by Frank on 2016/12/8
 */
public abstract class HummerModel {

    /* 启动 */
    protected abstract void start();

    /* 停止 */
    protected abstract void stop();

    /* 鸣笛 */
    protected abstract void alarm();

    /* 引擎启动声 */
    protected abstract void engineBoom();

    /* 运行 */
    /* 为了防止恶意操作，模板方法一般会加上final 关键字 ，不允许被重写 */
    final public void run(){

        this.start();

        this.engineBoom();

        if(this.isAlarm()){
            this.alarm();
        }

        this.stop();
    }

    /* 模板方法扩展：钩子方法，默认有鸣笛声的 */
    protected boolean isAlarm(){
        return true;
    }

}
