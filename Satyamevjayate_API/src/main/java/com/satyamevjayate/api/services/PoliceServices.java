package com.satyamevjayate.api.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyamevjayate.api.entity.Addresses;
import com.satyamevjayate.api.entity.Contact;
import com.satyamevjayate.api.entity.Person;
import com.satyamevjayate.api.entity.Police;
import com.satyamevjayate.api.entity.PoliceRole;
import com.satyamevjayate.api.entity.PoliceStation;
import com.satyamevjayate.api.model.policeModel;
import com.satyamevjayate.api.repo.AddressesRepository;
import com.satyamevjayate.api.repo.ContactRepository;
import com.satyamevjayate.api.repo.PersonRepository;
import com.satyamevjayate.api.repo.PoliceStationRepository;
import com.satyamevjayate.api.repo.PoliceRepository;
import com.satyamevjayate.api.repo.PoliceRoleRepository;

@Service
public class PoliceServices {
	
	@Autowired
	private PoliceRepository police_repo;

	
	public List<Police> listAllPolice()
	{
		return police_repo.findAll();
	}
	
	public Long editPolice(Police police,Long id)
	{
		police_repo.save(police);
		return police.getPoliceID();
	}
	
	public policeModel getPolice(Long Id)
	{
		
		
		policeModel policemodel =new policeModel();
		Optional<Police> police=police_repo.findById(Id);
		if(police.isPresent()){
		   Police police1=new Police();
		   police1=police.get();
		   List <Police>ps=new ArrayList<>();
		   ps.add(police1);
		   policemodel.setMessage("Record fetched Successfully!!");
		   policemodel.setPolice(ps);
		}
		else{
		   policemodel.setMessage("No Record in Police");
		}
		return policemodel;
		
//		return police_repo.findById(Id).get();
	}
	
	public Long savePolice(Police police)
	{
		police_repo.save(police);
		return police.getPoliceID();
	}
		
	public void deletePolice(Long Id)
	{
		police_repo.deleteById(Id);
	}
	

}
