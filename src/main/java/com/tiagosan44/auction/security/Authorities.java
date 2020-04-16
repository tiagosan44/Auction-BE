package com.tiagosan44.auction.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.EnumSet;

@AllArgsConstructor
@Getter
public enum Authorities implements GrantedAuthority {

    ADMIN("ROLE_ADMIN", (short) 1),
    USER("ROLE_USER", (short) 2),
    ANONYMOUS("ROLE_ANONYMOUS", (short) 3);

    private final String name;

    private final Short index;

    @Override
    public String getAuthority() {
        return this.getName();
    }

    public static String[] getNonAnonymousUsers() {
        final EnumSet<Authorities> authorities = EnumSet.allOf(Authorities.class);
        authorities.remove(Authorities.ANONYMOUS);
        return authorities.stream()
            .map(Authorities::getName)
            .toArray(String[]::new);
    }
}

