package com.jellybean.api.service;

import com.jellybean.api.entity.Member;
import com.jellybean.api.entity.MemberRole;
import com.jellybean.api.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RegisterMemberService {

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    public RegisterMemberService(PasswordEncoder passwordEncoder, MemberRepository memberRepository){
        this.passwordEncoder = passwordEncoder;
        this.memberRepository = memberRepository;
    }

    public String join(String name, String email, String password, LocalDate dateOfBirth, String phoneNumber, boolean del, LocalDate regDate, MemberRole roleSet){
        Member member = Member.createMember(name, email, password, passwordEncoder, dateOfBirth, phoneNumber, del, regDate, roleSet);
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getEmail();
    }

    private void validateDuplicateMember(Member member){
        memberRepository.findByEmail(member.getEmail())
                .ifPresent(m->{
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                });

    }

}
