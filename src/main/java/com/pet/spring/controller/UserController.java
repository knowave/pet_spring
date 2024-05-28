package com.pet.spring.controller;

import com.pet.spring.dto.UserDto;
import com.pet.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("join")
    public ResponseEntity<String> join(@RequestBody UserDto.Request createUserDto) {
        userService.createUser(createUserDto);
        return ResponseEntity.ok().body("SUCCESS!");
    }
}
