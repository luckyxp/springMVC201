package com.xp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/jump")
public class JumpController {
    //默认是转发
    @RequestMapping("test1")
    public String test1() {
        System.out.println("转发到hello.jsp");
        return "view/hello";
    }

    //也可以使用 "forward" 关键词  一旦使用关键词 就要把路径写全
    @RequestMapping("test2")
    public String test2() {
        System.out.println("转发到hello.jsp");
        return "forward:/view/hello.jsp";
    }

    //"redirect" 关键词 表示重定向
    @RequestMapping("test3")
    public String test3() {
        System.out.println("重定向到hello.jsp");
        return "redirect:/view/hello.jsp";
    }
    /*
    转发和重定向的选择:
        转发:网址不发生改变,如果刷新页面就会重新发起请求
        重定向:网址改变,如果刷新页面并不会再次发起请求
        总结:在做增删改操作时,使用重定向,这样就不会因为用户刷新页面导致重复的增删改
            而在做查询的时候,用户更希望,刷新一次就重新查询一次,所以查询使用转发

        拓展:一般增删改查操作都是在C完成的,数据的渲染展示都是在V完成的
             一般增删改操作之后会接一个查询,此操作是 C --> C ,而增删改
             使用重定向,所以可以类推,C --> C 一般使用重定向, C --> V
             使用转发
             以上拓展并不是必然的 但绝大多数情况是这样
     */
    @RequestMapping("/test4")
    public String test4(HttpSession session) {
        session.setAttribute("user", "用户1");
        return "redirect:/inter/test1";
    }
}
