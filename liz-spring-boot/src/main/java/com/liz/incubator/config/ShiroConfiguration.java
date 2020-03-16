package com.liz.incubator.config;

import com.liz.incubator.service.ShiroRealmServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by lizhou on 2015/12/28
 * Spring boot 集成 Shiro（权限管理框架）的配置文件
 * Shiro安全配置 来源于官方文档（Integrating Apache Shiro into Spring-based Applications）： http://shiro.apache.org/spring.html
 * 权限控制：spring boot 集成shiro的配置(来源于CSDN) http://blog.csdn.net/qiuqiupeng/article/details/38984779
 */

@Configuration
public class ShiroConfiguration {

    private static Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();

    /* Define the Shiro Realm implementation you want to use to connect to your back-end */
    @Bean(name = "ShiroRealmImpl")
    public ShiroRealmServiceImpl getShiroRealm() {
        return new ShiroRealmServiceImpl();
    }

    /* 用户授权/认证信息Cache, 采用EhCache 缓存 */
    @Bean(name = "shiroEhcacheManager")
    public EhCacheManager getEhCacheManager() {
        EhCacheManager em = new EhCacheManager();
        em.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
        return em;
    }

    /* 保证实现了Shiro内部lifecycle函数的bean执行 */
    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager() {
        DefaultWebSecurityManager dwsm = new DefaultWebSecurityManager();
        dwsm.setRealm(getShiroRealm());//Using for Single realm app. If you have multiple realms, use the 'realms' property instead.
        dwsm.setCacheManager(getEhCacheManager());
        return dwsm;
    }

    /**
     * Enabling Shiro Annotations
     * In both standalone and web applications, you might want to use Shiro's Annotations for security
     * checks (for example, @RequiresRoles, @RequiresPermissions, etc. This requires Shiro's Spring AOP integration to
     * scan for the appropriate annotated classes and perform security logic as necessary.
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
        aasa.setSecurityManager(getDefaultWebSecurityManager());
        return new AuthorizationAttributeSourceAdvisor();
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
        daap.setProxyTargetClass(true);
        return daap;
    }


    //Spring整合Shiro做权限控制模块详细案例分析:
    // http://blog.csdn.net/he90227/article/details/38663553
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean
                .setSecurityManager(getDefaultWebSecurityManager());
        shiroFilterFactoryBean.setLoginUrl("/login");//没有权限或者失败后跳转的页面
        shiroFilterFactoryBean.setSuccessUrl("/loginSuccess");
        filterChainDefinitionMap.put("/mnCate", "authc");//authc:表示需要认证
        filterChainDefinitionMap.put("/welcome", "anon");//anon:表示匿名访问（不需要认证与授权）
        filterChainDefinitionMap.put("/helloWorld", "anon");//anon:表示匿名访问（不需要认证与授权）
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;


//        Shiro权限管理的过滤器解释：
//        默认过滤器(10个)
//        anon -- org.apache.shiro.web.filter.authc.AnonymousFilter
//        authc -- org.apache.shiro.web.filter.authc.FormAuthenticationFilter
//        authcBasic -- org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter
//        perms -- org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter
//        port -- org.apache.shiro.web.filter.authz.PortFilter
//        rest -- org.apache.shiro.web.filter.authz.HttpMethodPermissionFilter
//        roles -- org.apache.shiro.web.filter.authz.RolesAuthorizationFilter
//        ssl -- org.apache.shiro.web.filter.authz.SslFilter
//        user -- org.apache.shiro.web.filter.authc.UserFilter
//        logout -- org.apache.shiro.web.filter.authc.LogoutFilter


//        anon:例子/admins/**=anon 没有参数，表示可以匿名使用。
//         authc:例如/admins/user/**=authc表示需要认证(登录)才能使用，没有参数
//         roles：例子/admins/user/**=roles[admin],参数可以写多个，多个时必须加上引号，并且参数之间用逗号分割，当有多个参数时，例如admins/user/**=roles["admin,guest"],每个参数通过才算通过，相当于hasAllRoles()方法。
//         perms：例子/admins/user/**=perms[user:add:*],参数可以写多个，多个时必须加上引号，并且参数之间用逗号分割，例如/admins/user/**=perms["user:add:*,user:modify:*"]，当有多个参数时必须每个参数都通过才通过，想当于isPermitedAll()方法。
//         rest：例子/admins/user/**=rest[user],根据请求的方法，相当于/admins/user/**=perms[user:method] ,其中method为post，get，delete等。
//         port：例子/admins/user/**=port[8081],当请求的url的端口不是8081是跳转到schemal://serverName:8081?queryString,其中schmal是协议http或https等，serverName是你访问的host,8081是url配置里port的端口，queryString是你访问的url里的？后面的参数。
//         authcBasic：例如/admins/user/**=authcBasic没有参数表示httpBasic认证
//         ssl:例子/admins/user/**=ssl没有参数，表示安全的url请求，协议为https
//         user:例如/admins/user/**=user没有参数表示必须存在用户，当登入操作时不做检查
    }
}
