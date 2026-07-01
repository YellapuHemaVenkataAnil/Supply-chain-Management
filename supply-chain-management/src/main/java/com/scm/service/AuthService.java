package com.scm.service;

import com.scm.dto.AuthResponse;
import com.scm.dto.LoginRequest;
import com.scm.dto.SignupRequest;
import com.scm.model.User;
import com.scm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public AuthResponse signup(SignupRequest request) {
        // Check if user already exists
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        // Create new user
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // In production, use BCrypt to hash password
        user.setRole(User.UserRole.USER);

        User savedUser = userRepository.save(user);

        return new AuthResponse(
            savedUser.getId(),
            savedUser.getName(),
            savedUser.getEmail(),
            savedUser.getRole().toString(),
            "User registered successfully"
        );
    }

    public AuthResponse login(LoginRequest request) {
        Optional<User> userOptional = userRepository.findByEmail(request.getEmail());

        if (userOptional.isEmpty()) {
            throw new RuntimeException("Invalid email or password");
        }

        User user = userOptional.get();

        // Check password (in production, use BCrypt to compare hashed password)
        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        return new AuthResponse(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getRole().toString(),
            "Login successful"
        );
    }

    public void createAdminUser() {
        // Check if admin already exists
        if (!userRepository.existsByEmail("admin@scm.com")) {
            User admin = new User();
            admin.setName("Admin");
            admin.setEmail("admin@scm.com");
            admin.setPassword("admin123"); // Change this in production
            admin.setRole(User.UserRole.ADMIN);
            userRepository.save(admin);
        }
    }
}