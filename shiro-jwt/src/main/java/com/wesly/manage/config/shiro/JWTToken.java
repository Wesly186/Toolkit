package com.wesly.manage.config.shiro;

import com.wesly.manage.util.JWTUtil;
import org.apache.shiro.authc.AuthenticationToken;

public class JWTToken implements AuthenticationToken {

    // 密钥
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return JWTUtil.getUsername(token);
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
