package com.liz.designPattern.behavior11.Command.项目经理也难当;

/**
 * Created by Frank on 2016/12/13
 */

/**
 * 删除页面的命令
 */
public class DeletePageCommand extends Command{
    /**
     * 执行删除一个页面的命令
     */
    @Override
    public void execute() {
        //找到美工组
        super.pageGroup.find();

        //删除一个页面
        super.pageGroup.delete();

        //给出变更计划
        super.pageGroup.plan();
    }
}
