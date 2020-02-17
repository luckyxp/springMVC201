package com.xp.controller;

import com.xp.exception.LoginException;
import com.xp.exception.PermissionException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/exception")
@Controller
public class ExceptionController {
    @RequestMapping("/loginException")
    public String loginException() {
        return "view/login_error";
    }
    @RequestMapping("/permissionException")
    public String permissionException() {
        return "view/perm_error";
    }

    @RequestMapping("/unknownException")
    public String unknownException() {
        return "view/all_error";
    }

    //测试异常
    @RequestMapping("/test1")
    public String test1() {
        if (1 == 1)
            throw new LoginException();
        return null;
    }
    @RequestMapping("/test2")
    public String test2() {
        if (1 == 1)
            throw new PermissionException();
        return null;
    }
    @RequestMapping("/test3")
    public String test3() {
        System.out.println(1/0);
        return null;
    }
}
