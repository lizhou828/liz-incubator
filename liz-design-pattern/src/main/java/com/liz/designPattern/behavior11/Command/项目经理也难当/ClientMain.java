package com.liz.designPattern.behavior11.Command.项目经理也难当;

/**
 * Created by Frank on 2016/12/13
 */
public class ClientMain {
    public static void main(String[] args) {

        /* 有一天老板发来一个命令：客户想要增加一个需求 */
        Command command = new AddRequirementCommand();

        /* 然后找来项目经理 小李 */
        ProjectManager xiaoLi = new ProjectManager();

        /* 老板语重心长的和小李说，这个需求很重要，要无条件的、以最快速度完成。然后小李接了这个"烫手的山芋" */
        xiaoLi.setCommand(command);

        /* 小李赶紧丢给他手下的去做 */
        xiaoLi.action();


        System.out.println("_____________________________________________________________");

        /*  第二天，客户和老板说：昨天加了那个新需求后，有些页面就不用，赶紧删了吧, */
        command = new DeletePageCommand();
        /* 然后小李急急忙忙的从老板那接到这个命令，赶紧要手下的人干起来 */
        xiaoLi.setCommand(command);
        xiaoLi.action();



    }
}
