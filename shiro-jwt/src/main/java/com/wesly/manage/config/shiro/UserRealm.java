package com.wesly.manage.config.shiro;

import com.wesly.manage.model.User;
import com.wesly.manage.service.UserService;
import com.wesly.manage.util.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class UserRealm extends AuthorizingRealm {

    private UserService userService;

    public UserRealm(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected Object getAuthorizationCacheKey(PrincipalCollection principals) {
        return ((User) principals.getPrimaryPrincipal()).getId();
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("doGetAuthorizationInfo");
        User user = (User) principals.getPrimaryPrincipal();
        // 根据身份信息从数据库中查询权限数据
        List<String> permissions = userService.getUserPermissions(user.getId());
        //将权限信息封装为AuthorizationInfo
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        log.info("doGetAuthenticationInfo");
        String userId = (String) auth.getPrincipal();
        // 解密获得username，用于和数据库进行对比
        if (userId == null) {
            throw new AuthenticationException("token invalid");
        }
        // 从数据库获取对应用户名密码的用户
        User user = userService.findById(userId);
        if (user == null) {
            throw new UnknownAccountException();
        }
        // 用户为禁用状态
        if (user.getLocked()) {
            throw new LockedAccountException();
        }
        return new SimpleAuthenticationInfo(user, auth.getCredentials(), getName());
    }
}
