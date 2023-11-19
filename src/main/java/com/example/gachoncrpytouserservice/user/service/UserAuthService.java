package com.example.gachoncrpytouserservice.user.service;

import com.example.gachoncrpytouserservice.global.error.exception.ConflictException;
import com.example.gachoncrpytouserservice.global.error.exception.EntityNotFoundException;
import com.example.gachoncrpytouserservice.user.document.User;
import com.example.gachoncrpytouserservice.user.dto.request.UserSignInRequestDto;
import com.example.gachoncrpytouserservice.user.dto.request.UserSignUpRequestDto;
import com.example.gachoncrpytouserservice.user.dto.response.UserAuthResponseDto;
import com.example.gachoncrpytouserservice.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.gachoncrpytouserservice.global.error.ErrorCode.DUPLICATE_USER;
import static com.example.gachoncrpytouserservice.global.error.ErrorCode.USER_NOT_FOUND;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class UserAuthService {
    private final UserRepository userRepository;

    public UserAuthResponseDto signIn(UserSignInRequestDto userSignInRequestDto){
        User user = getUser(userSignInRequestDto.getStudentId());
        return UserAuthResponseDto.of(user.getId(), user.getName());
    }

    public UserAuthResponseDto signUp(UserSignUpRequestDto userSignUpRequestDto){
        validateDuplicateUser(userSignUpRequestDto.getStudentId());
        User user = saveUser(userSignUpRequestDto.getStudentId(), userSignUpRequestDto.getName());
        return UserAuthResponseDto.of(user.getId(), user.getName());
    }

    private void validateDuplicateUser(int studentId) {
        if (userRepository.existsByStudentId(studentId))
            throw new ConflictException(DUPLICATE_USER);
    }

    private User getUser(int studentId){
        return userRepository.findByStudentId(studentId)
                .orElseThrow(() -> new EntityNotFoundException(USER_NOT_FOUND));
    }

    private User saveUser(int studentId, String name) {
        User createdUser = User.createUser(studentId, name);
        userRepository.save(createdUser);
        return createdUser;
    }
}
