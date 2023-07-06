package com.example.demo.dto;

import com.example.demo.entity.Ownership;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class OwnershipDTO implements Serializable {

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


    public  OwnershipDTO(Ownership ownership) {

        if (ownership.getId() != null)
            this.id = ownership.getId();
        if (ownership.getAddress() != null)
            this.address = ownership.getAddress();
    }

}
