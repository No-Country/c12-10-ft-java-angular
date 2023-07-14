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
     OwnershipRepository ownershipRepository;

    public Optional<OwnershipDTO> saveOwnership(OwnershipRE ownershipRE) {

        Ownership ownership = this.createOwnershipFromRe(ownershipRE);
        ownershipRepository.save(ownership);
        return Optional.of(new OwnershipDTO(ownership));
    }

    public Ownership createOwnershipFromRe(OwnershipRE ownershipRE){

        Ownership ownership = new Ownership();

        if(ownershipRE.getId()!=null)
            ownership.setId(ownershipRE.getId());
        if(ownershipRE.getCountry()!=null)
            ownership.setCountry(ownershipRE.getCountry());
        if(ownershipRE.getState()!=null)
            ownership.setState(ownershipRE.getState());
        if(ownershipRE.getCity()!=null)
            ownership.setCity(ownershipRE.getCity());
        if(ownershipRE.getAddress()!=null)
            ownership.setAddress(ownershipRE.getAddress());
        if(ownershipRE.getHouse_type()!=null)
            ownership.setHouse_type(ownershipRE.getHouse_type());
        if(ownershipRE.getRooms()>=0)
            ownership.setRooms(ownershipRE.getRooms());
        if(ownershipRE.getBathrooms()>=0)
            ownership.setBathrooms(ownershipRE.getBathrooms());

        ownership.setHouse_area(ownershipRE.getHouse_area());
        ownership.setDescription(ownershipRE.getDescription());
        ownership.setPrice(ownershipRE.getPrice());
        ownership.setDeposit(ownershipRE.getDeposit());
        ownership.setPayment_conditions(ownershipRE.getPayment_conditions());
        ownership.setAdditional_services(ownershipRE.getAdditional_services());
        ownership.setAdditional_fees(ownershipRE.getAdditional_fees());
        ownership.setPolicies_cancellation(ownershipRE.getPolicies_cancellation());
        ownership.setLatitude(ownershipRE.getLatitude());
        ownership.setLongitude(ownershipRE.getLongitude());
        ownership.setPets_allowed(ownershipRE.getPets_allowed());
        ownership.setSmoking_policy(ownershipRE.getSmoking_policy());
        if(ownershipRE.getAvailable_date()!=null)
            ownership.setAvailable_date(ownershipRE.getAvailable_date());
        
        return ownership;

    }


    public Optional<Ownership> updateOwnership(String id,OwnershipRE ownershipRE){

          Optional<Ownership> ownershipResponse = ownershipRepository.findById(ownershipRE.getId());

       if(ownershipResponse.isPresent()){
           Ownership currentOwnership = ownershipResponse.get();
           Ownership ownership = this.updateOwnershipFromRE( currentOwnership,ownershipRE);
           ownershipRepository.save(ownership);
           return Optional.of(ownership);
       }
       return null;
    }

    public Ownership updateOwnershipFromRE(Ownership ownership, OwnershipRE ownershipRE){

        if(ownershipRE.getId()!=null)
            ownership.setId(ownershipRE.getId());
        if(ownershipRE.getCountry()!=null)
            ownership.setCountry(ownershipRE.getCountry());
        if(ownershipRE.getState()!=null)
            ownership.setState(ownershipRE.getState());
        if(ownershipRE.getCity()!=null)
            ownership.setCity(ownershipRE.getCity());
        if(ownershipRE.getAddress()!=null)
            ownership.setAddress(ownershipRE.getAddress());
        if(ownershipRE.getHouse_type()!=null)
            ownership.setHouse_type(ownershipRE.getHouse_type());
        if(ownershipRE.getRooms()>=0)
            ownership.setRooms(ownershipRE.getRooms());
        if(ownershipRE.getBathrooms()>=0)
            ownership.setBathrooms(ownershipRE.getBathrooms());

        ownership.setHouse_area(ownershipRE.getHouse_area());
        ownership.setDescription(ownershipRE.getDescription());
        ownership.setPrice(ownershipRE.getPrice());
        ownership.setDeposit(ownershipRE.getDeposit());
        ownership.setPayment_conditions(ownershipRE.getPayment_conditions());
        ownership.setAdditional_services(ownershipRE.getAdditional_services());
        ownership.setAdditional_fees(ownershipRE.getAdditional_fees());
        ownership.setPolicies_cancellation(ownershipRE.getPolicies_cancellation());
        ownership.setLatitude(ownershipRE.getLatitude());
        ownership.setLongitude(ownershipRE.getLongitude());
        ownership.setPets_allowed(ownershipRE.getPets_allowed());
        ownership.setSmoking_policy(ownershipRE.getSmoking_policy());
        if(ownershipRE.getAvailable_date()!=null)
            ownership.setAvailable_date(ownershipRE.getAvailable_date());

        return ownership;

    }

    public boolean deleteOwnershipById(String id){
        ownershipRepository.deleteById(id);
        return true;
    }


    public List<Ownership> listOwnership(){

        return  ownershipRepository.findAll();

    }

    public Optional<Ownership> getOwnershipById(String id){

      return Optional.of(ownershipRepository.findOwnershipById(id));
    }


}
