package com.test.kakaotest.common.login.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.test.kakaotest.common.login.service.KakaoLoginService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class KakaoLoginController {

    private final KakaoLoginService kakaoLoginService;

    @Value("${kakao.send-oauth-uri}")
    private String kakaoSendOauthUri;

    @Value("${kakao.redirect_url}")
    private String redirectUri;

//    @Value("${kakao.api_key}")
//    private String kakaoApiKey;

    @Value("${kakao.javascript_key}")
    private String clientId;


    @GetMapping("/login")
    public String loginHome(Model model) {
        model.addAttribute("clientId", clientId);
        model.addAttribute("kakaoSendOauthUri", kakaoSendOauthUri);
        model.addAttribute("redirectUri", redirectUri);

        return "views/login";
    }

    @GetMapping("/login/kakao")
    public void login(@RequestParam("code") String authorizationCode, HttpServletRequest request) throws JsonProcessingException {
        kakaoLoginService.login(authorizationCode, request);

    }
}
