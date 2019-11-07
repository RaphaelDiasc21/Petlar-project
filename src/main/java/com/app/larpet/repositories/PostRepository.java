package com.app.larpet.repositories;

import java.util.List;

import com.app.larpet.entities.Post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends PagingAndSortingRepository<Post, Integer>{
    
    @Query(value="select * from POST Where tipo_post='Adocao'",nativeQuery = true)
    Page<Post> findByAdocoes(Pageable p);
}