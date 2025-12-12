package com.smarttravel.user_service.service;



import com.smarttravel.user_service.dto.CreateUserRequest;
import com.smarttravel.user_service.dto.UserResponse;
import java.util.List;

public interface UserService {
    UserResponse createUser(CreateUserRequest request);
    UserResponse getUserById(Long id);
    UserResponse getUserByEmail(String email);
    List<UserResponse> getAllUsers();
}

