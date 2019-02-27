package com.wesly.manage.config.shiro;

import com.wesly.manage.model.User;
import com.wesly.manage.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class UserRealm extends AuthorizingRealm {

    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserRealm.class);

    public UserRealm(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String getName() {
        return "userRealm";
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();

        // 根据身份信息从数据库中查询权限数据
        List<String> permissions = userService.getUserPermissions(username);
        //将权限信息封装为AuthorizationInfo
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (String permission : permissions) {
            simpleAuthorizationInfo.addStringPermission(permission);
        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();

        // 从数据库获取对应用户名密码的用户
        User user = userService.findByUsername(username);
        if (user == null) {
            throw new UnknownAccountException();
        }
        // 用户为禁用状态
        if (user.getLocked()) {
            throw new LockedAccountException();
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
    }
}
