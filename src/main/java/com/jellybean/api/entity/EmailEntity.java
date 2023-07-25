package com.jellybean.api.entity;

import lombok.*;

import javax.persistence.*;

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

}
