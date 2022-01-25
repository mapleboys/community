package com.example.communication.dto;

import lombok.Data;

@Data
public class NotificationDto {
    private Long id;
    private Long notifier;
    private Long receiver;
    private Long outerid;
    private Integer type;
    private Long gmtCreate;
    private Integer status;
    private String notifierName;
    private String outertitle;
    private String notifyAction;
}
