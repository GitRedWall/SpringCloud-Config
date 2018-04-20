package com.ilabservice.intelab.common;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
    private final HttpStatus status;
    private final String message;
    private final ErrorCode code;

    protected ErrorResponse(final String message, final ErrorCode code, HttpStatus httpStatus){
        this.message = message;
        this.code = code;
        this.status = httpStatus;
    }

    public static ErrorResponse of(final String message, final ErrorCode errorCode, HttpStatus status){
        return new ErrorResponse(message, errorCode, status);
    }

    public Integer getStatus(){
        return status.value();
    }

    public String getMessage(){
        return message;
    }

    public ErrorCode getCode(){
        return code;
    }

}
