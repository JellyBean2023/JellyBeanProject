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

    public Member toMember(PasswordEncoder passwordEncoder) {
        return Member.builder()
            .email(email)
            .password(passwordEncoder.encode(password))
            .authority(Authority.ROLE_MEMBER)
            .name(name)
            .birth(birth)
            .phone(phone)
            .build();
    }

    public Member toMember() {
        return Member.builder()
                .email(email)
                .authority(Authority.ROLE_MEMBER)
                .name(name)
                .birth(birth)
                .phone(phone)
                .build();
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }
}