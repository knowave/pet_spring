package com.pet.spring.global.security.jwt.dto;

import com.pet.spring.global.constant.Role;

public record AccessTokenDto(
        Long userId,
        Role role,
        String token
) {
}
