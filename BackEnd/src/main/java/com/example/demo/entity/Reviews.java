package com.example.demo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
public class Reviews {
    /*
     * {
     * "id": 3,
     * "userId": 123,
     * "ownershipId": 789,
     * "comment": "Este es el tercer comentario.",
     * "postDate": "18-07-2023",
     * "score": 2
     * }
     */
    String id;
    String userId;
    String ownershipId;
    String comment;
    String postDate;
    String score;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOwnershipId() {
        return this.ownershipId;
    }

    public void setOwnershipId(String ownershipId) {
        this.ownershipId = ownershipId;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPostDate() {
        return this.postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public String getScore() {
        return this.score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", userId='" + getUserId() + "'" +
                ", ownershipId='" + getOwnershipId() + "'" +
                ", comment='" + getComment() + "'" +
                ", postDate='" + getPostDate() + "'" +
                ", score='" + getScore() + "'" +
                "}";
    }

}