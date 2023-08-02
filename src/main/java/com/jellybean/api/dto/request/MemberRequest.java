package com.jellybean.api.dto.request;

import com.jellybean.api.entity.Authority;
import com.jellybean.api.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequest {

    private String email;
    private String password;
    private String name;
    private String birth;
    private String phone;
    private String registCheck;
    private String employeeNumber;
    private String authority;

    public Member toMember(PasswordEncoder passwordEncoder) {
        Authority authorityEnum = Authority.valueOf(authority);
        return Member.builder()
            .email(email)
            .password(passwordEncoder.encode(password))
            .authority(authorityEnum)
            .name(name)
            .birth(birth)
            .phone(phone)
            .employeeNumber(employeeNumber)
            .registCheck(registCheck)
            .build();
    }

    public Member toMember() {
        Authority authorityEnum = Authority.valueOf(authority);
        return Member.builder()
                .email(email)
                .authority(authorityEnum)
                .name(name)
                .birth(birth)
                .phone(phone)
                .employeeNumber(employeeNumber)
                .registCheck(registCheck)
                .build();
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }



}