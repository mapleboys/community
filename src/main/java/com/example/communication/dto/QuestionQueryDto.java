package com.example.communication.dto;

import lombok.Data;

@Data
public class QuestionQueryDto {
    private Integer limit;
    private Integer offset;
    private String search;
}
