package com.example.jwt.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt.Entities.UserRegisterEntity;
import com.example.jwt.Services.UserRegisterEntityService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class UserController {
    
    @Autowired
    UserRegisterEntityService userRegisterEntityService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/user-register")
    public ResponseEntity<String> register(@RequestBody UserRegisterEntity userRegisterEntity){
        userRegisterEntity.setPassword(passwordEncoder.encode(userRegisterEntity.getPassword()));

        userRegisterEntityService.save(userRegisterEntity);
        return ResponseEntity.ok("User Registered Successfully");
    }
    
}
