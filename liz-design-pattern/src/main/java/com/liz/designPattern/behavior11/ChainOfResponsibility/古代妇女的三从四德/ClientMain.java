package com.liz.designPattern.behavior11.ChainOfResponsibility.古代妇女的三从四德;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Frank on 2016/12/12.
 */
public class ClientMain {
    public static void main(String[] args) {
        Random random = new Random();
        List<IWomen> womenList = new ArrayList<IWomen>();
        for(int i= 0; i < 5; i++ ){
            womenList.add(new Women(random.nextInt(4),"我要出去逛街买买买，谁也别拦着我！！"));
        }

        Handler father = new Father();
        Handler husband = new Husband();
        Handler son = new Son();

        father.setNextHandler(husband);
        husband.setNextHandler(son);

        for(IWomen women : womenList){
            father.handleMessage(women);
        }
    }
}
