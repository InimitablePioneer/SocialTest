package com.test.kakaotest.common.user.entity;

import java.util.Map;
import java.util.UUID;

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



    }




}
