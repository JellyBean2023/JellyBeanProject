package com.jellybean.api.repository;

import com.jellybean.api.entity.RegistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface RegistRepository extends JpaRepository<RegistEntity, Long> {

    Optional<RegistEntity> findByemail(String email);   //이름별
    List<RegistEntity> findAll();  //전체

}
