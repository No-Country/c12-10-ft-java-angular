package com.example.demo.entity;

import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "user")
public class UserEntity {
    /*
     * 
     * "username": "sam_jackson",
     * "password": "securepass",
     * "name": "Sam Jackson",
     * "email": "sam.jackson@example.com",
     * "phone": "555-123-4567",
     * "role": "buyer"
     * registerDate": "2019-01-01T00:00:00Z",
     * birthDate": "1990-01-01T00:00:00Z",
     * description": "I'm a buyer",
     */
    String id;
    String userId;
    String username;
    String password;
    String name;
    String email;
    String phone;
    String role;
    String registerDate;
    String birthDate;
    String description;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRegisterDate() {
        return this.registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", userId='" + getUserId() + "'" +
                ", username='" + getUsername() + "'" +
                ", password='" + getPassword() + "'" +
                ", name='" + getName() + "'" +
                ", email='" + getEmail() + "'" +
                ", phone='" + getPhone() + "'" +
                ", role='" + getRole() + "'" +
                ", registerDate='" + getRegisterDate() + "'" +
                ", birthDate='" + getBirthDate() + "'" +
                ", description='" + getDescription() + "'" +
                "}";
    }

}
