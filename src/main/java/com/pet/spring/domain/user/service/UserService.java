package com.pet.spring.service;

import com.pet.spring.dto.UserDto;
import com.pet.spring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
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
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }
        createUserDto.setPassword(encoder.encode(createUserDto.getPassword()));
        userRepository.save(createUserDto.toEntity());
    }

}