package com.example.demo.controller;

import java.io.Console;
import java.util.List;
import java.util.Optional;

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
import com.example.demo.repository.UserRepository;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    // Get all users
    @GetMapping("/user")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", userRepository.findAll()));
        // return userRepository.findAll();
    }

    // Get user by id
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id) {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", userRepository.findById(id)));
        // return userRepository.findById(id);
    }

    // Get user by name
    @GetMapping("/user/name/{name}")
    public ResponseEntity<?> getUsuarioByName(@PathVariable String name) {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", userRepository.findByName(name)));
        // return userRepository.findByName(name);
    }

    // Create user
    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", userRepository.save(user)));
        // return userRepository.save(user);
    }

    // Update user
    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody User user) {
        user.setUser_id(id);
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", userRepository.save(user)));

        // return userRepository.save(user);
    }

    // Delete user
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable String id) {
        userRepository.deleteById(id);
    }

    // Delete user by name
    @DeleteMapping("/user/name/{name}")
    public void deleteUserByName(@PathVariable String name) {
        userRepository.deleteByName(name);
    }

    // Login
    @PostMapping("/user/login")
    public User loginUser(@RequestBody User user) {
        List<User> user2 = userRepository.findByName(user.getName());
        if (user2.size() == 0) {
            return null;
        }
        User userFinded = user2.get(0);
        if (userFinded.getPassword().equals(user.getPassword())) {
            return userFinded;
        }
        return null;
    }

}
