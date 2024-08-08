package com.example.angular_flutter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/api/hello")
    public String hello() {
        System.out.println("Hello, World!");
        return "Hello, World!";
    }
}