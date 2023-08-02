package com.jellybean.api.dto.response;

import com.jellybean.api.dto.TokenDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TokenResponse {
    private TokenDto tokenDto;
    private boolean isAdmin;


}
