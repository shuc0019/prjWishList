package com.example.prjwishlist.Controller;

import com.example.prjwishlist.model.User;
import com.example.prjwishlist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String index(){
        User user = new User();
        user.setUsername("scucayb");
        user.setUserpassword("hejlool");
        userRepository.addUser(user);
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
    @GetMapping("/createAccount")
    public String createAccount() {
        return "createAccount";
    }

    @PostMapping("/accountCreated")
    public String signupconfirm(){
        return "signupconfirm";
    }


}
