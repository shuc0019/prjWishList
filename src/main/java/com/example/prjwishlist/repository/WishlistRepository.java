package com.example.prjwishlist.repository;

import com.example.prjwishlist.model.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class WishlistRepository {
    @Autowired
    JdbcTemplate template;

    public List<Wishlist> fetchAll(String username){
        String sql = "SELECT * FROM wishlists where username=?";
        RowMapper<Wishlist> rowMapper = new BeanPropertyRowMapper<>(Wishlist.class);
        List<Wishlist> wishlists = template.query(sql,rowMapper,username);
        return wishlists;
    }

}
