package com.chat.simbir.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

public enum Role implements GrantedAuthority {
    USER,
    ADMIN,
    MODERATOR,
    DELETE;

    @Override
    public String getAuthority() {
        return name();
    }
}


