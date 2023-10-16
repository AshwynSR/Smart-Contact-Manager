package com.smart.smart_contact_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.smart_contact_manager.dao.UserRepository;
import com.smart.smart_contact_manager.entities.Contact;
import com.smart.smart_contact_manager.entities.User;

@RestController
public class HomeController {

    @Autowired
    private UserRepository userRepository;
 
    @GetMapping("/test")
    public String test(){
        User user = new User();
        user.setName("Ashwin");
        user.setEmail("ashwinrathore@gmail.com");
        Contact contact = new Contact();
        user.getContacts().add(contact);
        userRepository.save(user);
        return "working!!";
    }
}
