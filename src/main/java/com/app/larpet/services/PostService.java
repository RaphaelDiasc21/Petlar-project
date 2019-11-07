package com.app.larpet.services;

import java.util.List;

import com.app.larpet.entities.Post;
import com.app.larpet.repositories.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PostService{

    @Autowired
    PostRepository pr;


    public void insert(Post post){
        pr.save(post);
    }

    public Page<Post> getAdocoes(){
        return pr.findByAdocoes(PageRequest.of(0, 10));
    }
}