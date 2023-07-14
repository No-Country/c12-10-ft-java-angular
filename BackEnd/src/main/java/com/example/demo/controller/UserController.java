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
        Optional<User> usuarioExistente = userRepository.findById(id);
        if (usuarioExistente.isEmpty()) {
            return ResponseEntity.ok().body(new GenericResponseDTO<>(false, "User not found", null));
        }
        if (user.getId() != null) {
            usuarioExistente.get().setId(user.getId());
        }
        if (user.getUser_id() != null) {
            usuarioExistente.get().setUser_id(user.getUser_id());
        }
        if (user.getUsername() != null) {
            usuarioExistente.get().setUsername(user.getUsername());
        }
        if (user.getPassword() != null) {
            usuarioExistente.get().setPassword(user.getPassword());
        }
        if (user.getName() != null) {
            usuarioExistente.get().setName(user.getName());
        }
        if (user.getEmail() != null) {
            usuarioExistente.get().setEmail(user.getEmail());
        }
        if (user.getPhone() != null) {
            usuarioExistente.get().setPhone(user.getPhone());
        }
        if (user.getRole() != null) {
            usuarioExistente.get().setRole(user.getRole());
        }
        if (user.getRegisterDate() != null) {
            usuarioExistente.get().setRegisterDate(user.getRegisterDate());
        }
        if (user.getBirthDate() != null) {
            usuarioExistente.get().setBirthDate(user.getBirthDate());
        }
        if (user.getDescription() != null) {
            usuarioExistente.get().setDescription(user.getDescription());
        }
        return ResponseEntity.ok()
                .body(new GenericResponseDTO<>(true, "Success", userRepository.save(usuarioExistente.get())));

        // return userRepository.save(user);
    }

    // Delete user
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
            return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", true));
        }
        userRepository.deleteById(id);
        return ResponseEntity.ok().body(new GenericResponseDTO<>(false, "Not Success", false));
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
