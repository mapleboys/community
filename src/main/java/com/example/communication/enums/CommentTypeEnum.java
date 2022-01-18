package com.example.communication.enums;

public enum CommentTypeEnum {
    QUESTION(0),
    COMMENT(1);

    private Integer type;
    CommentTypeEnum(int type) {
        this.type = type;
    }

    //是否是规定类型
    public static boolean isType(Integer type) {
        for (CommentTypeEnum value : CommentTypeEnum.values()) {
            if (value.type.equals(type)) {
                return true;
            }
        }
        return false;
    }

}
