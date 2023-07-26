package com.example.demo.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Get all users
    public List<UserEntity> listUser() {
        return userRepository.findAll();
    }

    // Get user by id
    public UserEntity getUserById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Get by userId
    public UserEntity getUserByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }

    // Post user
    public UserEntity saveUser(UserEntity user) {
        System.out.println("User Agregado: " + user.toString());
        user.setPassword(encryptPassword(user.getPassword()));
        return userRepository.save(user);
    }

    private String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            return Base64.getEncoder().encodeToString(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Update user
    public UserEntity updateUser(String id, UserEntity user) {
        UserEntity userToUpdate = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        if (user.getUserId() != null)
            userToUpdate.setUserId(user.getUserId());
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

    // Login email and password
    public String login(String email, String password) {
        UserEntity user = userRepository.findByEmail(email);
        // System.out.println("email: " + email);
        // System.out.println("Password: encriptado" + encryptPassword(password));
        // System.out.println("Password: " + password);
        System.out.println(user.getPassword().equals(encryptPassword(password)));
        if (user == null)
            return "User not found";
        if (user.getPassword().equals(encryptPassword(password)))
            return user.getId();
        return "Password incorrect";
    }
}
