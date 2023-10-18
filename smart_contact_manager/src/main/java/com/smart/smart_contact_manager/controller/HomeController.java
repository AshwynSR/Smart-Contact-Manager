package com.smart.smart_contact_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smart.smart_contact_manager.dao.UserRepository;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;
 
    @RequestMapping("/home")
    public String home(Model model){
        model.addAttribute("title", "Home - Smart Contact Manager");
        return "home";
    }

    @RequestMapping("/about")
    public String about(Model model){
        model.addAttribute("title", "About - Smart Contact Manager");
        return "about";
    }
}
