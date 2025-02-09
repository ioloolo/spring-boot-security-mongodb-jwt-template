package com.github.son_daehyeon.template.domain.auth.exception;

import org.springframework.http.HttpStatus;

import com.github.son_daehyeon.template.common.api.exception.ApiException;

public class AlreadyRegisteredEmailException extends ApiException {

    public AlreadyRegisteredEmailException() {

        super(HttpStatus.CONFLICT, "이미 가입된 유저입니다.");
    }
}
