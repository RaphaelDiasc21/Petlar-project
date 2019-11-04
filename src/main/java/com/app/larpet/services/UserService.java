package com.app.larpet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.app.larpet.entities.User;
import com.app.larpet.repositories.UserRepository;;
@Service
public class UserService{

    @Autowired
    private UserRepository ur;

    @Autowired
    PasswordEncoder bcrypt;

    public void registerUser(User user){
        Optional<User> u = ur.findById(1);
        
        if(!u.isEmpty()){
            System.out.println(u.get().getSenha());
        }
        String user_password_raw = user.getSenha();
        String final_password = bcrypt.encode(user_password_raw);
        user.setSenha(final_password);
        ur.save(user);
    }
}