package com.xp.controller;

import com.alibaba.fastjson.annotation.JSONField;
import com.xp.pojo.User;
import com.xp.pojo.User1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/json")
public class JsonController {
    @RequestMapping("/test1")
    @ResponseBody //会把返回的对象转成json格式 无论是User还是集合String等等都会转成json返回
    public List<User1> test1() {
        return Arrays.asList(
                new User1(new Date(), 1, "张三", 18),
                new User1(new Date(), 2, "李四", 28));
    }
    @RequestMapping("/test2")
    @ResponseBody
    public List<User1> test2(@RequestBody List<User1> user1s) {
        for (User1 user1 : user1s) {
            System.out.println(user1.getDate()+"\t"+user1.getName()+"\t"+user1.getId()+"\t"+user1.getAge());
        }
        return user1s;
    }
}
