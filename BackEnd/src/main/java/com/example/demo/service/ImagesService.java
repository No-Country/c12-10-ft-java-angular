package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Images;
import com.example.demo.repository.ImagesRepository;

@Service
public class ImagesService {
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

    // Post images
    public Images saveImages(Images images) {
        // System.out.println("Producto Agregado: " + images.toString());
        return imagesRepository.save(images);
    }

    // Update images
    public Images updateImages(String id, Images images) {
        Images imagesToUpdate = imagesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Images not found"));
        if (images.getUser_id() != null)
            imagesToUpdate.setUser_id(images.getUser_id());
        if (images.getImage1() != null)
            imagesToUpdate.setImage1(images.getImage1());
        if (images.getImage2() != null)
            imagesToUpdate.setImage2(images.getImage2());
        if (images.getImage3() != null)
            imagesToUpdate.setImage3(images.getImage3());
        if (images.getImage4() != null)
            imagesToUpdate.setImage4(images.getImage4());
        if (images.getImage5() != null)
            imagesToUpdate.setImage5(images.getImage5());
        if (images.getImage6() != null)
            imagesToUpdate.setImage6(images.getImage6());
        if (images.getImage7() != null)
            imagesToUpdate.setImage7(images.getImage7());
        if (images.getImage8() != null)
            imagesToUpdate.setImage8(images.getImage8());
        if (images.getImage9() != null)
            imagesToUpdate.setImage9(images.getImage9());
        if (images.getImage10() != null)
            imagesToUpdate.setImage10(images.getImage10());

        return imagesRepository.save(imagesToUpdate);
    }

    // Delete images
    public Boolean deleteImages(String id) {
        imagesRepository.deleteById(id);
        return true;
    }

}
