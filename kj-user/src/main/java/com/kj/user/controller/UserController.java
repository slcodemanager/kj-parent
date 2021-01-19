package com.kj.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 胡耀东
 * @version 1.0
 * Description:
 * @date 2021/1/15 17:44
 */
@Controller
public class UserController {

    @GetMapping("login")
    @ResponseBody
    public String login(){
        return "返回成功";
    }
}
