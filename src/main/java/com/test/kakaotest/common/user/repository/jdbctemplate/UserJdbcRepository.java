package com.test.kakaotest.common.user.repository.jdbctemplate;

import com.test.kakaotest.common.user.entity.User;
import com.test.kakaotest.common.user.repository.UserRepository;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UserJdbcRepository implements UserRepository {//implement crud

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public UserJdbcRepository(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }


    @Override
    public User save(User user) {
        String sql = "insert into users(uuid, provider_id, profile_url, provider_nickname)"
                + " values(:uuid, :providerId, :profileUrl, :providerNickname)";

        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(user);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, sqlParameterSource, keyHolder);

        long key = keyHolder.getKey().longValue();
        user.setUserNum(key);
        return user;
    }



}
