package com.ticket.transport.common;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN,
    COMPANY,
    USER;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
