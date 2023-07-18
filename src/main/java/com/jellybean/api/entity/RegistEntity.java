package com.jellybean.api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "user")
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userNo", nullable = false)
    private Long userNo;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "password", length = 200, nullable = false)
    private String password;

    @Column(name = "confirmPassword", length = 200, nullable = false)
    private String confirmPassword;

    @Column(name = "phone", length = 100, nullable = false)
    private String phone;

    @Column(name = "email", length = 200, nullable = false)
    private String email;

    @Column(name = "birthday", length = 100, nullable = false)
    private LocalDate birthday;

    @Column(name = "registCheck", length = 100, nullable = false)
    private String registCheck;

    @Column(name = "type", length = 100, nullable = true)
    private String type;

    @Column(name = "employeeNumber", length = 100, nullable = true)
    private String employeeNumber;
}
