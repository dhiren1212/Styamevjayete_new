package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.*;
import com.satyamevjayate.api.model.Crimevictimmodel;
import com.satyamevjayate.api.model.Crimevictimmodel;
import com.satyamevjayate.api.repo.AddressesRepository;
import com.satyamevjayate.api.repo.ContactRepository;
import com.satyamevjayate.api.repo.CrimeVictimRepository;
import com.satyamevjayate.api.repo.CrimeRepository;
import com.satyamevjayate.api.repo.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CrimeVictimServices {
    @Autowired
    private CrimeVictimRepository CrimeVictim_repo;
    
    @Autowired
    private AddressesRepository address_repo;
    
    @Autowired
    private ContactRepository contact_repo;
    
    @Autowired
    private PersonRepository person_repo;
    
    @Autowired
    private CrimeRepository crime_repo;

    public List<CrimeVictim> listAllCrimeVictim()
    {
        return CrimeVictim_repo.findAll();
    }

    public CrimeVictim saveCrimeVictim(CrimeVictim CrimeVictim)
    {
		address_repo.save(CrimeVictim.getAddresses());
		contact_repo.save(CrimeVictim.getContact());
		person_repo.save(CrimeVictim.getPerson());
        return CrimeVictim_repo.save(CrimeVictim);
    }

    public Crimevictimmodel getCrimeVictim(BigInteger Id)
    {
        Crimevictimmodel crimevictimmodel	=new Crimevictimmodel();
        Optional<CrimeVictim> crimevictim=CrimeVictim_repo.findById(Id);
        if(crimevictim.isPresent()){
            CrimeVictim crimevictim1=crimevictim.get();
            List <CrimeVictim>cs=new ArrayList<>();
            cs.add(crimevictim1);
            crimevictimmodel.setMessage("Record fetched Successfully!!");
            crimevictimmodel.setCrimeVictims(cs);
        }
        else{
            crimevictimmodel.setMessage("No Record in Crime victim");
        }
        return crimevictimmodel;
    }

    public String deleteCrimeVictim(BigInteger Id)
    {
        String res;
        if(CrimeVictim_repo.findById(Id).isPresent()){
            CrimeVictim_repo.deleteById(Id);
            res="Record with "+Id+" id Deleted Successfully!!";
        }
        else{
            res="Record with "+Id+" id Does not exists!!";
        }
        return res;
    }
}
