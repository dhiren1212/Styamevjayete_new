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

    public List<CrimeSuspect> listAllCrimeSuspect()
    {
        return CrimeSuspect_repo.findAll();
    }

    public Long saveCrimeSuspect(CrimeSuspect crimeSuspect)
    {
    	CrimeSuspect_repo.save(crimeSuspect);
		return crimeSuspect.getCrimeSuspectID();
    }

    public Crimesuspectmodel getCrimeSuspect(Long Id)
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

    public String deleteCrimeSuspect(Long Id)
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
	public Long updateCrimeSuspect(CrimeSuspect crimeSuspect ,Long Id)
	{
		return Id;
	}

}
