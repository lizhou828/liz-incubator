/*
 *Project: liz-incubator
 *File: com.liz.designPattern.create5.Builder.BuildBody.PersonBuilder.java <2017年04月12日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.designPattern.create5.Builder.BuildBody;

/**
 * Person对象的构造接口
 * @author lizhou
 * @version 1.0
 * @Date 2017年04月12日 13时51分
 */
public interface PersonBuilder {
    void buildHead();

    void buildBody();

    void buildFoot();

    Person buildPerson();
}
