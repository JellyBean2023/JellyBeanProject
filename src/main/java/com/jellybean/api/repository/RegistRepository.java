package com.jellybean.api.repository;

import com.jellybean.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RegistRepository extends JpaRepository<User, Long> {

}
