package com.app.larpet.services;

import com.app.larpet.entities.Post;
import com.app.larpet.repositories.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService{

    @Autowired
    PostRepository pr;


    public void insert(Post post){
        pr.save(post);
    }
}