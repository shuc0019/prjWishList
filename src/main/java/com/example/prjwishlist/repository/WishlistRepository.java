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

    public void addItem(Wishlist p){

        String sql = "INSERT INTO wishlists (wishlists_id,username, wishlist_title, product_name, product_price, product_link)" +
                " VALUES(?,?,?,?,?,?)";
        template.update(sql,p.getWishlists_id(),p.getUsername(), p.getWishlist_title(),p.getProduct_name(),p.getProduct_price(),p.getProduct_link());
    }
    public Boolean deleteWish(int wishlists_id){
        String sql = "DELETE FROM wishlists WHERE wishlists_id = ?";
        return template.update(sql, wishlists_id) > 0;
    }



    public Wishlist findWishByID (int wishlist_id){
        String sql = "SELECT * FROM wishlists WHERE wishlists_id = ?";
        RowMapper<Wishlist >rowMapper=new BeanPropertyRowMapper<>(Wishlist.class);
        Wishlist w = template.queryForObject(sql,rowMapper,wishlist_id);

        return w;
    }

    public void updateWish(int wishlist_id, Wishlist w){
        String sql = "UPDATE wishlists SET username = ?, " +
                "wishlist_title = ?, product_name = ?, product_price = ?, product_link = ? WHERE wishlists_id = ?";

        template.update(sql,w.getUsername(),w.getWishlist_title(),w.getProduct_name(),w.getProduct_price(),
                w.getProduct_link(),w.getWishlists_id());
    }






}
