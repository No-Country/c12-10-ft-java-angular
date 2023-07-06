package com.example.demo.service;

import com.example.demo.dto.OwnershipDTO;
import com.example.demo.entity.Ownership;
import com.example.demo.repository.OwnershipRepository;
import com.example.demo.requestEntity.OwnershipRE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnershipService {

    @Autowired
    private OwnershipRepository ownershipRepository;

    public Ownership createOwnershipFromRe(OwnershipRE ownershipRE){

        Ownership ownership = new Ownership();

        if(ownershipRE.getId()!=null)
            ownership.setAddress(ownershipRE.getId());
        if(ownershipRE.getAddress()!=null)
            ownership.setAddress(ownershipRE.getAddress());
        if(ownershipRE.getType()!=null)
            ownership.setType(ownershipRE.getType());
        if(ownershipRE.getBedrooms()>0)
            ownership.setBedrooms(ownershipRE.getBedrooms());
        if(ownershipRE.getBathrooms()>0)
            ownership.setBathrooms(ownershipRE.getBathrooms());

        //private Double room_size;
       // private String description;
       // private Double price;
        //private Double security_deposit;
       // private String payment_conditions;

        return ownership;

    }


    public Optional<OwnershipDTO> saveOwnership(OwnershipRE ownershipRE) {

        Ownership ownership = this.createOwnershipFromRe(ownershipRE);
        ownershipRepository.save(ownership);
        OwnershipDTO ownershipDTO = new OwnershipDTO(ownership);
        return Optional.of(ownershipDTO);
    }

    public List<Ownership> listOwnership(){

        return  ownershipRepository.findAll();

    }


}
