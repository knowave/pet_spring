package com.pet.spring.global.security.jwt.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jwt")
public record JwtProperties(
        String accessTokenSecret,
        String refreshTokenSecret,
        Long accessTokenExpirationTime,
        Long refreshTokenExpirationTime,
        String issuer
) {
    public Long accessTokenExpirationMilliTime() {
        return accessTokenExpirationTime * 1000;
    }

    public Long refreshTokenExpirationMilliTime() {
        return refreshTokenExpirationTime * 1000;
    }
}
