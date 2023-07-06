package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.usuario;

public interface usuarioRepository extends MongoRepository<usuario, String> {
    List<usuario> findByNombre(String nombre);

    void deleteByNombre(String nombre);
}
