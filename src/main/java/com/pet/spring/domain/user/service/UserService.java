package com.pet.spring.domain.user.service;

import com.pet.spring.domain.user.dto.UserDto;
import com.pet.spring.domain.user.repository.UserRepository;
import com.pet.spring.global.constant.Role;
import com.pet.spring.global.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Transactional
    public void createUser(UserDto.Request createUserDto) {
        if (userRepository.existsByEmail(createUserDto.getEmail())) {
            throw new CustomException("이미 존재하는 이메일입니다.", HttpStatus.BAD_REQUEST);
        }
        createUserDto.setPassword(encoder.encode(createUserDto.getPassword()));
        createUserDto.setRole(Role.CLIENT);
        userRepository.save(createUserDto.toEntity());
    }

}
