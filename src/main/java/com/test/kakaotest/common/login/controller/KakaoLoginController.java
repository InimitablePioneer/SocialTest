package com.test.kakaotest.common.login.controller;


import com.test.kakaotest.common.login.service.KakaoLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class KakaoLoginController {

    private final KakaoLoginService kakaoLoginService;

    @Value("${kakao.send-oauth-uri}")
    private String kakaoSendOauthUri;

    @Value("")

    @Value("${kakao.api_key}")
    private String kakaoApiKey;


    @GetMapping("/login")
    public String loginHome(Model model) {

        model.add
    }
}
