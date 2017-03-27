package com.liz.designPattern.construct7.Proxy.游戏代练;

/**
 * 游戏代练者
 * Created by Administrator on 2017/3/22 0022.
 */
public class GamePlayerProxy implements IGamePlayer ,IPoxy{
    private IGamePlayer iGamePlayer;

    /**
     * 通过构造函数传递 要对谁进行代练
     * @param iGamePlayer
     */
    public GamePlayerProxy(IGamePlayer iGamePlayer) {
        this.iGamePlayer = iGamePlayer;
    }

    public void login(String username, String password) {
        this.iGamePlayer.login(username,password);
    }

    public void killBoss() {
        this.iGamePlayer.killBoss();
    }

    public void upgrade() {
        this.iGamePlayer.upgrade();
        this.count();
    }

    public void count() {
        System.out.println("升级总费用是：150元");
    }
}
