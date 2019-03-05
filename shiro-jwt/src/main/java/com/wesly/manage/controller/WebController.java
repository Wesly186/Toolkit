package com.wesly.manage.controller;

import com.wesly.manage.bean.CommonResult;
import com.wesly.manage.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Slf4j
@RestController
public class WebController {

    private UserService userService;

    @Autowired
    public void setService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public CommonResult login(@RequestParam("username") String username, @RequestParam("password") String password) {
        String token = userService.login(username, password);
        return CommonResult.resultOK("success", token);
    }

    @GetMapping("book")
    @ResponseBody
    @RequiresPermissions(value = {"book:select"})
    public CommonResult getBook() {
        return CommonResult.resultOK("success", new ArrayList<>());
    }
}
