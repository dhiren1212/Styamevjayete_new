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
    private CrimeTypeRepository crimetype_repo;

    public List<Crime> listAllCrime()
    {
        return Crime_repo.findAll();
    }

    public Crime saveCrime(Crime Crime)
    {
//    	 Addresses address = address_repo.findById(Crime.getCrmaddress().getAddressID()).orElse(null);
//	        if (null == address) {
	          
	           Addresses address = new Addresses();
//	        }
	        address.setAddressLine1(Crime.getCrimeAddress().getAddressLine1());
	        address.setAddressLine2(Crime.getCrimeAddress().getAddressLine2());
	        address.setCity(Crime.getCrimeAddress().getCity());
	        address.setCountry(Crime.getCrimeAddress().getCountry());
	        address.setState(Crime.getCrimeAddress().getState());
	        address.setZipcode(Crime.getCrimeAddress().getZipcode());
	        address_repo.save(address);
	        Crime.setCrimeAddress(address);
//    	System.out.println(Crime.getCrmtype().getCrimeTypeId());
//	      CrimeType crimetype = crimetype_repo.findById(Crime.getCrmtype().getCrimeTypeId()).orElse(new CrimeType());
//	        if (null == crimetype) {
	           CrimeType crimetype = new CrimeType();
//	        }
//	           crimetype.setCrimeType(Crime.getCrmtype().getCrimeType());
	        crimetype.setCrimeType(Crime.getCrimeType().getCrimeType());
	        crimetype_repo.save(crimetype);
	        Crime.setCrimeType(crimetype);
	        return Crime_repo.save(Crime);
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
