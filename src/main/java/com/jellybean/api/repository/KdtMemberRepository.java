package com.jellybean.api.repository;

import com.jellybean.api.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KdtMemberRepository extends JpaRepository<Member, Long> {

}
