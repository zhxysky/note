package com.zhxy.note;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhxy on 2016/8/17.
 */
@Controller
public class PostAction {

    //https://springframework.guru/configuring-spring-boot-for-postgresql/

    @RequestMapping(value="/post/index")
    @ResponseBody
    public String index() {
        System.out.println("123");
        return "index";
    }

}
