package com.pet.spring.controller;

import com.pet.spring.dto.UserDto;
import com.pet.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Controller
public class UserController {
    private UserService userService;

    @PostMapping("/users/join")
    public ResponseEntity<String> join(@RequestBody UserDto.Request createUserDto) {
        userService.createUser(createUserDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("SUCCESS!");
    }
}
