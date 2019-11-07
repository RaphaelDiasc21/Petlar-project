package com.app.larpet.controllers;

import java.util.List;

import com.app.larpet.entities.Post;
import com.app.larpet.services.PostService;
import com.app.larpet.util.UserDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
        List<Post> posts = ps.getAdocoes().getContent();

        for(Post p : posts){
            System.out.println(p.getTitulo());
            System.out.println(p.getTipo_post());
        }
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
        UserDetail user = (UserDetail)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        m.addAttribute("post", new Post());
        m.addAttribute("username_id", user.getId());
        m.addAttribute("username", user.getUsername());
       
        return "Post-inserir";
    }

    @PostMapping("/post-inserir")
    public String postInsert(@ModelAttribute("post") Post post){
        ps.insert(post);

        return "redirect:/post-inserir";
    }

        
}