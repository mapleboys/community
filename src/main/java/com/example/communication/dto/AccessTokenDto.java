package com.example.communication.dto;

import lombok.Data;

@Data
public class AccessTokenDto {
    String client_id;
    String client_secret;
    String code;
    String redirect_uri;

}
