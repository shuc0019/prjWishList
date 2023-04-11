package com.example.prjwishlist.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/")
    public String login(String username, String password, Model model) {
        if (username.equals("hej") && password.equals("hej")){
            return "wishlit";
        } else {
            model.addAttribute("lol", "Din login er forkert");
        }
        return "index";
    }


}
