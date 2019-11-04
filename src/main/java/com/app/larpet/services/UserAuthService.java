package com.app.larpet.services;

import com.app.larpet.entities.User;
import com.app.larpet.repositories.UserRepository;
import com.app.larpet.util.UserDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService implements UserDetailsService{

    @Autowired
    UserRepository ur;

    @Override
    public UserDetails loadUserByUsername(String email)	throws UsernameNotFoundException{
        User user = ur.findByEmail(email);
        
        if(user == null){
            throw new UsernameNotFoundException("Usuário não encontrado !");
        }

        return new UserDetail(user);

    }
}