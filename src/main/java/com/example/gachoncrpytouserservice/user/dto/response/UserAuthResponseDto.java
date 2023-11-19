package com.example.gachoncrpytouserservice.user.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserAuthResponseDto {
    private String id;
    private String name;

    public static UserAuthResponseDto of(String userId, String name){
        return UserAuthResponseDto.builder()
                .id(userId)
                .name(name)
                .build();
    }
}
