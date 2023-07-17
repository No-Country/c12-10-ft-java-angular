package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.GenericResponseDTO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Get all users
    @GetMapping("/user")
    public ResponseEntity<?> listUser() {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", userService.listUser()));
    }

    // Get user by id
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id) {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", userService.getUserById(id)));
    }

    // Get user by userId
    @GetMapping("/user/userId/{userId}")
    public ResponseEntity<?> getUserByUserId(@PathVariable String userId) {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", userService.getUserByUserId(userId)));
    }

    // Post user
    @PostMapping("/user")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", userService.saveUser(user)));
    }

    // Update user
    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody User user) {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", userService.updateUser(id, user)));
    }

    // Delete user
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id) {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", userService.deleteUser(id)));
    }

}
