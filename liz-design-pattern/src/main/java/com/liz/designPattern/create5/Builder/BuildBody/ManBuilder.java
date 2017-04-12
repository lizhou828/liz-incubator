/*
 *Project: liz-incubator
 *File: com.liz.designPattern.create5.Builder.BuildBody.ManBuilder.java <2017年04月12日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.designPattern.create5.Builder.BuildBody;

/**
 * 男人对象的构造器
 * @author lizhou
 * @version 1.0
 * @Date 2017年04月12日 13时53分
 */
public class ManBuilder implements PersonBuilder {
    Person person;
    public ManBuilder() {
        person = new Man();
    }
    public void buildBody() {
        person.setBody("建造男人的身体");
    }

    public void buildFoot() {
        person.setFoot("建造男人的脚");
    }

    public void buildHead() {
        person.setHead("建造男人的头");
    }

    public Person buildPerson() {
        return person;
    }
}
