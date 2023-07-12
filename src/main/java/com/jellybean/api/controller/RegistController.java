package com.jellybean.api.controller;

import com.jellybean.api.entity.User;
import com.jellybean.api.service.RegistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/regist")
public class RegistController {
    private final RegistService registService;

    @Autowired
    public RegistController(RegistService registService) {
        this.registService = registService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User registUser = registService.saveUser(user);
        return new ResponseEntity<>(registUser, HttpStatus.CREATED);
    }
}

