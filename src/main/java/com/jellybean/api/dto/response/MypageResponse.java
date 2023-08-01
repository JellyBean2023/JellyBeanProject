package com.jellybean.api.dto.response;

import com.jellybean.api.entity.Authority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MypageResponse {

    private String email;
    private String name;
    private String birth;
    private String phone;
    private Authority authority;
    private String employeeNumber;


}