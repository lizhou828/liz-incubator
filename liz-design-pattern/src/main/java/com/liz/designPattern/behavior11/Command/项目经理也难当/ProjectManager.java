package com.liz.designPattern.behavior11.Command.项目经理也难当;

/**
 * Created by Frank on 2016/12/13
 */

/**
 * 项目经理
 * 等待老板发出命令，不管老板有什么烂七八糟的命令或者任务，项目经理只能先接着
 */
public class ProjectManager {

    /* 命令 */
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    /* 执行老板的命令 */
    public void action(){
        this.command.execute();
    }

}
