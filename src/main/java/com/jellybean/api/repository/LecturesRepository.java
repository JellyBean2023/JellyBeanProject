package com.jellybean.api.repository;

import com.jellybean.api.entity.LecturesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LecturesRepository extends JpaRepository<LecturesEntity, Long> {

    Optional<LecturesEntity> findByLecName(String lecName);   //과정별

    Optional<LecturesEntity> findById(Long lecId);

    List<LecturesEntity> findAll();  //전체
}
