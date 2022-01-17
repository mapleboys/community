package com.example.communication.exception;

public class CustomizeErrorException extends RuntimeException {

    private String message;
    private Integer code;

    public CustomizeErrorException(CustomizeErrorCode error) {
        this.message = error.getMsg();
        this.code = error.getCode();
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
