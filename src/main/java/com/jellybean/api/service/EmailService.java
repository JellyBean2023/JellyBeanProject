package com.jellybean.api.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;


@Component
@Repository
@RestController
@Controller
@Service
public interface EmailService {
    void saveEmailCode(String email, String code);
    String sendSimpleMessage(String to)throws Exception;

}
