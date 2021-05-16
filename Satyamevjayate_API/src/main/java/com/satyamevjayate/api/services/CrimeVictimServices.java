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

    public List<CrimeVictim> listAllCrimeVictim()
    {
        return CrimeVictim_repo.findAll();
    }

    public Long saveCrimeVictim(CrimeVictim crimeVictim)
    {
        CrimeVictim_repo.save(crimeVictim);
        return crimeVictim.getCrimeVictimID();
    }

    public Crimevictimmodel getCrimeVictim(Long Id)
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

    public String deleteCrimeVictim(Long Id)
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
    public Long updateCrimeVictim(CrimeVictim crimeVictim)
    {
        CrimeVictim_repo.save(crimeVictim);
        return crimeVictim.getCrimeVictimID();
    }
}
