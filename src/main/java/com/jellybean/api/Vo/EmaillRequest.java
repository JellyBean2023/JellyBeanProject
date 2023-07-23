package com.jellybean.api.Vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class EmaillRequest {
    private String email;
    private String code;
}
