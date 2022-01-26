package com.example.communication.dto;

import lombok.Data;

@Data
public class UploadResDto {
    private Integer success;
    private String message;
    private String url;
}
