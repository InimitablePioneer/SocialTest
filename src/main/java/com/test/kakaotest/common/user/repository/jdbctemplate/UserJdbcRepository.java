package com.test.kakaotest.common.user.repository.jdbctemplate;

import com.test.kakaotest.common.user.entity.User;
import com.test.kakaotest.common.user.repository.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserJdbcRepository implements UserRepository {//implement crud


    @Override
    public User save(User user) {

    }



}
