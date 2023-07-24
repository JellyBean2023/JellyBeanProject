package com.jellybean.api.controller;

import com.jellybean.api.Vo.UserRequest;
import com.jellybean.api.service.AlreadyExistException;
import com.jellybean.api.service.RegistService;
import com.jellybean.api.service.RegistrationException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

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