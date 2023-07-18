package com.jellybean.api.repository;

import com.jellybean.api.entity.RegistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface RegistRepository extends JpaRepository<RegistEntity, Long> {

    Optional<RegistEntity> findByname(String name);   //이름별
    List<RegistEntity> findAll();  //전체

}
