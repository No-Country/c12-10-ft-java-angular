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
    String ownershipId;
    String[] images;

    public String getOwnershipId() {
        return this.ownershipId;
    }

    public void setOwnershipId(String ownershipId) {
        this.ownershipId = ownershipId;
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
                ", ownershipId='" + getOwnershipId() + "'" +
                ", images='" + getImages() + "'" +
                "}";
    }
}
