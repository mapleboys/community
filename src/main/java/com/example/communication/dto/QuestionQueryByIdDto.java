package com.example.communication.dto;

import lombok.Data;

@Data
public class QuestionQueryByIdDto {
    private Integer rows;
    private Integer offset;
    private Integer creator;
}
