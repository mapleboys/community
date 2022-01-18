package com.example.communication.dto;

import com.example.communication.model.User;
import lombok.Data;

@Data
public class QuestionDto {
    private Long id;
    private String title;
    private String description;
    private Long gmtCreate;
    private Long gmtModified;
    private Long creator;
    private Integer commentAccount;
    private Integer viewAccount;
    private Integer likeAccount;
    private String tag;
    private User user;
}
