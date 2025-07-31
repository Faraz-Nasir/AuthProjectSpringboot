package com.example.jwt.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.jwt.Entities.UserRegisterEntity;
import com.example.jwt.Repositories.UserRegisterEntityRepository;

@Service
public class UserRegisterEntityService {
    @Autowired
    UserRegisterEntityRepository userRegisterEntityRepository;

    public UserRegisterEntity loadUserByUsername(String username) throws UsernameNotFoundException{
            return userRegisterEntityRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User Not Found"));
    }
    public UserRegisterEntity save(UserRegisterEntity userRegisterEntity){
        return userRegisterEntityRepository.save(userRegisterEntity);
    }
}
