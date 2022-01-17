package com.example.communication.dto;

import lombok.Data;

@Data
public class CommentDto {
    private String content;
    private Long parentId;
    private Integer type;
}
