package com.liz.incubator.controller;

import com.liz.incubator.model.User;
import com.liz.common.utils.Md5Util;
import com.liz.incubator.service.UserService;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by lizhou on 2015/12/28
 */

@Controller
public class LoginController extends BaseController{

    private static Log log = LogFactory.getLog(LoginController.class);

    @Autowired
    private UserService userService;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @RequestMapping("/login")
    public ModelAndView login(){
        log.info("login() is running....");
        return new ModelAndView("login");
    }

    /**
     * 用户登出
     * @return
     */
    @RequestMapping("/logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return InternalResourceViewResolver.REDIRECT_URL_PREFIX + "/";
    }

    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public String doLogin(User user){
        user.setPassword(Md5Util.encrypt(user.getPassword()));
//        User userFromDB =  userService.findByUser(user);
        User userFromDB =  new User();
        if ( userFromDB != null  && user.getPassword().equals(userFromDB.getPassword())) {
            UsernamePasswordToken token = new UsernamePasswordToken(userFromDB.getUserName(), userFromDB.getPassword());
            token.setRememberMe(true);
            System.out.println("为了验证登录用户而封装的token为" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));
            //获取当前的Subject
            Subject subject = SecurityUtils.getSubject();
            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
            try{
                System.out.println("对用户[" + userFromDB.getUserName() + "]进行登录验证..验证开始");
                subject.login(token);
                System.out.println("对用户[" + userFromDB.getUserName()+ "]进行登录验证..验证通过");
            }catch (UnknownAccountException uae){
                System.out.println("对用户[" + userFromDB.getUserName() + "]进行登录验证..验证未通过,未知账户");
            }catch(IncorrectCredentialsException ice){
                System.out.println("对用户[" + userFromDB.getUserName() + "]进行登录验证..验证未通过,错误的凭证");
            }catch(LockedAccountException lae){
                System.out.println("对用户[" + userFromDB.getUserName() + "]进行登录验证..验证未通过,账户已锁定");
            }catch(ExcessiveAttemptsException eae){
                System.out.println("对用户[" + userFromDB.getUserName() + "]进行登录验证..验证未通过,错误次数过多");
            }catch(AuthenticationException ae) {
                //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
                System.out.println("对用户[" + userFromDB.getUserName() + "]进行登录验证..验证未通过,堆栈轨迹如下");
                ae.printStackTrace();
            }
            //验证是否登录成功
            if(subject.isAuthenticated()){
                System.out.println("用户[" + userFromDB.getUserName() + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
                return InternalResourceViewResolver.REDIRECT_URL_PREFIX + "loginSuccess";
            }else{
                System.out.println("对用户[" + userFromDB.getUserName()+ "]进行登录验证..用户名或密码错误(或者无此权限)!");
                //如用户信息为空，则subject信息登出
                subject.logout();
                token.clear();
                return InternalResourceViewResolver.REDIRECT_URL_PREFIX + "loginFail";
            }
        }
        return InternalResourceViewResolver.REDIRECT_URL_PREFIX + "loginFail";
    }

    @RequestMapping("/loginSuccess")
    public String loginSuccess(){
        return "loginSuccess";
    }

    @RequestMapping("/loginFail")
    public String loginFail(){
        return "loginFail";
    }
}
