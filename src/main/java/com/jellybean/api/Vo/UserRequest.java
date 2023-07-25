package com.jellybean.api.Vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class UserRequest {
    private String name;
    private String password;
    private String phone;
    private String email;
    private String birthday;
    private String registCheck;
    private String type;
    private String employeeNumber;
}
