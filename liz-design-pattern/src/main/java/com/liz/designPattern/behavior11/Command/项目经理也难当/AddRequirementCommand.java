package com.liz.designPattern.behavior11.Command.项目经理也难当;

/**
 * Created by Frank on 2016/12/13
 */

/**
 * 增加需求的命令
 */
public class AddRequirementCommand extends Command {

    /**
     * 执行增加一项需求的命令
     */
    @Override
    public void execute() {

        super.requirementGroup.find();
        super.pageGroup.find();
        super.codeGroup.find();

        super.requirementGroup.add();
        super.pageGroup.add();
        super.codeGroup.add();

        //给出变更计划
        super.requirementGroup.plan();
        super.pageGroup.plan();
        super.codeGroup.plan();
    }
}
