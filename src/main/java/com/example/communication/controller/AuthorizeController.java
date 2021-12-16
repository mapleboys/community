package com.example.communication.controller;

import com.example.communication.dto.AccessTokenDto;
import com.example.communication.dto.GithubUser;
import com.example.communication.provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AuthorizeController {

    @Autowired
    private GitHubProvider gitHubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state) {
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setClient_id("2bcd63e763491ab33831");
        accessTokenDto.setCode(code);
        accessTokenDto.setRedirect_uri("http://localhost:8887/callback");
        accessTokenDto.setClient_secret("5fe5be9b000bb422d77c9c769921ed3290778093");
        String accessToken = gitHubProvider.getAccessToken(accessTokenDto);
        GithubUser user = gitHubProvider.getUser(accessToken);
        return "index";
    }
}
