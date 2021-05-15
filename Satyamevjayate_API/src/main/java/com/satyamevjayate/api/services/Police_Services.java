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
public class Police_Services {
	
	@Autowired
	private PoliceRepository police_repo;
	
	@Autowired
	private AddressesRepository address_repo;
	
	@Autowired
	private ContactRepository contact_repo;
	
	@Autowired
	private PersonRepository person_repo;
	
	@Autowired
	private PoliceRoleRepository policerole_repo;
	
	@Autowired
	private PoliceStationRepository policestation_repo;
	
	
	public List<Police> listAllPolice()
	{
		return police_repo.findAll();
	}
	
	public Police editPolice(Police police)
	{
//		
//		 Addresses address = address_repo.findById(police.getPoliceAddress().getAddressID()).orElse(null);
//	        if (null == address) {
//	            address = new Addresses();
//	        }
//	        address.setAddressLine1(police.getPoliceAddress().getAddressLine1());
//	        address.setAddressLine2(police.getPoliceAddress().getAddressLine2());
//	        address.setCity(police.getPoliceAddress().getCity());
//	        address.setCountry(police.getPoliceAddress().getCountry());
//	        address.setState(police.getPoliceAddress().getState());
//	        address.setZipcode(police.getPoliceAddress().getZipcode());
//	        
//	     
//	        police.setPoliceAddress(address);
//	        
//	    Contact contact=contact_repo.findById(police.getPoliceContact().getContactId()).orElse(null);
//	    	if(null==contact)
//	    	{
//	    		contact=new Contact();
//	    	}
//	    	contact.setContactNumber(police.getPoliceContact().getContactNumber());
//		    contact.setContactEmail(police.getPoliceContact().getContactEmail());
//		
//		    police.setPoliceContact(contact);
//		    
//		Person person = person_repo.findById(police.getPerson().getPersonId()).orElse(null);
//	        if (null == person) {
//	        	person = new Person();
//	        }
//	        person.setFirstName(police.getPerson().getFirstName());
//	        person.setLastName(police.getPerson().getLastName());
//	        person.setGender(police.getPerson().getGender());
//	        person.setDateOfBirth(police.getPerson().getDateOfBirth());
//	        person.setPersonImage(police.getPerson().getPersonImage());
//	        
//	       
//	        police.setPerson(person);
//	        PoliceStation policestation = policestation_repo.findById(police.getPoliceStation().getPoliceStationID()).orElse(null);
//	        if (null == policestation) {
//	        	policestation=new PoliceStation();
//	        }   
//		    
//		    
//		    policestation.setPoliceStationAddress(police.getPoliceStation().getPoliceStationAddress());
//		    policestation.setPoliceStationContact(police.getPoliceStation().getPoliceStationContact());
//		    policestation.setStationName(police.getPoliceStation().getStationName());
//		    
//		  
//		    police.setPoliceStation(policestation);
//
//		    PoliceRole policerole = policerole_repo.findById(police.getPoliceRole().getRoleID()).orElse(null);
//	        if (null == policerole) {
//	        	  policerole=new PoliceRole();
//	        }  
//	        
//		   
//		    policerole.setRoleName(police.getPoliceRole().getRoleName());
//		   
//		    police.setPoliceRole(policerole);
//		    
//	        
     return police_repo.save(police);
//		
//		
		
	}
	
	public policeModel getPolice(BigInteger Id)
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
	
	public Police savePolice(Police police)
	{
		
		address_repo.save(police.getPoliceResidentAddress());
    	address_repo.save(police.getPolicePermanentAddress());
    	contact_repo.save(police.getPoliceContact());
    	person_repo.save(police.getPerson());
    	return police_repo.save(police);
		
		
		
	}
		
	public void deletePolice(BigInteger Id)
	{
		police_repo.deleteById(Id);
	}
	

}
