package com.example.gachoncrpytouserservice.user.controller;

import com.example.gachoncrpytouserservice.global.common.SuccessResponse;
import com.example.gachoncrpytouserservice.user.dto.request.UserSignInRequestDto;
import com.example.gachoncrpytouserservice.user.dto.request.UserSignUpRequestDto;
import com.example.gachoncrpytouserservice.user.dto.response.UserAuthResponseDto;
import com.example.gachoncrpytouserservice.user.service.UserAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/user")
@RestController
public class UserApiController {
    private final UserAuthService userAuthService;

    @PostMapping("/signIn")
    public ResponseEntity<SuccessResponse<?>> signIn(@RequestBody final UserSignInRequestDto requestDto) {
        final UserAuthResponseDto responseDto = userAuthService.signIn(requestDto);
        return SuccessResponse.ok(responseDto);
    }

    @PostMapping("/signUp")
    public ResponseEntity<SuccessResponse<?>> signUp(@RequestBody final UserSignUpRequestDto requestDto) {
        final UserAuthResponseDto responseDto = userAuthService.signUp(requestDto);
        return SuccessResponse.created(responseDto);
    }
}
