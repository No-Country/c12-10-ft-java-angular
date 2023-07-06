package com.example.demo.controller;

import java.io.Console;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.usuario;
import com.example.demo.repository.usuarioRepository;

@RestController
public class usuarioController {
    @Autowired
    private usuarioRepository usuarioRepository;

    // Get all users
    @GetMapping("/usuarios")
    public List<usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    // Get user by id
    @GetMapping("/usuarios/{id}")
    public Optional<usuario> getUsuarioById(@PathVariable String id) {
        return usuarioRepository.findById(id);
    }

    // Get user by name
    @GetMapping("/usuarios/nombre/{nombre}")
    public List<usuario> getUsuarioByNombre(@PathVariable String nombre) {
        return usuarioRepository.findByNombre(nombre);
    }

    // Create user
    @PostMapping("/usuarios")
    public usuario createUsuario(@RequestBody usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Update user
    @PutMapping("/usuarios/{id}")
    public usuario updateUsuario(@PathVariable String id, @RequestBody usuario usuario) {
        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }

    // Delete user
    @DeleteMapping("/usuarios/{id}")
    public void deleteUsuario(@PathVariable String id) {
        usuarioRepository.deleteById(id);
    }

    // Delete user by name
    @DeleteMapping("/usuarios/nombre/{nombre}")
    public void deleteUsuarioByNombre(@PathVariable String nombre) {
        usuarioRepository.deleteByNombre(nombre);
    }

    // Login
    @PostMapping("/usuarios/login")
    public usuario loginUsuario(@RequestBody usuario usuario) {
        List<usuario> usuarios = usuarioRepository.findByNombre(usuario.getNombre());
        if (usuarios.size() == 0) {
            return null;
        }
        usuario usuarioEncontrado = usuarios.get(0);
        if (usuarioEncontrado.getPassword().equals(usuario.getPassword())) {
            return usuarioEncontrado;
        }
        return null;
    }

}
