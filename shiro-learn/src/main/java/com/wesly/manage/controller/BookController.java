package com.wesly.manage.controller;

import com.wesly.manage.bean.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Slf4j
@Controller
@RequestMapping("book")
public class BookController {

    @GetMapping("index")
    public String book(HttpServletRequest request) {
        return "/book/index";
    }

    @GetMapping
    @ResponseBody
    @RequiresPermissions(value = {"book:select"})
    public CommonResult getBook() {
        return CommonResult.resultOK("success", new ArrayList<>());
    }

    @PostMapping
    @ResponseBody
    @RequiresPermissions(value = {"book:add"})
    public CommonResult addBook() {
        return CommonResult.resultOK("success", null);
    }

    @PatchMapping
    @ResponseBody
    @RequiresPermissions(value = {"book:update"})
    public CommonResult updateBook() {
        return CommonResult.resultOK("success", null);
    }

    @DeleteMapping("{bookId}")
    @ResponseBody
    @RequiresPermissions(value = {"book:delete"})
    public CommonResult updateBook(@PathVariable String bookId) {
        return CommonResult.resultOK("success", null);
    }
}
