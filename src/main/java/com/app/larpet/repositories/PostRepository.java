package com.app.larpet.repositories;

import com.app.larpet.entities.Post;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostRepository extends PagingAndSortingRepository<Post, Integer>{
    
}