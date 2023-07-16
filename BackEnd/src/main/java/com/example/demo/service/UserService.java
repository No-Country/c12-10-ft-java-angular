package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Get all users
    public List<User> listUser() {
        return userRepository.findAll();
    }

    // Get user by id
    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Post user
    public User saveUser(User user) {
        System.out.println("User Agregado: " + user.toString());
        return userRepository.save(user);
    }

    // Update user
    public User updateUser(String id, User user) {
        User userToUpdate = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        if (user.getUser_id() != null)
            userToUpdate.setUser_id(user.getUser_id());
        if (user.getUsername() != null)
            userToUpdate.setUsername(user.getUsername());
        if (user.getPassword() != null)
            userToUpdate.setPassword(user.getPassword());
        if (user.getName() != null)
            userToUpdate.setName(user.getName());
        if (user.getEmail() != null)
            userToUpdate.setEmail(user.getEmail());
        if (user.getPhone() != null)
            userToUpdate.setPhone(user.getPhone());
        if (user.getRole() != null)
            userToUpdate.setRole(user.getRole());
        if (user.getRegisterDate() != null)
            userToUpdate.setRegisterDate(user.getRegisterDate());
        if (user.getBirthDate() != null)
            userToUpdate.setBirthDate(user.getBirthDate());
        if (user.getDescription() != null)
            userToUpdate.setDescription(user.getDescription());
        return userRepository.save(userToUpdate);
    }

    // Delete user

    public Boolean deleteUser(String id) {
        userRepository.deleteById(id);
        return true;
    }
}
