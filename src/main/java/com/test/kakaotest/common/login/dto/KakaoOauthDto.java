package com.test.kakaotest.common.login.dto;

import lombok.Getter;

@Getter
public class KakaoOauthDto {
    private String access_token;
    private String token_type;
    private String refresh_token;
    private Integer expires_in;
    private String scope;
    private Integer refresh_token_expires_in;
}
