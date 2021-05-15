package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Addresses;
import com.satyamevjayate.api.entity.Contact;
import com.satyamevjayate.api.entity.Criminal;
import com.satyamevjayate.api.entity.Person;
import com.satyamevjayate.api.repo.AddressesRepository;
import com.satyamevjayate.api.repo.ContactRepository;
import com.satyamevjayate.api.repo.CriminalRepository;
import com.satyamevjayate.api.repo.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriminalServices {
    @Autowired
    private CriminalRepository criminalRepository;
    
    @Autowired
    private AddressesRepository address_repo;
    
    @Autowired
    private ContactRepository contact_repo;
    
    @Autowired
    private PersonRepository person_repo;

    public List<Criminal> listAllCriminal()
    {
        return criminalRepository.findAll();
    }

    public Criminal saveCriminal(Criminal criminal)
    {
    	address_repo.save(criminal.getCriminalResidentAddress());
    	address_repo.save(criminal.getCriminalPermanentAddress());
    	contact_repo.save(criminal.getCriminalContact());
    	person_repo.save(criminal.getCriminalPerson());
    	return criminalRepository.save(criminal);
    }

    
//    public Criminal editCriminal(Criminal Criminal)
//    {
//    	 Addresses address = address_repo.findById(Criminal.getCriminalAddress().getAddressID()).orElse(null);
//	        if (null == address) {
//	          address = new Addresses();
//	        }
//	        address.setAddressLine1(Criminal.getCriminalAddress().getAddressLine1());
//	        address.setAddressLine2(Criminal.getCriminalAddress().getAddressLine2());
//	        address.setCity(Criminal.getCriminalAddress().getCity());
//	        address.setCountry(Criminal.getCriminalAddress().getCountry());
//	        address.setState(Criminal.getCriminalAddress().getState());
//	        address.setZipcode(Criminal.getCriminalAddress().getZipcode());
//
//	        Criminal.setCriminalAddress(address);
//
//	    Contact contact=contact_repo.findById(Criminal.getCriminalContact().getContactId()).orElse(null);
//	    	if(null==contact)
//	    	{
//	    		contact=new Contact();
//	    	}
//	    	contact.setContactNumber(Criminal.getCriminalContact().getContactNumber());
//		    contact.setContactEmail(Criminal.getCriminalContact().getContactEmail());
//
//		    Criminal.setCriminalContact(contact);
//
//		Person person = person_repo.findById(Criminal.getCriminalPerson().getPersonId()).orElse(null);
//	        if (null == person) {
//	         person = new Person();
//	        }
//	        person.setFirstName(Criminal.getCriminalPerson().getFirstName());
//	        person.setLastName(Criminal.getCriminalPerson().getLastName());
//	        person.setGender(Criminal.getCriminalPerson().getGender());
//	        person.setDateOfBirth(Criminal.getCriminalPerson().getDateOfBirth());
//	        person.setPersonImage(Criminal.getCriminalPerson().getPersonImage());
//
//	        Criminal.setCriminalPerson(person);
//
//	     return criminalRepository.save(Criminal);
//    }
    
    public Criminal getCriminal(Long Id)
    {
        return criminalRepository.findById(Id).get();
    }

    public void deleteCriminal(Long Id)
    {
        criminalRepository.deleteById(Id);
    }
}
