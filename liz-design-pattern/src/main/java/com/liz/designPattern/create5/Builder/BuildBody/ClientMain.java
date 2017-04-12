/*
 *Project: liz-incubator
 *File: com.liz.designPattern.create5.Builder.BuildBody.ClientMain.java <2017年04月12日}>
 ****************************************************************
 * 版权所有@2015 国裕网络科技  保留所有权利.
 ***************************************************************/

package com.liz.designPattern.create5.Builder.BuildBody;

/**
 * 造人
 * （单纯的）建造者模式
 * @author lizhou
 * @version 1.0
 * @Date 2017年04月12日 13时57分
 */
public class ClientMain {

    public static void main(String[] args) {
        PersonDirector personDirector = new PersonDirector();
        Person person = personDirector.constructPerson(new ManBuilder());
        System.out.println(person);
    }

}
