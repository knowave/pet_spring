package com.pet.spring.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import java.util.Set;

@Entity()
public class User extends BaseEntity {
    @Column(length = 100, unique = true, nullable = false)
    @Email(message = "이메일 형식이 올바르지 않습니다.")
    @NotEmpty(message = "이메일을 입력해주세요.")
    private String email;

    @Column(length = 10, nullable = false)
    @NotEmpty(message = "이름을 입력해주세요")
    @Pattern(regexp = "^[가-힣a-zA-Z]{2,10}$", message = "이름은 한글, 영문 2~10자로 입력해주세요")
    private String username;

    @Column(nullable = false, length = 20)
    @NotEmpty(message = "닉네임을 입력해주세요")
    @Pattern(regexp = "^[가-힣a-zA-Z]{2,20}$", message = "닉네임은 한글, 영문 2~20자로 입력해주세요")
    private String nickname;

    @Column(nullable = false)
    @NotEmpty(message = "비밀번호를 입력해주세요")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$", message = "비밀번호는 영문 대소문자, 숫자, 특수문자를 포함한 8~20자로 입력해주세요")
    private String password;

    @Column(nullable = false, length = 100)
    @NotEmpty(message = "전화번호를 입력해주세요")
    @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$", message = "전화번호 형식에 맞게 입력해주세요")
    private String phoneNumber;

    @Column(columnDefinition = "TEXT")
    private String profileImage;

    @Column(length = 255)
    private String token;

    @Column(length = 100)
    private String introduction;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Feed> feeds;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments;
}
