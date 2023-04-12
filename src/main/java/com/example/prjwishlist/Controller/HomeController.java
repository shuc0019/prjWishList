package com.example.prjwishlist.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "login";
    }

    @PostMapping("/")
    public String login(String username, String password, Model model) {
        if (username.equals("hej") && password.equals("hej")){
            return "loginconfirm";
        } else {
            model.addAttribute("lol", "Din login er forkert ");
        }
        return "login";
    }

    // redirect to main page
    @GetMapping("/index")
    public String login() {
        return "index";
    }


}
