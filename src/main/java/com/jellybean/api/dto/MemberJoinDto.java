package com.jellybean.api.dto;

import com.jellybean.api.entity.MemberRole;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MemberJoinDto {

    private String name;
    private String email;
    private String password;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private boolean del;
    private LocalDate regDate;
    private MemberRole roleSet;

}
