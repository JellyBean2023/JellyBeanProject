package com.jellybean.api.service;

import com.jellybean.api.entity.User;
import com.jellybean.api.repository.RegistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistService {
    private final RegistRepository registRepository;

    @Autowired
    public RegistService(RegistRepository registRepository) {
        this.registRepository = registRepository;
    }

    public User saveUser(User user) {
        // 유저 등록
        return registRepository.save(user);
    }
}
