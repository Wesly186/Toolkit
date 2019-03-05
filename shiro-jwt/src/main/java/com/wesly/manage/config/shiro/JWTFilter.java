package com.wesly.manage.config.shiro;

import com.alibaba.fastjson.JSON;
import com.wesly.manage.bean.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class JWTFilter extends AccessControlFilter {

    private MessageSource messageSource;

    public JWTFilter(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        try {
            this.executeLogin(servletRequest, servletResponse);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        log.info("onAccessDenied");
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setCharacterEncoding("UTF-8");
        //设置Http响应头控制UTF-8
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        CommonResult commonResult = CommonResult.resultError(Integer.valueOf(getLocaleMessage("api.error.code.authenticate_fail")),
                getLocaleMessage("api.error.message.authenticate_fail"));
        response.getWriter().write(JSON.toJSONString(commonResult));
        return false;
    }

    private void executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        AuthenticationToken token = createToken(request, response);
        // 提交给realm进行登入，如果错误他会抛出异常并被捕获
        getSubject(request, response).login(token);
    }

    private AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        log.info("create token");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String authorization = httpServletRequest.getHeader("Authorization");
        return new JWTToken(authorization);
    }

    private String getLocaleMessage(String code, Object... objects) {
        return messageSource.getMessage(code, objects, LocaleContextHolder.getLocale());
    }

}
