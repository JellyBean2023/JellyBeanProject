package com.jellybean.api.repository;

import com.jellybean.api.entity.LecturesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LecturesRepository extends JpaRepository<LecturesEntity, Long> {

    Optional<LecturesEntity> findByLecName(String lecName);
}
