package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Addresses;
import com.satyamevjayate.api.entity.Crime;
import com.satyamevjayate.api.entity.CrimeType;
import com.satyamevjayate.api.repo.AddressesRepository;
import com.satyamevjayate.api.repo.CrimeTypeRepository;
import com.satyamevjayate.api.repo.CrimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class CrimeServices {
    @Autowired
    private CrimeRepository Crime_repo;
    
    @Autowired
    private AddressesRepository address_repo;
    
    @Autowired
    private CrimeTypeRepository crimeTypeRepository;

    public List<Crime> listAllCrime()
    {
        return Crime_repo.findAll();
    }

    public Long saveCrime(Crime crime)
    {
        Crime_repo.save(crime);
        return  crime.getCrimeID();
    }

    public Crime getCrime(Long Id)
    {
        return Crime_repo.findById(Id).get();
    }

    public void deleteCrime(Long Id)
    {
        Crime_repo.deleteById(Id);
    }

    public Long updateCrime(Crime crime,Long crimeId)
    {
        Crime_repo.save(crime);
        return  crimeId;
    }
}
