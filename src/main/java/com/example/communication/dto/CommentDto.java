package com.example.communication.dto;

import com.example.communication.model.User;
import lombok.Data;

@Data
public class CommentDto {
    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer likeCount;
    private String content;
    private Integer commentCount;
    private User user;
}
