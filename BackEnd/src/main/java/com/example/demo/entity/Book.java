package com.example.demo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "book")
public class Book {
    /*
     * {
     * "book_id": "12345",
     * "user_id": "98765",
     * "ownership_id": "abcde",
     * "date_start": "2023-06-01",
     * "date_finish": "2023-06-15"
     * }
     */
    String id;
    String book_id;
    String user_id;
    String ownership_id;
    String date_start;
    String date_finish;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBook_id() {
        return this.book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getOwnership_id() {
        return this.ownership_id;
    }

    public void setOwnership_id(String ownership_id) {
        this.ownership_id = ownership_id;
    }

    public String getDate_start() {
        return this.date_start;
    }

    public void setDate_start(String date_start) {
        this.date_start = date_start;
    }

    public String getDate_finish() {
        return this.date_finish;
    }

    public void setDate_finish(String date_finish) {
        this.date_finish = date_finish;
    }

    @Override
    public String toString() {
        return "{" +
                " book_id='" + getBook_id() + "'" +
                ", user_id='" + getUser_id() + "'" +
                ", ownership_id='" + getOwnership_id() + "'" +
                ", date_start='" + getDate_start() + "'" +
                ", date_finish='" + getDate_finish() + "'" +
                "}";
    }

}
