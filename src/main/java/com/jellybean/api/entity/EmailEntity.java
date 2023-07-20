package com.jellybean.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "emailcode")
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emailNo", nullable = false)
    private Long emailNo;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "code", length = 100, nullable = false)
    private String code;

    @Column(name = "createAt", length = 100, nullable = false)
    private String createAt;

    @Column(name = "updateAt", length = 100, nullable = true)
    private String updateAt;
}
