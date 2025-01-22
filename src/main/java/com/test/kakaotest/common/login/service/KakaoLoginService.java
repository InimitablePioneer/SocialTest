package com.test.kakaotest.common.login.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.kakaotest.common.login.dto.KakaoOauthDto;
import com.test.kakaotest.common.user.entity.User;
import com.test.kakaotest.common.util.RestApiRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;

@Service
public class KakaoLoginService {

    @Value("${kakao.token-uri}")
    private String tokenUri; //토큰을 요청하는 uri 이때 auth 코드와 함게 보내주어야한다

    @Value("${kakao.client-id}")
    private String clientId;

    @Value("${kakao.redirect_url}")
    private String redirectUri;

    @Value("${kakao.userinfo-url}")
    private String userInfoUri;

    public void login(String code) throws JsonProcessingException {

        //request a token to kakao server with authorization code -> and get a token
        KakaoOauthDto oauth = getOauth(code);
        Map<String,Object> userInfo = getUserInfo(oauth);







    }

    public KakaoOauthDto getOauth(String code) throws JsonProcessingException {
        String url = tokenUri;

        //setting the Header
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("application/x-www-form-urlencoded;charset=UTF-8"));

        //send Oauth request to kakao server
        String response = RestApiRequest.request(HttpMethod.POST, url, setOauthBody(code), headers);

        //parsing the response that we got from kakao server
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        return objectMapper.readValue(response, KakaoOauthDto.class);

    }

    private MultiValueMap<String, Object> setOauthBody(String code) {
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<String, Object>();
        body.add("grant_type", "authorization_code");
        body.add("client_id", clientId);
        body.add("redirect_uri", redirectUri);
        body.add("code", code);
        return body;
    }

    private Map<String,Object> getUserInfo(KakaoOauthDto oauth) throws JsonProcessingException {
        String url = userInfoUri;
        //set the Header
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("application/x-www-form-urlencoded;charset=UTF-8"));
        headers.set("Authorization", "Bearer" + oauth.getAccess_token());
        //send request to kakao server with token in order to get a user information
        String response = RestApiRequest.request(HttpMethod.POST,url,null,headers);
        //Parsing the response that we got
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);

        return objectMapper.readValue(response, Map.class);

    }

    private void saveUser(Map<String,Object> userInfo) {
        User user = new User(userInfo, "kakao");
        if () {
        }


    }






}
