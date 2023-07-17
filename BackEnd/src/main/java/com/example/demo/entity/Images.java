package com.example.demo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "images")
public class Images {
    /*
     * {
     * "userId": "98765",
     * //array de imagenes
     * "images": [
     * "image1.jpg",
     * "image2.jpg",
     * "image3.jpg"
     * ]
     * 
     * }
     */
    String id;
    String userId;
    String[] images;

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getImages() {
        return this.images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", userId='" + getUserId() + "'" +
                ", images='" + getImages() + "'" +
                "}";
    }
}
