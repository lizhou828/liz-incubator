/*
 *Project: liz-incubator
 *File: com.liz.designPattern.create5.Builder.BuildCar.CarBuilder.java <2017年04月12日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.designPattern.create5.Builder.BuildCar;

import java.util.ArrayList;

/**
 * 抽象汽车建造者
 * @author lizhou
 * @version 1.0
 * @Date 2017年04月12日 14时29分
 */
public abstract class CarBuilder {

    //建造一个模型，你要给我一个顺序要求，就是组装顺序
    public abstract void setSequence(ArrayList<String> sequenceList);

    //设置顺序完毕后，就可以直接拿到这个车辆模型
    public abstract CarModel getCarModel();

}
