package com.example.demo.dto;


import com.example.demo.entity.Ownership;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
@AllArgsConstructor
public class OwnershipDTO implements Serializable {

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
    private String policies_cancellation;
    private Double latitude;
    private Double longitude;
    private Boolean pets_allowed;
    private String smoking_policy;
    private String available_date;


    public  OwnershipDTO(Ownership ownership) {

        if(ownership.getId()!=null)
            this.id = ownership.getId();
        if(ownership.getCountry()!=null)
            this.country = ownership.getCountry();
        if(ownership.getState()!=null)
            this.state = ownership.getState();
        if(ownership.getCity()!=null)
            this.city = ownership.getCity();
        if (ownership.getAddress() != null)
            this.address = ownership.getAddress();
        if(ownership.getHouse_type()!=null)
            this.house_type = ownership.getHouse_type();

        this.rooms = ownership.getRooms();
        this.bathrooms = ownership.getBathrooms();
        this.house_area = ownership.getHouse_area();
        this.description = ownership.getDescription();

        if(ownership.getPrice()>0)
            this.price = ownership.getPrice();
        if(ownership.getDeposit()>0)
            this.deposit=ownership.getDeposit();

        this.payment_conditions = ownership.getPayment_conditions();
        this.additional_services = ownership.getAdditional_services();
        this.additional_fees = ownership.getAdditional_fees();
        if(ownership.getPolicies_cancellation()!=null)
            this.policies_cancellation = ownership.getPolicies_cancellation();
        this.latitude = ownership.getLatitude();
        this.longitude = ownership.getLongitude();
        this.pets_allowed = ownership.getPets_allowed();
       this.smoking_policy = ownership.getSmoking_policy();
       if(ownership.getAvailable_date()!=null)
           this.available_date = ownership.getAvailable_date();


    }

}
