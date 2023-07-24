package com.example.demo.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Images;
import com.example.demo.repository.ImagesRepository;

@Service
public class FilesUploadService {
    private static final String UPLOADED_FOLDER = "src/main/webapp/";

    @Autowired
    public FilesUploadService() {
    }

    private ImagesRepository imagesRepository;

    @Autowired
    public void setImagesRepository(ImagesRepository imagesRepository) {
        this.imagesRepository = imagesRepository;
    }

    // Metodo para subir archivos
    public String uploadFile(MultipartFile file) {
        if (file.isEmpty()) {
            return "Archivo no seleccionado";
        }
        try {
            // Obtenemos el archivo y lo guardamos en la carpeta
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            return "Archivo subido correctamente";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al subir el archivo";
        }
    }

    // Metodo para borrar archivos por nombre
    public String deleteFile(String fileName) {
        try {
            // Obtenemos el archivo y lo borramos de la carpeta
            Path path = Paths.get(UPLOADED_FOLDER + fileName);
            Files.delete(path);
            return "Archivo borrado correctamente";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al borrar el archivo";
        }
    }

    // Metodo para cargar mas de un archivo
    public String uploadMultipleFiles(MultipartFile[] files, String id) {
        String message = "";
        Images images = new Images();
        images.setOwnershipId(id);
        images.setImages(new String[files.length]);
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            try {
                // Obtenemos el archivo y lo guardamos en la carpeta
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + id + "-" + file.getOriginalFilename());
                Files.write(path, bytes);
                message += "Archivo " + i + " subido correctamente\n";
                // images.setImage1();
                // file.getOriginalFilename()
                images.getImages()[i] = id + "-" + file.getOriginalFilename();
            } catch (IOException e) {
                e.printStackTrace();
                message += "Error al subir el archivo " + i + "\n";
            }
        }
        // Se verifica que no se haya subido un archivo con ese id
        // Images savedImages = imagesRepository.save(images);
        Images imagesExist = imagesRepository.findByOwnershipId(id);
        if (imagesExist != null) {
            // Si existe, se actualiza el registro mezclando los datos
            imagesExist.setImages(images.getImages());
            imagesRepository.save(imagesExist);

        } else {
            // Si no existe, se crea un nuevo registro
            imagesRepository.save(images);
        }
        return message;
    }

}
