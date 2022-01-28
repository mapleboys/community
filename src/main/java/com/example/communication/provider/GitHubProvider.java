package com.example.communication.provider;

import com.alibaba.fastjson.JSON;
import com.example.communication.dto.AccessTokenDto;
import com.example.communication.dto.GithubUser;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.stereotype.Component;



@Component
@Slf4j
public class GitHubProvider {
    public String getAccessToken(AccessTokenDto accessTokenDto) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDto));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String str = response.body().string();
            String[] split = str.split("&");
            String[] tokenStr = split[0].split("=");
            String accessToken = tokenStr[1];
            log.info("return string:" + str);
            log.info("accessToken:" + accessToken);
            return accessToken;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public GithubUser getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user")
                .addHeader("Authorization", "token " + accessToken)
                .build();
        try{
            Response response = client.newCall(request).execute();
            String str = response.body().string();
            log.info("str:" + str);
            GithubUser githubUser = JSON.parseObject(str, GithubUser.class);
            log.info("githubUser：" + githubUser);
            return githubUser;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }
}
