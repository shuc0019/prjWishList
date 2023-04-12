package com.example.prjwishlist.repository;


import com.example.prjwishlist.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addUser(User user) {
        String sql = "INSERT INTO users (username, userpassword) VALUES (?, ?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getUserpassword());
    }


}