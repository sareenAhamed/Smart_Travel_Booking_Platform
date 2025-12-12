package com.smarttravel.user_service.controller;


import com.smarttravel.user_service.dto.CreateUserRequest;
import com.smarttravel.user_service.dto.UserResponse;
import com.smarttravel.user_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody CreateUserRequest request) {
        UserResponse response = userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers(@RequestParam(value = "email", required = false) String email) {
        if (email != null && !email.isBlank()) {
            return ResponseEntity.ok(List.of(userService.getUserByEmail(email)));
        }
        return ResponseEntity.ok(userService.getAllUsers());
    }
}

