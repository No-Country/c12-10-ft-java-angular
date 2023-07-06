package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection ="ownership")
public class Ownership
{

    @Id
    private String id;
    private String address;
    private String type;
    private Integer bedrooms;
    private Integer bathrooms;
    private Double room_size;
    private String description;
    private Double price;
    private Double security_deposit;
    private String payment_conditions;



}
