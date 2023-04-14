package com.example.prjwishlist.model;

public class Wishlist {

    private int wishlists_id;
    private String username;
    private String wishlist_title;
    private String product_name;
    private double product_price;
    private String product_link;

    public Wishlist(){

    }

    public Wishlist(int wishlists_id, String username, String wishlist_title, String product_name, double product_price, String product_link) {
        this.wishlists_id = wishlists_id;
        this.username = username;
        this.wishlist_title = wishlist_title;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_link = product_link;
    }

    public int getWishlists_id() {
        return wishlists_id;
    }

    public void setWishlists_id(int wishlists_id) {
        this.wishlists_id = wishlists_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWishlist_title() {
        return wishlist_title;
    }

    public void setWishlist_title(String wishlist_title) {
        this.wishlist_title = wishlist_title;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public String getProduct_link() {
        return product_link;
    }

    public void setProduct_link(String product_link) {
        this.product_link = product_link;
    }
}
