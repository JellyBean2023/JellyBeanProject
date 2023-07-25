package com.jellybean.api.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="FileData")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FileData {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String oriName;

    private String name;

    private String type;

    private String filePath;

    @Builder
    public FileData(String oriName, String name, String type, String filePath){
        this.oriName = oriName;
        this.name = name;
        this.type = type;
        this.filePath = filePath;
    }


}
