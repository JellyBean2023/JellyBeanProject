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
public class KdtMemberRequest {

        private String email;

        public Member toKdtMember() {
            return Member.builder()
                    .email(email)
                    .build();
        }

}
