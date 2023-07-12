package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.FilesUploadService;

@RestController
@RequestMapping("/files")
public class FilesUploadController {
    private final FilesUploadService filesUploadService;

    @Autowired
    public FilesUploadController(FilesUploadService filesUploadService) {
        this.filesUploadService = filesUploadService;
    }

    // Metodo para subir archivos
    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        return filesUploadService.uploadFile(file);
    }

    // Metodo para borrar archivos por nombre
    @DeleteMapping("/delete")
    public String deleteFile(@RequestParam("fileName") String fileName) {
        return filesUploadService.deleteFile(fileName);
    }
}
