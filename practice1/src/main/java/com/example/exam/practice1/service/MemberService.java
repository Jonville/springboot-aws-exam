package com.example.exam.practice1.service;

import com.example.exam.practice1.model.Member;
import com.example.exam.practice1.model.dto.AddMemberRequest;
import com.example.exam.practice1.model.dto.LoginRequest;
import com.example.exam.practice1.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public Long register(AddMemberRequest dto) {
        return memberRepository.save(
                Member.builder()
                        .email(dto.getEmail())
                        .password(dto.getPassword())
                        .build()
        ).getId();
    }

    public Member login(LoginRequest loginRequest) {
        // email에 일치하는 user의 모든 정보를 가져온다
        Optional<Member> optUser = memberRepository.findByEmail(loginRequest.getEmail());
        if (optUser.isPresent()) {
            Member member = optUser.get();
            // email과 password가 매칭되는 경우 로그인 성공
            if (loginRequest.getEmail().equals(member.getEmail()) &&
                    loginRequest.getPassword().equals(member.getPassword())) {
                return member; // 로그인 성공시 해당 멤버 정보를 반환
            }
        }
        return null; // 로그인 실패시 null 반환
    }

}
