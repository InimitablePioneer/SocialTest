package com.test.kakaotest.common.login.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

@Service
public class KakaoLoginService {

    @Value("${kakao.token-uri}")
    private String tokenUri; //토큰을 요청하는 uri 이때 auth 코드와 함게 보내주어야한다

    public void login(String code) {
        getOauth(code);
    }

    public void getOauth(String code) {
        String url = tokenUri;

        //setting the Header
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType

    }


}
