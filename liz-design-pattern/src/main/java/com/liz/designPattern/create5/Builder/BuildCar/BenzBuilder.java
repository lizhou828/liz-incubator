/*
 *Project: liz-incubator
 *File: com.liz.designPattern.create5.Builder.BuildCar.BenzBuilder.java <2017年04月12日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.designPattern.create5.Builder.BuildCar;

import java.util.ArrayList;

/**
 * @author lizhou
 * @version 1.0
 * @Date 2017年04月12日 14时31分
 */
public class BenzBuilder extends CarBuilder {

    private BenzModel benzModel = new BenzModel();

    @Override
    public void setSequence(ArrayList<String> sequenceList) {
        this.benzModel.setSequenceList(sequenceList);
    }

    @Override
    public CarModel getCarModel() {
        return this.benzModel;
    }
}
