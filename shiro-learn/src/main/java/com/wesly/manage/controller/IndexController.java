package com.wesly.manage.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    private SecurityManager securityManager;

    @GetMapping
    public String index() {
        log.info(((DefaultWebSecurityManager)securityManager).getSessionManager().getClass().getName());
        return "index";
    }
}
