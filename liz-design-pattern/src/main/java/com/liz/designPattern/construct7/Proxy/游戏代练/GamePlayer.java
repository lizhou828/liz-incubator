package com.liz.designPattern.construct7.Proxy.游戏代练;

/**
 * Created by Administrator on 2017/3/22 0022.
 */
public class GamePlayer implements IGamePlayer {

    private String name = "";

    public GamePlayer(String name) {
        this.name = name;
    }

    public void login(String username, String password) {
        System.out.println("用户名:" + this.name + ",密码：" + password +" 的用户登陆成功！");
    }

    public void killBoss() {
        System.out.println(this.name + " 正在打怪 !");
    }

    public void upgrade() {
        System.out.println(this.name + " 干掉了boss，又升了一级!");
    }
}
