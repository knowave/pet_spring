package com.pet.spring.global.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    CLIENT("ROLE_CLIENT", "일반"),
    ADMIN("ROLE_ADMIN", "관리자");

    private final String key;
    private final String title;

    public static Role findByKey(String key) {
        for (Role role : Role.values()) {
            if (role.getKey().equals(key)) {
                return role;
            }
        }
        throw new IllegalArgumentException("NO Role With Key: " + key);
    }
}
