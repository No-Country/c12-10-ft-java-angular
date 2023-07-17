package com.example.demo.requestEntity;

import com.example.demo.entity.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OwnershipRE {

    private String id;
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
    private String[]images;
    private String policies_cancellation;
    private Double latitude;
    private Double longitude;
    private Boolean pets_allowed;
    private String smoking_policy;
    private String available_date;
    private String user_id;

}
