package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Addresses;
import com.satyamevjayate.api.entity.Contact;
import com.satyamevjayate.api.entity.Crime;
import com.satyamevjayate.api.entity.CrimeSuspect;
import com.satyamevjayate.api.entity.Person;
import com.satyamevjayate.api.model.Crimesuspectmodel;
import com.satyamevjayate.api.repo.AddressesRepository;
import com.satyamevjayate.api.repo.ContactRepository;
import com.satyamevjayate.api.repo.CrimeSuspectRepository;
import com.satyamevjayate.api.repo.CrimeRepository;
import com.satyamevjayate.api.repo.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CrimeSuspectServices {
    @Autowired
    private CrimeSuspectRepository CrimeSuspect_repo;
    
    @Autowired
    private AddressesRepository address_repo;
    
    @Autowired
    private ContactRepository contact_repo;
    
    @Autowired
    private PersonRepository person_repo;
    
    @Autowired
    private CrimeRepository crime_repo;
    

    public List<CrimeSuspect> listAllCrimeSuspect()
    {
        return CrimeSuspect_repo.findAll();
    }

    public CrimeSuspect saveCrimeSuspect(CrimeSuspect CrimeSuspect)
    {
		address_repo.save(CrimeSuspect.getSuspectResidentAddress());
		address_repo.save(CrimeSuspect.getSuspectPermanentAddress());
		contact_repo.save(CrimeSuspect.getSuspectContact());
		person_repo.save(CrimeSuspect.getSuspectPerson());
		return CrimeSuspect_repo.save(CrimeSuspect);
    }

    public Crimesuspectmodel getCrimeSuspect(BigInteger Id)
    {

		Crimesuspectmodel crimesuspectmodel	=new Crimesuspectmodel();
		Optional<CrimeSuspect> crimeSuspect=CrimeSuspect_repo.findById(Id);
		if(crimeSuspect.isPresent()){
			CrimeSuspect crimeSuspect1=crimeSuspect.get();
			List <CrimeSuspect>cs=new ArrayList<>();
			cs.add(crimeSuspect1);
			crimesuspectmodel.setMessage("Record fetched Successfully!!");
			crimesuspectmodel.setCrimeSuspect(cs);
		}
		else{
			crimesuspectmodel.setMessage("No Record in Crime Suspect");
		}
		return crimesuspectmodel;
    }

    public String deleteCrimeSuspect(BigInteger Id)
    {
    	String res;
		if(CrimeSuspect_repo.findById(Id).isPresent()){
			CrimeSuspect_repo.deleteById(Id);
			res="Record with "+Id+" id Deleted Successfully!!";
		}
		else{
			res="Record with "+Id+" id Does not exists!!";
		}
		return res;
    }
}
