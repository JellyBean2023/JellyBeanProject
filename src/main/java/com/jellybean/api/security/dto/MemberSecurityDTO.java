package com.jellybean.api.security.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDate;
import java.util.Collection;

@Getter
@Setter
@ToString
public class MemberSecurityDTO extends User {

    private String name;
    private String email;
    private String password;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private boolean del;

    public MemberSecurityDTO(String username, String email, String password, LocalDate dateOfBirth, String phoneNumber, boolean del
                           , Collection<? extends GrantedAuthority> authorities){
        super(username, password, authorities);

        this.name = username;
        this.password = password;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.del = del;
    }



}
