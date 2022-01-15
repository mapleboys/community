package com.example.communication.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode{
    QuestionNotFound("问题找不到了，换个问题试试吧！！！");
    private String message;
    CustomizeErrorCode(String s) {
        this.message = s;
    }
    @Override
    public String getMsg() {
        return null;
    }
}
