package com.jellybean.api.Vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class KdtAppRequest {
    private String name;
    private String email;
    private String phoneNumber;
    private String phoneNumberText;
    private LocalDate date;
    private boolean agreeCollect;
    private boolean agreeThirdParty;
    private String experience;
    private String experienceText;
    private String finalEducation;
    private String getCard;
    private String getEx;
    private String grade;
    private String pathText;
    private String paths;
    private String reason;
    private String recommend;
    private String id;
}
