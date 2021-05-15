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

    public Crime saveCrime(Crime crime)
    {
            address_repo.save(crime.getCrimeAddress());
            crimeTypeRepository.save(crime.getCrimeType());
	        return Crime_repo.save(crime);
    }

    public Crime getCrime(BigInteger Id)
    {
        return Crime_repo.findById(Id).get();
    }

    public void deleteCrime(BigInteger Id)
    {
        Crime_repo.deleteById(Id);
    }

}
