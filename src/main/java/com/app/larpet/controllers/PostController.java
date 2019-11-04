package com.app.larpet.controllers;

import com.app.larpet.entities.Post;
import com.app.larpet.services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController{

    @Autowired
    PostService ps;

    @GetMapping("/adocoes")
    public String adocoes(){
        return "Adocoes";
    }

    @GetMapping("/encontrados")
    public String encontrados(){
        return "Encontrados";
    }

    @GetMapping("/perdidos")
    public String perdidos(){
        return "Perdidos";
    }

    @GetMapping("/post-inserir")
    public String index(Model m){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        m.addAttribute("post", new Post());
        m.addAttribute("username", principal.getClass().getName());
        return "Post-inserir";
    }

    @PostMapping("/post-inserir")
    public String postInsert(@ModelAttribute("post") Post post){
        ps.insert(post);

        return "redirect:/post-inserir";
    }

        
}