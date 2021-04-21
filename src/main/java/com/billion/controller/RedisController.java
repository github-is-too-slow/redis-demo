package com.billion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.WebParam;

/**
 * @author Billion
 * @create 2021/04/15 23:57
 */
@Controller
public class RedisController {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/")
    public String setRedisContent(Model model){
        System.out.println("请求首页");
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set("username", "Jack");
        ops.set("age", "18");
        ops.set("email", "jack@qq.com");
        model.addAttribute("username", ops.get("username"));
        model.addAttribute("age", ops.get("age"));
        model.addAttribute("email", ops.get("email"));
        return "index";
    }
}
