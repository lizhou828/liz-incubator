package com.liz.designPattern.construct7.Proxy.游戏代练;

/**
 * Created by Administrator on 2017/3/22 0022.
 */

/**
 * 游戏者接口
 */
public interface IGamePlayer {

    /* 登陆游戏 */
    public void login(String username ,String password);

    /* 打怪 */
    public void killBoss();

    /* 升级 */
    public void upgrade();

}
