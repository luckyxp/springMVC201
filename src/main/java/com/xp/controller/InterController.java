package com.xp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

//测试拦截器
@RequestMapping("/inter")
@Controller
public class InterController {
    @RequestMapping("/test1")
    public String test1(){
        return "index";
    }
    @RequestMapping("/test2")
    public String test2(HttpSession session){
        return "index";
    }
}
