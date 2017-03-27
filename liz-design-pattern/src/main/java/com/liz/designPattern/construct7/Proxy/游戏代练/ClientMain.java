package com.liz.designPattern.construct7.Proxy.游戏代练;

/**
 * 场景类
 * Created by Administrator on 2017/3/22 0022.
 */
public class ClientMain {
    public static void main(String[] args) {
        //定义一个土豪游戏玩家
        IGamePlayer 张三土豪 = new GamePlayer("张三土豪");

        //找到一个职业的游戏代练
        IGamePlayer 李四屌丝 = new GamePlayerProxy(张三土豪);

        李四屌丝.login("zhangShan的账号","123456");
        李四屌丝.killBoss();
        李四屌丝.upgrade();
    }
}
