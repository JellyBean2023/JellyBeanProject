package com.jellybean.api.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="birth", nullable = false)
    private String birth;

    @Column(name="phone", nullable = false)
    private String phone;

    @Column(name="createdAt", nullable = false)
    private LocalDateTime createdAt;

    @Column(name="registCheck", nullable = false)
    private String registCheck;

    @Column(name="employeeNumber", nullable = true)
    private String employeeNumber;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public Member(String name, String email, String password, String birth, String phone,
                  LocalDateTime createdAt, String registCheck, String employeeNumber, Authority authority) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.birth = birth;
        this.phone = phone;
        this.createdAt = createdAt;
        this.registCheck = registCheck;
        this.employeeNumber = employeeNumber;
        this.authority = authority;
        this.createdAt = LocalDateTime.now();
    }
}
