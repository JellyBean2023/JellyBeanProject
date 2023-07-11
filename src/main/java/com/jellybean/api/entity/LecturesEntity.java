package com.jellybean.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lectures")
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LecturesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecId", nullable = false)
    private Long lecId;

    @Column(name = "lecStatus", length = 100, nullable = false)
    private String lecStatus;

    @Column(name = "lecName", length = 200, nullable = false)
    private String lecName;

    @Column(name = "cardinalName", length = 100, nullable = false)
    private String cardinalName;

    @Column(name = "lecInfo", length = 500, nullable = false)
    private String lecInfo;
}
