package com.example.demo.dto;

import com.example.demo.entity.Ownership;
import com.example.demo.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
@AllArgsConstructor
public class OwnershipDTO implements Serializable {

    private String id;

    private String country;
    private String city;
    private String address;
    private String house_type;
    private Integer rooms;
    private Integer bathrooms;
    private String description;
    private Double price;
    private String payment_conditions;
    private String[] additional_services;
    private String[] additional_fees;
    private String[] images;
    private String policies_cancellation;
    private Double latitude;
    private Double longitude;
    private Boolean pets_allowed;
    private String smoking_policy;
    private User userId;

    public OwnershipDTO(Ownership ownership) {

        if (ownership.getId() != null)
            this.id = ownership.getId();
        if (ownership.getCountry() != null)
            this.country = ownership.getCountry();
        if (ownership.getCity() != null)
            this.city = ownership.getCity();
        if (ownership.getAddress() != null)
            this.address = ownership.getAddress();
        if (ownership.getHouse_type() != null)
            this.house_type = ownership.getHouse_type();

        this.rooms = ownership.getRooms();
        this.bathrooms = ownership.getBathrooms();
        this.description = ownership.getDescription();

        if (ownership.getPrice() > 0)
            this.price = ownership.getPrice();

        this.payment_conditions = ownership.getPayment_conditions();
        this.additional_services = ownership.getAdditional_services();
        this.additional_fees = ownership.getAdditional_fees();
        this.images = ownership.getImages();
        if (ownership.getPolicies_cancellation() != null)
            this.policies_cancellation = ownership.getPolicies_cancellation();
        this.latitude = ownership.getLatitude();
        this.longitude = ownership.getLongitude();
        this.pets_allowed = ownership.getPets_allowed();
        this.smoking_policy = ownership.getSmoking_policy();
        if (ownership.getUserId() != null)
            this.userId = ownership.getUserId();

    }

}
