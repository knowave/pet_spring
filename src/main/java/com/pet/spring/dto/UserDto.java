package com.pet.spring.dto;

import com.pet.spring.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
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
        @Email(message = "이메일 형식이 올바르지 않습니다.")
        @NotEmpty(message = "이메일을 입력해주세요.")
        private String email;

        @NotEmpty(message = "이름을 입력해주세요")
        @Pattern(regexp = "^[가-힣a-zA-Z]{2,10}$", message = "이름은 한글, 영문 2~10자로 입력해주세요")
        private String username;

        @NotEmpty(message = "닉네임을 입력해주세요")
        @Pattern(regexp = "^[가-힣a-zA-Z]{2,20}$", message = "닉네임은 한글, 영문 2~20자로 입력해주세요")
        private String nickname;

        @NotEmpty(message = "비밀번호를 입력해주세요")
        @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$", message = "비밀번호는 영문 대소문자, 숫자, 특수문자를 포함한 8~20자로 입력해주세요")
        private String password;

        @NotEmpty(message = "전화번호를 입력해주세요")
        @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$", message = "전화번호 형식에 맞게 입력해주세요")
        private String phoneNumber;

        private String profileImage;

        private String introduction;

        public User toEntity() {
            User user = User.builder()
                    .email(email)
                    .username(username)
                    .nickname(nickname)
                    .password(password)
                    .phoneNumber(phoneNumber)
                    .profileImage(profileImage)
                    .introduction(introduction)
                    .build();
            return user;
        }
    }
}
