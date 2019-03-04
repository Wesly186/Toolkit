package com.wesly.manage.config.shiro;

import com.wesly.manage.config.shiro.cache.RedissonShiroCacheManager;
import com.wesly.manage.config.shiro.filter.KickoutSessionControlFilter;
import com.wesly.manage.config.shiro.session.RedissonSessionDao;
import com.wesly.manage.config.shiro.session.RedissonWebSessionManager;
import com.wesly.manage.service.UserService;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.ShiroHttpSession;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.redisson.api.RedissonClient;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    /**
     * 自定义realm和credentialsMatcher
     *
     * @return
     */
    @Bean
    public UserRealm userRealm(UserService userService) {
        UserRealm userRealm = new UserRealm(userService, "shiro-authorization");
        userRealm.setCredentialsMatcher(new CredentialsMatcher());
        return userRealm;
    }

    @Bean
    public CacheManager shiroCacheManager(RedissonClient redisson) {
        return new RedissonShiroCacheManager(redisson);
    }

    @Bean
    public SessionManager sessionManager(RedissonClient redisson) {
        // 设置cookie max age
        Cookie cookie = new SimpleCookie(ShiroHttpSession.DEFAULT_SESSION_ID_NAME);
        cookie.setMaxAge(-1);
        RedissonWebSessionManager redissonWebSessionManager = new RedissonWebSessionManager();
        redissonWebSessionManager.setGlobalSessionTimeout(3600000L);
        redissonWebSessionManager.setSessionDAO(new RedissonSessionDao(redisson, null));
        redissonWebSessionManager.setSessionIdCookie(cookie);
        // 是否在重定向时将session id拼在url后面
        redissonWebSessionManager.setSessionIdUrlRewritingEnabled(false);
        return redissonWebSessionManager;
    }

    @Bean
    public RememberMeManager rememberMeManager() {
        Cookie cookie = new SimpleCookie("rememberMe");
        cookie.setMaxAge(60 * 60 * 24 * 14);
        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
        //设置对称加密秘钥
        rememberMeManager.setCipherKey("1234567812345678".getBytes());
        rememberMeManager.setCookie(cookie);
        return rememberMeManager;
    }

    @Bean
    public SecurityManager securityManager(UserRealm userRealm, CacheManager cacheManager, SessionManager sessionManager, RememberMeManager rememberMeManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm.
        securityManager.setRealm(userRealm);
        // 自定义缓存实现 使用redis
        securityManager.setCacheManager(cacheManager);
        // 自定义session管理 使用redis
        securityManager.setSessionManager(sessionManager);
        securityManager.setRememberMeManager(rememberMeManager);
        return securityManager;
    }

    @Bean
    public KickoutSessionControlFilter kickoutSessionControlFilter(CacheManager cacheManager, SessionManager sessionManager) {
        KickoutSessionControlFilter filter = new KickoutSessionControlFilter();
        filter.setCacheManager(cacheManager);
        filter.setSessionManager(sessionManager);
        filter.setKickoutAfter(false);
        filter.setMaxSession(1);
        filter.setKickoutUrl("/login?kickout=1");
        return filter;
    }

    @Bean
    public FilterRegistrationBean<DelegatingFilterProxy> delegatingFilterProxy(){
        FilterRegistrationBean<DelegatingFilterProxy> filterRegistrationBean = new FilterRegistrationBean<>();
        DelegatingFilterProxy proxy = new DelegatingFilterProxy();
        proxy.setTargetFilterLifecycle(true);
        proxy.setTargetBeanName("shiroFilter");
        filterRegistrationBean.setFilter(proxy);
        return filterRegistrationBean;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager, KickoutSessionControlFilter kickoutSessionControlFilter) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 没有登陆的用户只能访问登陆页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/");
        // 未授权界面; ----这个配置了没卵用，具体原因想深入了解的可以自行百度
        shiroFilterFactoryBean.setUnauthorizedUrl("/auth/err");
        //自定义拦截器
        Map<String, Filter> filtersMap = new LinkedHashMap<String, Filter>();
        filtersMap.put("kickout", kickoutSessionControlFilter);
        shiroFilterFactoryBean.setFilters(filtersMap);
        // 权限控制map.
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/auth", "anon");
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/", "user");
        filterChainDefinitionMap.put("/**", "kickout,authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * RequireXXX advisor
     *
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    /**
     * 设置proxyTargetClass为true，使用cglib
     *
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }
}
