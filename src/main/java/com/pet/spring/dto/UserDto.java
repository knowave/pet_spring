package com.pet.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class UserDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request {
        private String username;
        private String email;
        private String password;
        private String phoneNumber;
        private String profileImage;
        private String introduction;
    }
}
