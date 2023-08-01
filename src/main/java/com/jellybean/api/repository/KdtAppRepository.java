package com.jellybean.api.repository;

import com.jellybean.api.entity.KdtAppEntitiy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KdtAppRepository extends JpaRepository<KdtAppEntitiy, Long> {


    KdtAppEntitiy findByEmail(String email);
}
