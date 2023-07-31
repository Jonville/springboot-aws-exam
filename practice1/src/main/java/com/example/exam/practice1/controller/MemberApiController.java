package com.example.exam.practice1.controller;

import com.example.exam.practice1.model.Member;
import com.example.exam.practice1.model.dto.AddMemberRequest;
import com.example.exam.practice1.model.dto.LoginRequest;
import com.example.exam.practice1.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class MemberApiController {
    private final MemberService memberService;

    // 실제 회원가입 등록
    @PostMapping("/user")
    public String signup(AddMemberRequest request) {
        memberService.register(request);
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String login(LoginRequest request) {
        Member member = memberService.login(request);
            return "redirect:/success"; // 로그인 성공 시 성공 페이지로 리다이렉트

    }

}
