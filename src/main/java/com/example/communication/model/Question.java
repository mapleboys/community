package com.example.communication.model;

import lombok.Data;

import java.util.Date;

@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer commentAccount;
    private Integer viewAccount;
    private Integer likeAccount;
    private String tag;
}
