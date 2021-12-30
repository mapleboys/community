package com.example.communication.dto;

import com.example.communication.model.User;
import lombok.Data;

@Data
public class QuestionDto {
    private Integer id;
    private String title;
    private String description;
    private String gmtCreate;
    private String gmtModified;
    private Integer creator;
    private Integer commentAccount;
    private Integer viewAccount;
    private Integer likeAccount;
    private String tag;
    private User user;
}
