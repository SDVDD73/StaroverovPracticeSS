package com.chat.simbir.model.entity;

import org.springframework.security.core.GrantedAuthority;

public enum  RoleEnum implements GrantedAuthority {
    USER,
    ADMIN,
    MODERATOR,
    DELETE;

    @Override
    public String getAuthority() {
        return name();
    }
}