package com.example.angular_flutter.controller;

import com.example.angular_flutter.dto.LoginRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private static final String MOCK_EMAIL = "wesley@gmail.com";
    private static final String MOCK_PASSWORD = "test123";

    @PostMapping("/api/auth")
    public boolean authenticate(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        // Log the received email and password
        System.out.println("Received login request:");
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

        // Mock authentication
        if (MOCK_EMAIL.equals(email) && MOCK_PASSWORD.equals(password)) {
            return true; // Authentication successful
        } else {
            return false; // Authentication failed
        }
    }
}
