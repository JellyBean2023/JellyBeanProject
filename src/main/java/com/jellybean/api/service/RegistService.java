package com.jellybean.api.service;

import com.jellybean.api.Vo.UserRequest;
import com.jellybean.api.entity.RegistEntity;
import com.jellybean.api.repository.RegistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class RegistService {
    @Autowired
    private RegistRepository registRepository;

    public String register(UserRequest request) throws AlreadyExistException, RegistrationException {
        try {
            registRepository.save(
                    RegistEntity.builder()
                            .name(request.getName())
                            .password(request.getPassword())
                            .confirmPassword(request.getConfirmPassword())
                            .phone(request.getPhone())
                            .email(request.getEmail())
                            .birthday(LocalDate.parse(request.getBirthday()))
                            .registCheck(request.getRegistCheck())
                            .type(request.getType())
                            .employeeNumber(request.getEmployeeNumber())
                            .build()
            );
            return "Success";
        } catch (DataIntegrityViolationException e) {
            throw new AlreadyExistException("User with the same name or email already exists", e);
        } catch (Exception e) {
            throw new RegistrationException("Registration failed due to an unexpected error", e);
        }
    }
}
/*
    // 이름별 유저 조회
    public Optional<RegistEntity> getRegistByName(String name) throws IllegalAccessException {
        Optional<RegistEntity> user = registRepository.findByname(name);
        if( !user.isEmpty()) {
            return user;
        }
        else {
            throw new IllegalAccessException("no user found with the given name");
        }
    }

    //모든 유저 조회
    public List<RegistEntity> getusers() throws IllegalAccessException {
        List<RegistEntity> users = registRepository.findAll();

        if(!users.isEmpty()) return registRepository.findAll();
        else throw new IllegalAccessException("no such data");
    }

}*/
    /*
    public RegistEntity register(RegistEntity registEntity) {
        RegistEntity user = new RegistEntity();
        user.setName(registRepository.getName());
        user.setPassword(registRepository.getPassword());
        user.setConfirmPassword(registRepository.getConfirmPassword());
        user.setPhone(registRepository.getPhone());
        user.setBirthday(registRepository.getBirthday());
        user.setEmail(registRepository.getEmail());
        user.setRegistCheck(registRepository.getRegistCheck());
        return registRepository.save(user);
    }

     */

