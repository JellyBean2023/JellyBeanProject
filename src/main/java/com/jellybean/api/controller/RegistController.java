package com.jellybean.api.controller;

import com.jellybean.api.Vo.UserRequest;
import com.jellybean.api.entity.RegistEntity;
import com.jellybean.api.service.AlreadyExistException;
import com.jellybean.api.service.RegistService;

import com.jellybean.api.service.RegistrationException;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/regist")
public class RegistController {
    private final RegistService registService;

    @PostMapping("")
    public String register(@RequestBody UserRequest request) throws IOException {
        try {
            return registService.register(request);
        } catch (AlreadyExistException e) {
            throw new RuntimeException(e);
        } catch (RegistrationException e) {
            throw new RuntimeException(e);
        }
    }
}

    /*
    @PostMapping("")
    public ResponseEntity<RegistEntity> save(@RequestBody RegistEntity user) throws IOException {
        RegistEntity savedUser = registService.register(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    } */
/*
    @GetMapping("/{name}")    //이름별 조회
    public ResponseEntity<Optional<RegistEntity>>
    getRegistByName(@PathVariable("name") String name) throws IllegalAccessException {
        Optional<RegistEntity> user = registService.getRegistByName(name);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/users")    //모든 유저 조회
    public ResponseEntity<List<RegistEntity>>
    getusers() throws IllegalAccessException {
        List<RegistEntity> users = registService.getusers();
        return ResponseEntity.ok().body(users);
    }
}
*/
/*

    public RegistController(RegistService registService) {
        this.registService = registService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User registUser = registService.saveUser(user);
        return new ResponseEntity<>(registUser, HttpStatus.CREATED);
    }

 */

