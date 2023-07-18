package com.jellybean.api.repository;

import com.jellybean.api.entity.Member;
import com.jellybean.api.entity.MemberRole;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.stream.IntStream;

@Log4j2
public class MemberRepositoryTests {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void insertMembers(){
        IntStream.rangeClosed(1,100).forEach(i -> {
            Member member = Member.builder()
                    .name("name" + i)
                    .password(passwordEncoder.encode("1111"))
                    .email("email" + i + "@aaa.bbb")
                    .build();
            member.addRole(MemberRole.USER);

            if(i >= 90){
                member.addRole(MemberRole.ADMIN);
            }

            memberRepository.save(member);

        });
    }

    @Test
    public void testRead(){
        Optional<Member> result = memberRepository.getWithRoles("name100");

        Member member = result.orElseThrow();

        log.info(member);
        log.info(member.getRoleSet());

        member.getRoleSet().forEach(memberRole -> log.info(memberRole.name()));
    }


}
