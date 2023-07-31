package com.example.exam.practice1.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AddMemberRequest {
    private String email;
    private String password;
}
