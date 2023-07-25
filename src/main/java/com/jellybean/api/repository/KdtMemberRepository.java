package com.jellybean.api.repository;

import com.jellybean.api.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KdtMemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByEmail(String email);

}
