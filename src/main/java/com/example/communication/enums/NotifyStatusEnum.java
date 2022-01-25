package com.example.communication.enums;

public enum NotifyStatusEnum {
    read(1),
    unread(0);
    private Integer value;
    NotifyStatusEnum(Integer value) {
        this.value = value;
    }
    public Integer getValue() {
        return value;
    }
}
