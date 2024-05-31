package com.pet.spring.domain.user.controller;

import com.pet.spring.domain.user.dto.UserDto;
import com.pet.spring.domain.user.entity.User;
import com.pet.spring.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody UserDto.Request createUserDto) {
        userService.createUser(createUserDto);
        return ResponseEntity.ok().body("SUCCESS!");
    }

    @GetMapping("")
    public ResponseEntity<User> getUserById(@RequestParam Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok().body(user);
    }
}