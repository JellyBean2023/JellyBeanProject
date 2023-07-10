package com.jellybean.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello(){
        return "백엔드 git 7/3 연결^_^_^^_^_^ 구현은 낼부터~~~";
    }

}
