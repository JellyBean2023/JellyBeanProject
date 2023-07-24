package com.jellybean.api.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Authority {

    ROLE_MEMBER("ROLE_MEMBER"),
    ROLE_ADMIN("ROLE_ADMIN");

    private final String value;

}
