package com.example.prjwishlist.Controller;

import com.example.prjwishlist.model.User;
import com.example.prjwishlist.model.Wishlist;
import com.example.prjwishlist.repository.UserRepository;
import com.example.prjwishlist.repository.WishlistRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    WishlistRepository wishlistRepository;

    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping("/loginAccount")
    public String login() {

            return "login";
        }



    // Validate login information
    @PostMapping("/loginAccount")
    public String loginAccount( String username,  String userpassword, Model model, HttpSession session) {
        User user = userRepository.findUserByUsernameAndPassword(username, userpassword);
        if (user != null){
            session.setAttribute("username", username);
            return "loginconfirm";
        } else {
            model.addAttribute("lol", "Din login er forkert ");
            return "login";
        }
    }
    @GetMapping("/index")
    public String index(Model model,HttpSession session){
        String username = (String) session.getAttribute("username");
        model.addAttribute("username", username);
        List<Wishlist> wishlists = wishlistRepository.fetchAll(username);
        model.addAttribute("wishlists", wishlists);
        return "index";
    }

    // redirect to main page
    @GetMapping("/createAccount")
    public String createAccount() {
        return "createAccount";
    }

    // create new account
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
                model.addAttribute("succes", "Account created!!!!");
                return "login";
            }
        }
    }

    @GetMapping("/create")
    public String create(HttpSession session, RedirectAttributes redirectAttributes, Model model){
        String username = (String) session.getAttribute("username");
        model.addAttribute("username", username);
        return "create";
    }
    @PostMapping("/createNewUser")
    public String createNew(@ModelAttribute Wishlist wishlist, Model model,HttpSession session, RedirectAttributes redirectAttributes){
        String username = (String) session.getAttribute("username");
        model.addAttribute("username", username);
        wishlistRepository.addPerson(wishlist);
        return "redirect:/index";
    }

    @GetMapping("/deleteOne/{wishlists_id}")
    public String deleteOne(@PathVariable("wishlists_id") int wishlists_id){
        boolean deleted = wishlistRepository.deleteWish(wishlists_id);
        if (deleted){
            return "redirect:/index";
        }else {
            return "redirect:/index";
        }
    }

}