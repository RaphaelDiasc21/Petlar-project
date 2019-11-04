package com.app.larpet.controllers;

import com.app.larpet.entities.User;
import com.app.larpet.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController{

    @Autowired
    private UserService us;
    
    @RequestMapping("/registrar")
    public String register(Model m){
        
        m.addAttribute("User", new User());
    
        return "Registrar";
    }

    @PostMapping("/registrar-user")
    public String registerUser(@ModelAttribute("user") User user){
        us.registerUser(user);

        return "redirect:/registrar";
    }

    @GetMapping("/entrar")
    public String login(){
        return "Entrar";
    }

}