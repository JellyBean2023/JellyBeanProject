package com.jellybean.api.dto;

import com.jellybean.api.entity.Member;
import com.jellybean.api.entity.MemberRole;

import java.time.LocalDate;
import java.util.Set;

public class MemberDto {

    private String name;
    private String email;
    private String password;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private Set<MemberRole> roleSet;

    // DTO -> Entity
    public Member toEntity(){
        Member user = Member.builder()
                .name(name)
                .email(email)
                .password(password)
                .dateOfBirth(dateOfBirth)
                .phoneNumber(phoneNumber)
                .roleSet(roleSet)
                .build();
        return user;
    }


}
