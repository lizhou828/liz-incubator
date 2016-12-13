package com.liz.designPattern.behavior11.Command.项目经理也难当;

/**
 * Created by Frank on 2016/12/13
 */
public abstract class Command {

    /* 调用 需求组的人员过来 */
    protected RequirementGroup requirementGroup = new RequirementGroup();

    /* 调用 美工组的人员过来 */
    protected PageGroup pageGroup = new PageGroup();

    /* 调用 代码组的人员过来 */
    protected CodeGroup codeGroup = new CodeGroup();

    /**
     * 只有一个方法，你要我做什么事情
     */
    public abstract void execute();
}
