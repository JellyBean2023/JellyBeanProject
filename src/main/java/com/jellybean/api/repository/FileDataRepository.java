package com.jellybean.api.repository;

import com.jellybean.api.entity.FileData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FileDataRepository extends JpaRepository<FileData, Long> {
    Optional<FileData> findByName(String fileName);
    List<FileData> findAll();
}