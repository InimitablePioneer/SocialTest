package com.test.kakaotest.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class RestApiRequest {
    public static String request(HttpMethod method, String url, MultiValueMap<String, Object> body, HttpHeaders headers) {
        RestTemplate restTemplate = new RestTemplate();
        //request Message
        HttpEntity<?> requestMessage = new HttpEntity<>(body, headers);
        //request to kakao server by post method that we made already
        HttpEntity<String> response = restTemplate.postForEntity(url, requestMessage, String.class);
        // parsing the response that we get from kakao server
        ObjectMapper objectMapper = new ObjectMapper();



    }

}
