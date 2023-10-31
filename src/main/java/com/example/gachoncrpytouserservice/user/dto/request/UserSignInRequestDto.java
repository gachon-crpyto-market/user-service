package com.example.gachoncrpytouserservice.user.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserSignInRequestDto {
    private int studentId;
}
