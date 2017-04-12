/*
 *Project: liz-incubator
 *File: com.liz.designPattern.create5.Builder.BuildBody.PersonDirector.java <2017年04月12日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.designPattern.create5.Builder.BuildBody;

/**
 * Person对象的整体构造器
 * @author lizhou
 * @version 1.0
 * @Date 2017年04月12日 13时55分
 */
public class PersonDirector {
    public Person constructPerson(PersonBuilder personBuilder){
        personBuilder.buildHead();
        personBuilder.buildBody();
        personBuilder.buildFoot();
        return personBuilder.buildPerson();
    }

}
