package com.zhxy.note.controller;

import com.zhxy.note.entities.Users;
import com.zhxy.note.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.spring4.dialect.SpringStandardDialect;

import java.util.Date;
import java.util.Map;

/**
 * Created by zhxy on 2016/9/1.
 */

@RequestMapping
//@RestController
@Controller
public class UsersController {
    @Autowired
    UsersRepository usersRepository;

    @RequestMapping("/index")
    public String index(Map<String,Object> map) {
        map.put("hello", "Hello Thymeleaf");
        map.put("today", new Date());
        return "index";
    }


    /**
     * 默认返回json格式数据
     * @return
     */
    @RequestMapping("/users/{id}")
    @ResponseBody
    public Users getUsers(@PathVariable String id) {
        System.out.println("id:"+id);
        return usersRepository.getById(Integer.parseInt(id));
    }
}
