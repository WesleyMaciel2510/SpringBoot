package com.example.angular_flutter.controller;

import com.example.angular_flutter.model.User;
import com.example.angular_flutter.model.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private Map<Long, User> userDatabase = new HashMap<>();
    private Long idCounter = 2L;  // Start from 2 since 1 is used for mock data

    // Initialize with a mock user
    public UserController() {
        User mockUser = new User(1L, "Wesley Maciel", "wesley@gmail.com", "test");
        userDatabase.put(mockUser.getId(), mockUser);
    }

    @GetMapping("/{id}")
    public ApiResponse<User> getUser(@PathVariable Long id) {
        User user = userDatabase.get(id);
        if (user != null) {
            return new ApiResponse<>(true, "User found", user);
        } else {
            return new ApiResponse<>(false, "User not found", null);
        }
    }

    @PostMapping
    public ApiResponse<User> createUser(@RequestBody User user) {
        user.setId(idCounter++);
        userDatabase.put(user.getId(), user);
        return new ApiResponse<>(true, "User created successfully", user);
    }

    @PutMapping("/{id}")
    public ApiResponse<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        if (userDatabase.containsKey(id)) {
            user.setId(id);
            userDatabase.put(id, user);
            return new ApiResponse<>(true, "User updated successfully", user);
        }
        return new ApiResponse<>(false, "User not found", null);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteUser(@PathVariable Long id) {
        if (userDatabase.remove(id) != null) {
            return new ApiResponse<>(true, "User deleted successfully", null);
        }
        return new ApiResponse<>(false, "User not found", null);
    }
}
