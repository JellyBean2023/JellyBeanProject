package com.jellybean.api.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    private String email;

    private String password;

    private String birth;

    private String phone;

    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public Member(String name, String email, String password, String birth, String phone,
        LocalDateTime createdAt, Authority authority) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.birth = birth;
        this.phone = phone;
        this.authority = authority;
        this.createdAt = LocalDateTime.now();
    }
}
