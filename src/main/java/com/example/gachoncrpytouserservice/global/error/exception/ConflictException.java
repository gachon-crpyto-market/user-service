package com.example.gachoncrpytouserservice.global.error.exception;

import com.example.gachoncrpytouserservice.global.error.ErrorCode;

public class ConflictException extends BusinessException {
    public ConflictException(ErrorCode errorCode) {
        super(errorCode);
    }
}
