package com.example.prjwishlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication

public class PrjWishListApplication {
    public static void main(String[] args) {
        SpringApplication.run(PrjWishListApplication.class, args);
    }

}
