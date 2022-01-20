package com.example.communication.dto;

import com.example.communication.exception.CustomizeErrorCode;
import lombok.Data;

@Data
public  class ResultDto<T> {
    private Integer retCode;
    private String retMsg;
    private T data;

    public static ResultDto errorOf(CustomizeErrorCode customizeErrorCode) {
        ResultDto resultDto = new ResultDto();
        resultDto.setRetCode(customizeErrorCode.getCode());
        resultDto.setRetMsg(customizeErrorCode.getMsg());
        return resultDto;
    }

    public static ResultDto okOf() {
        ResultDto resultDto = new ResultDto();
        resultDto.setRetCode(200);
        resultDto.setRetMsg("请求成功");
        return resultDto;
    }

    public static <T>ResultDto okOf(T data) {
        ResultDto resultDto = new ResultDto();
        resultDto.setRetCode(200);
        resultDto.setRetMsg("请求成功");
        resultDto.setData(data);
        return resultDto;
    }
}
