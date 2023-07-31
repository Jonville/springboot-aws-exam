package com.example.exam.practice1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberViewController {

    // 로그인 페이지로 이동
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/success")
    public String user() {
        return "success";
    }

    // 회원가입 페이지로 이동
    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

}
