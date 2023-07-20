package com.jellybean.api.repository;

import com.jellybean.api.entity.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmailRepository extends JpaRepository<EmailEntity, Long> {
    Optional<EmailEntity> findByemail(String email);   //이메일별
    List<EmailEntity> findAll();  //전체

}
