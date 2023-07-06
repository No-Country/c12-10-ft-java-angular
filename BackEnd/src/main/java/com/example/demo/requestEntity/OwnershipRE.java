package com.example.demo.requestEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OwnershipRE {

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
