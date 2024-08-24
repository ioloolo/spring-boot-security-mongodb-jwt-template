package com.github.ioloolo.template.domain.auth.exception;

import com.github.ioloolo.template.common.api.exception.ApiException;
import org.springframework.http.HttpStatus;

public class AccessTokenExpiredException extends ApiException {

    public AccessTokenExpiredException() {

        super(HttpStatus.UNAUTHORIZED, "액세스 토큰이 만료되었습니다.");
    }
}
