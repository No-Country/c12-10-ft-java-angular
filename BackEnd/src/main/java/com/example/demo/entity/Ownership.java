package com.example.demo.entity;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection ="ownership")
public class Ownership extends JpaEntity implements Serializable{

    private String country;
    private String state;
    private String city;
    private String address;
    private String house_type;
    private Integer rooms;
    private Integer bathrooms;
    private Double house_area;
    private String description;
    private Double price;
    private Double deposit;
    private String payment_conditions;
    private String[] additional_services;
    private String[] additional_fees;
    private String policies_cancellation;
    private Double latitude;
    private Double longitude;
    private Boolean pets_allowed;
    private String smoking_policy;
    private String available_date;

}
