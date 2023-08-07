package com.jellybean.api.dto;

import com.jellybean.api.dto.request.MemberRequest;
import com.jellybean.api.entity.Authority;
import com.jellybean.api.repository.MemberRepository;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenDto {

    private String grantType;
    private String accessToken;
    private String refreshToken;
    private Long accessTokenExpiresIn;


}
