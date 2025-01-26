package com.test.kakaotest.common.user.service;

import com.test.kakaotest.common.user.entity.User;
import com.test.kakaotest.common.user.repository.jdbctemplate.UserJdbcRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    private final UserJdbcRepository userJdbcRepository;

    public UserService(UserJdbcRepository userJdbcRepository) {
        this.userJdbcRepository = userJdbcRepository;
    }

    public void saveUser(User user) {
        userJdbcRepository.save(user);
    }



}
