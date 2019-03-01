package com.wesly.manage.config.shiro;

import com.wesly.manage.model.User;
import com.wesly.manage.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.List;

public class UserRealm extends AuthorizingRealm {

    private UserService userService;

    public UserRealm(UserService userService,String authorizationCacheName) {
        this.userService = userService;
        super.setAuthorizationCacheName(authorizationCacheName);
    }

    @Override
    public String getName() {
        return "userRealm";
    }

    @Override
    public String getAuthorizationCacheName() {
        return super.getAuthorizationCacheName();
    }

    @Override
    protected Object getAuthorizationCacheKey(PrincipalCollection principals) {
        return ((User) principals.getPrimaryPrincipal()).getId();
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) principalCollection.getPrimaryPrincipal();

        // 根据身份信息从数据库中查询权限数据
        List<String> permissions = userService.getUserPermissions(user.getId());
        //将权限信息封装为AuthorizationInfo
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermissions(permissions);
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
