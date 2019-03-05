package com.wesly.manage.config.shiro;

import com.wesly.manage.util.JWTUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;

import java.nio.charset.StandardCharsets;

public class JWTMatcher extends SimpleCredentialsMatcher {

    private String jwtSecret;

    public JWTMatcher(String jwtSecret) {
        this.jwtSecret = jwtSecret;
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
        JWTToken token = (JWTToken) authcToken;
        return JWTUtil.verify(token.getCredentials().toString(), token.getPrincipal().toString(), jwtSecret);
    }
}