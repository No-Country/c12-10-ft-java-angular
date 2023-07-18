package com.example.demo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "book")
public class Book {
    /*
     * {
     * "bookId": "12345",
     * "userId": "98765",
     * "ownershipId": "abcde",
     * "dateStart": "2023-06-01",
     * "dateFinish": "2023-06-15"
     * }
     */
    String id;
    String bookId;
    String userId;
    String ownershipId;
    String dateStart;
    String dateFinish;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookId() {
        return this.bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
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

    public String getDateStart() {
        return this.dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateFinish() {
        return this.dateFinish;
    }

    public void setDateFinish(String dateFinish) {
        this.dateFinish = dateFinish;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", bookId='" + getBookId() + "'" +
                ", userId='" + getUserId() + "'" +
                ", ownershipId='" + getOwnershipId() + "'" +
                ", dateStart='" + getDateStart() + "'" +
                ", dateFinish='" + getDateFinish() + "'" +
                "}";
    }

}
