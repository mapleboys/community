package com.example.communication.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode{
    QuestionNotFound("问题找不到了，换个问题试试吧！！！", 2022);
    private String message;
    private Integer code;
    CustomizeErrorCode(String s, Integer code) {
        this.message = s;
        this.code = code;
    }
    @Override
    public String getMsg() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
