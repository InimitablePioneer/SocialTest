package com.test.kakaotest.common.login.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
public class KakaoLoginService {

    @Value("${kakao.token-uri}")
    private String tokenUri; //토큰을 요청하는 uri 이때 auth 코드와 함게 보내주어야한다

    @Value("${kakao.client-id}")
    private String clientId;

    @Value("${kakao.redirect_url}")
    private String redirectUri;

    public void login(String code) {

        getOauth(code);
    }

    public void getOauth(String code) {
        String url = tokenUri;

        //setting the Header
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("application/x-www-form-urlencoded;charset=UTF-8"));

        //send Oauth request to kakao server





    }

    private MultiValueMap<String, Object> setOauthBody(String code) {
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<String, Object>();
        body.add("grant_type", "authorization_code");
        body.add("client_id", clientId);
        body.add("redirect_uri", redirectUri);
        body.add("code", code);
        return body;
    }




}
