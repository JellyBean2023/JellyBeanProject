package com.jellybean.api.repository;

import com.jellybean.api.entity.KdtAppEntitiy;
import com.jellybean.api.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KdtAppRepository extends JpaRepository<KdtAppEntitiy, Long> {


}
