package com.jellybean.api.repository;

import com.jellybean.api.entity.Authority;
import com.jellybean.api.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);
    boolean existsByEmail(String email);

}
