package com.jellybean.api.repository;

import com.jellybean.api.entity.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);

    @EntityGraph(attributePaths = "roleSet")
//    @EntityGraph(value = "Member.withRoles", type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT m FROM Member m left join fetch m.roleSet WHERE m.email = :email")
    Optional<Member> getWithRoles(String email);

    boolean existsByEmail(String email);
}
