package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.GenericResponseDTO;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Get all users
    @GetMapping("/listAll")
    public ResponseEntity<?> listUser() {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", userService.listUser()));
    }

    // Get user by id
    @GetMapping("/userById/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id) {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", userService.getUserById(id)));
    }

    // Post user
    @PostMapping("/create")
    public ResponseEntity<?> saveUser(@RequestBody UserEntity user) {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", userService.saveUser(user)));
    }

    // Update user
    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody UserEntity user) {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", userService.updateUser(id, user)));
    }

    // Delete user
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id) {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", userService.deleteUser(id)));
    }

    // Login email and password
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserEntity user) {
        return ResponseEntity.ok().body(
                new GenericResponseDTO<>(true, "Success", userService.login(user.getEmail(), user.getPassword())));
    }
}
