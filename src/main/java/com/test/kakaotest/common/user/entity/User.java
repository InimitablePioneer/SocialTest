package com.test.kakaotest.common.user.entity;

import lombok.Data;

import java.util.Map;
import java.util.UUID;

@Data
public class User {
    private Long userNum;


    //uuid 값 어케 줄건지 생각해보기
    private String uuid;

    //OAuth data
    private Long providerId;
    private String profileUrl;
    private String providerNickname;

    private String type; //social login type that user use

    public User(Map<String,Object> userInfo, String type) {
        this.uuid = UUID.randomUUID().toString();
        Map<String,Object> properties = (Map<String,Object>)userInfo.get("properties");
        this.providerId = (Long)properties.get("providerId");
        this.providerNickname = properties.get("providerNickname").toString();
        this.profileUrl = properties.get("profile_image").toString();
        this.type = type;
    }




}
