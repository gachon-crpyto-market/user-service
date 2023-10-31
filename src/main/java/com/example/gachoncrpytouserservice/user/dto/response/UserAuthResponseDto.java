package com.example.gachoncrpytouserservice.user.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserAuthResponseDto {
    private String id;

    public static UserAuthResponseDto of(String userId){
        return UserAuthResponseDto.builder()
                .id(userId)
                .build();
    }
}
