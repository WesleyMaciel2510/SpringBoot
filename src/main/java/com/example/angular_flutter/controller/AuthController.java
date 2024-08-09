package com.example.angular_flutter.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.angular_flutter.model.dto.LoginRequest;

@RestController
public class AuthController {

    private static final String EMAIL_TEST = "wesley@gmail.com";
    private static final String PASSWORD_TEST = "test123";

    @PostMapping("/api/auth")
    public boolean authenticate(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        System.out.println("Received login request:");
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

        // Mock authentication
        if (EMAIL_TEST.equals(email) && PASSWORD_TEST.equals(password)) {
            return true; // Authentication successful
        } else {
            return false; // Authentication failed
        }
    }
}
