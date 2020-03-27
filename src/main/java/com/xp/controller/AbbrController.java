package com.xp.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/abbr")
public class AbbrController {
    @RequestMapping("/test1")
    public String test1(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
        req.setAttribute("name", "张三");
        session.setAttribute("年龄", 18);
        return "view/user";
    }
    //通过spring内置的Model类传值,使用于V为非jsp的情况,实现C V解耦的思想
    @RequestMapping("/test2")
    public String test2(Model model, HttpSession session) {
        model.addAttribute("name", "李四");
        session.setAttribute("年龄", 38);
        return "view/user";
    }
    //前面的 其实spring底层会把用户数据封装成一个ModelAndView 下面其实是帮spring提前封装好了一个modeAndView
    @RequestMapping("/test3")
    public ModelAndView test3() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "王五");
        modelAndView.setViewName("view/user");
        return modelAndView;
    }

}
