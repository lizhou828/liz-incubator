package com.liz.incubator.service;

import com.liz.common.utils.Md5Util;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

/**
 * Created by lizhou on 2015/12/28
 */
@Service
public class ShiroRealmServiceImpl extends AuthorizingRealm {

    @Override
    public String getName() {
        return "liz-incubator";
    }


    /**
     * 登陆认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取基于用户名和密码的令牌
        //实际上这个authcToken是从LoginController里面currentUser.login(token)传过来的
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        System.out.println("验证当前Subject时获取到token为" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));

        //此处无需比对,比对的逻辑Shiro会做,我们只需返回一个和令牌相关的正确的验证信息
        //说白了就是第一个参数填登录用户名,第二个参数填合法的登录密码(可以是从数据库中取到的,本例中为了演示就硬编码了)
        //这样一来,在随后的登录页面上就只有这里指定的用户和密码才能通过验证
        if("admin".equals(token.getUsername())){
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo("admin", Md5Util.encrypt("123456"), this.getName());
            this.setSession("currentUser", "admin");
            return authcInfo;
        }else if("xiaoming".equals(token.getUsername())){
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo("xiaoming", Md5Util.encrypt("123456"), this.getName());
            this.setSession("currentUser", "xiaoming");
            return authcInfo;
        }
        //没有返回登录用户名对应的SimpleAuthenticationInfo对象时,就会在LoginController中抛出UnknownAccountException异常
        return null;
    }

    /**
     *  授权方法，在配有缓存的情况下，只加载一次。
     *  本例中该方法的调用时机为需授权资源被访问时
     *  并且每次访问需授权资源时都会执行该方法中的逻辑,这表明本例中默认并未启用AuthorizationCache
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        if(principals == null ) throw new AuthorizationException("PrincipalCollection cannot be null.");

        //获取当前登录的用户名,等价于(String)principals.fromRealm(this.getName()).iterator().next()
        String currentUsername = (String)super.getAvailablePrincipal(principals);

        //为当前用户设置角色和权限
        SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
        if(null!=currentUsername && "admin".equals(currentUsername)){
            //添加一个角色,不是配置意义上的添加,而是证明该用户拥有admin角色
            simpleAuthorInfo.addRole("admin");
            //添加权限
            simpleAuthorInfo.addStringPermission("admin:manage");
            System.out.println("已为用户["+currentUsername+"]赋予了[admin]角色和[admin:manage]权限");
            return simpleAuthorInfo;
        }else{
            System.out.println("当前用户["+currentUsername+"]无授权");
            return simpleAuthorInfo;
        }
    }

    /**
     * 将一些数据放到ShiroSession中,以便于其它地方使用
     * 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到
     */
    private void setSession(Object key, Object value){
        Subject currentUser = SecurityUtils.getSubject();
        if(null != currentUser){
            Session session = currentUser.getSession();
            System.out.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
            if(null != session){
                session.setAttribute(key, value);
            }
        }
    }
}
