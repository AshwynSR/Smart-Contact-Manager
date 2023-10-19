package com.smart.smart_contact_manager.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.smart_contact_manager.dao.UserRepository;
import com.smart.smart_contact_manager.entities.User;
import com.smart.smart_contact_manager.helper.Message;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;
 
    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("title", "Home - Smart Contact Manager");
        return "home";
    }

    @RequestMapping("/about")
    public String about(Model model){
        model.addAttribute("title", "About - Smart Contact Manager");
        return "about";
    }

    @RequestMapping("/signup")
    public String signup(Model model){
        model.addAttribute("title", "Sign Up - Smart Contact Manager");
        model.addAttribute("user", new User());
        return "signup";
    }

    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("title", "Login - Smart Contact Manager");
        return "login";
    }

    @RequestMapping(value = "/do_register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") User user, @RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model){
        try {
            if(!agreement){
                System.out.println("You have not agreed to the terms and conditions!!");
                throw new Exception("You have not agreed to the terms and conditions!!");
            }
            user.setEnabled(true);
            System.out.println("Agreement = " + agreement);
            System.out.println("User = " + user);
            User result = this.userRepository.save(user);
            model.addAttribute("message", new Message("Successfully Registered!! ", "alert-success"));
            return "signup";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("user", user);
            return "signup";
        }
        
        
    }
}
