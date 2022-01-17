package com.example.communication.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode{
    QuestionNotFound("问题找不到了，换个问题试试吧！！！", 2022),
    UserNotFound("用户未登录，请后登录继续操作", 2023),
    CommentTypeNotFound("回复类型未知", 2024);
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
