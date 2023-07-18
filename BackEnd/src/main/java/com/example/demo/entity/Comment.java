package com.example.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "comments")
public class Comment extends JpaEntity implements Serializable {


    @ManyToOne
    @JoinColumn(name = "ownership_id")
    private Ownership ownership;

    @ManyToMany
    @JoinColumn(name = "user_id")
    private User user;

    private String comment;




}
