package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Images;
import com.example.demo.repository.ImagesRepository;

@Service
public class ImagesService {
    @Autowired
    private final ImagesRepository imagesRepository;

    @Autowired
    public ImagesService(ImagesRepository imagesRepository) {
        this.imagesRepository = imagesRepository;
    }

    // Get all imagess
    public List<Images> listImages() {
        return imagesRepository.findAll();
    }

    // Get images by id
    public Images getImagesById(String id) {
        return imagesRepository.findById(id).orElseThrow(() -> new RuntimeException("Images not found"));
    }

    // Get images by user_id
    public Images getImagesByUserId(String user_id) {
        return imagesRepository.findByUserId(user_id);
    }

    // Post images
    public Images saveImages(Images images) {
        // Se verifica que no exista un registro con el mismo user_id
        Images imagesExist = imagesRepository.findByUserId(images.getUserId());
        if (imagesExist != null) {
            // Si existe, se actualiza el registro
            imagesExist.setImages(images.getImages());
            return imagesRepository.save(imagesExist);
        } else {
            // Si no existe, se crea un nuevo registro
            return imagesRepository.save(images);
        }
        // return imagesRepository.save(images);
    }

    // Update images
    public Images updateImages(String id, Images images) {
        Images imagesToUpdate = imagesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Images not found"));
        if (images.getUserId() != null)
            imagesToUpdate.setUserId(images.getUserId());
        if (images.getImages() != null)
            imagesToUpdate.setImages(images.getImages());

        return imagesRepository.save(imagesToUpdate);
    }

    // Delete images
    public Boolean deleteImages(String id) {
        imagesRepository.deleteById(id);
        return true;
    }

}
