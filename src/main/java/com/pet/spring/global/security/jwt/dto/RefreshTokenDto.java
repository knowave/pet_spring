package com.pet.spring.global.security.jwt.dto;

public record RefreshTokenDto(
        Long userId,
        String token
) {
}
