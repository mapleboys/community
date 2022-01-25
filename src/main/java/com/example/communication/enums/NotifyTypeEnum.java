package com.example.communication.enums;

public enum NotifyTypeEnum {
    ReplyQuestionNotify("回复了问题", 0),
    ReplyCommentNotify("回复了评论", 1);
    private String action;
    private Integer type;
    NotifyTypeEnum(String action, Integer type) {
        this.action = action;
        this.type = type;
    }

    public String getAction() {
        return action;
    }

    public Integer getType() {
        return type;
    }

    public String getActionByType(Integer type) {
        for (NotifyTypeEnum value : NotifyTypeEnum.values()) {
            if (type == value.getType()) {
                return value.getAction();
            }
        }
        return "";
    }
}
