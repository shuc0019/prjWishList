package com.example.prjwishlist.Controller;

import com.example.prjwishlist.model.User;
import com.example.prjwishlist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String index(){

        return "login";
    }

    @PostMapping("/")
    public String login(String username, String userpassword, Model model) {
        User user = userRepository.findUserByUsernameAndPassword(username, userpassword);
        if (user != null){
            return "loginconfirm";
        } else {
            model.addAttribute("lol", "Din login er forkert ");
            return "login";
        }
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
    @PostMapping("/createNew")
    public String createNew(String confirm_password, Model model, @ModelAttribute User user, RedirectAttributes redirectAttributes) {
        if (userRepository.doesTheUserExist(user.getUsername())) {
            model.addAttribute("forkert", "Brugernavn allerede i brug");
            return "createAccount";
        } else {
            if (!user.getUserpassword().equals(confirm_password)) {
                model.addAttribute("forkert", "Koden matcher ikke");
                return "createAccount";
            } else {
                userRepository.addUser(user);
                redirectAttributes.addFlashAttribute("succes", "Account created!!!!");
                return "redirect:/";
            }
        }
    }


}