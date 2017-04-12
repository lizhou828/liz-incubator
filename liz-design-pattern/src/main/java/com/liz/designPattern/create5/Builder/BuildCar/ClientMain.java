/*
 *Project: liz-incubator
 *File: com.liz.designPattern.create5.Builder.BuildCar.ClientMain.java <2017年04月12日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.designPattern.create5.Builder.BuildCar;

import java.util.ArrayList;

/**
 * 造汽车：
 * 建造者模式 与 模板方法模式一起使用
 *
 * @author lizhou
 * @version 1.0
 * @Date 2017年04月12日 14时26分
 */
public class ClientMain {
    public static void main(String[] args) {
        /*
        * 客户告诉XX公司，我要这样一个模型，然后XX公司就告诉我老大
        * 说要这样一个模型，这样一个顺序，然后我就来制造
        */
        CarModel carModel1 = new BenzModel();

        //存放run的顺序
        ArrayList<String> sequence = new ArrayList<String>();
        sequence.add(CarModel.ENGINE_BOOM); //客户要求，run的时候先发动引擎
        sequence.add(CarModel.START); //启动起来
        sequence.add(CarModel.STOP); //开了一段就停下来
        //我们把这个顺序赋予奔驰车
        carModel1.setSequenceList(sequence);
        carModel1.run();
        System.out.println("这种方式TMD就是模板方法模式啊！！");


        System.out.println("============================================================================================");

//        看，我们组装了这样的一辆汽车，满足了××公司的需求。但是想想我们的需求，汽车的
//        动作执行顺序是要能够随意调整的。我们只满足了一个需求，还有下一个需求呀，然后是第
//        二个宝马模型，只要启动、停止，其他的什么都不要；第三个模型，先喇叭，然后启动，然
//        后停止；第四个……直到把你逼疯为止，那怎么办？我们就一个一个地来写场景类满足吗？
//        不可能了，那我们要想办法来解决这个问题，有了！我们为每种模型产品模型定义一个建造
//        者，你要啥顺序直接告诉建造者，由建造者来建造，

//        建立了CarBuilder、BMWBuilder 、BenzBuilder之后
        System.out.println("建立了CarBuilder、BMWBuilder 、BenzBuilder之后:");
        ArrayList<String> sequence1 = new ArrayList<String>();
        sequence1.add(CarModel.ENGINE_BOOM); //客户要求，run的时候先发动引擎
        sequence1.add(CarModel.START); //启动起来
        sequence1.add(CarModel.STOP); //开了一段就停下来
        //要一个奔驰车：
        CarBuilder carBuilder = new BenzBuilder();
        //把顺序给这个builder类，制造出这样一个车出来
        carBuilder.setSequence(sequence1);
        //制造出一个奔驰车
        CarModel carModel = carBuilder.getCarModel();
        //奔驰车跑一下看看
        carModel.run();

        System.out.println("============================================================================================");
//        我们在做项目时，经常会有一个共识：需求是无底洞，是无理性
//        的，不可能你告诉它不增加需求就不增加，这4个过程（start、stop、alarm、engine boom）按
//        照排列组合有很多种，××公司可以随意组合，它要什么顺序的车模我就必须生成什么顺序的
//        车模，客户可是上帝！那我们不可能预知他们要什么顺序的模型呀，怎么办？封装一下，找
//        一个导演，指挥各个事件的先后顺序，然后为每种顺序指定一个代码，你说一种我们立刻就
//        给你生产处理，好方法，厉害！
//        System.out.println("建立Director类：");
//
        Director director = new Director();
        //10辆A类型的奔驰车
        for(int i=0;i<10;i++){
            director.getABenzModel().run();
        }
        //100辆B类型的奔驰车
        for(int i=0;i<100;i++){
            director.getBBenzModel().run();
        }
        //1000辆C类型的宝马车
        for(int i=0;i<1000;i++){
            director.getCBMWModel().run();
        }

    }
}
