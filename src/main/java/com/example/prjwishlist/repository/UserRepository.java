package com.example.prjwishlist.repository;


import com.example.prjwishlist.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate template;

    public void addUser(User user) {
        String sql = "INSERT INTO users (username, userpassword) VALUES (?, ?)";
        template.update(sql, user.getUsername(), user.getUserpassword());
    }

    public User findUserByUsernameAndPassword(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND userpassword = ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        List<User> users = template.query(sql, rowMapper, username, password);
        if (users.size() == 1) {
            return users.get(0);
        } else {
            return null;
        }
    }

    public boolean doesTheUserExist(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        List<User> users = template.query(sql, rowMapper, username);
        return !users.isEmpty();
    }

}