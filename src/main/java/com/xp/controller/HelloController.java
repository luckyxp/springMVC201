package com.xp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/test")
    public String test(){
        System.out.println("hello world!!!!!!");
        return "index";//会被视图解析器捕获
    }
    @RequestMapping("/test1")
    //http://localhost:8080/springMVC_04/hello/test1?str=哈哈哈
    public String test1(String str){
        System.out.println(str);
        return "view/hello";
    }
    @RequestMapping("/test2")
    //http://localhost:8080/springMVC_04/hello/test2?strs=1&strs=哈哈哈strs=kkkk
    public String test1(String[] strs){
        if (strs!=null) {
            for (String str : strs) {
                System.out.println(str);
            }
        }

        return "view/hello";
    }
}
