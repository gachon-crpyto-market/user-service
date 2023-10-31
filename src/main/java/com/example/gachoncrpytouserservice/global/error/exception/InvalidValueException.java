package com.example.gachoncrpytouserservice.global.error.exception;

import com.example.gachoncrpytouserservice.global.error.ErrorCode;

public class InvalidValueException extends BusinessException {
    public InvalidValueException() {
        super(ErrorCode.BAD_REQUEST);
    }

    public InvalidValueException(ErrorCode errorCode) {
        super(errorCode);
    }
}
