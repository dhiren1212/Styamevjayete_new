package com.satyamevjayate.api.services;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyamevjayate.api.entity.Contact;
import com.satyamevjayate.api.repo.ContactRepository;

@Service
public class ContactServices {
	
	@Autowired
	private ContactRepository contact_repo;
	
	public List<Contact> listAllContact()
	{
		return contact_repo.findAll();
	}
	
	public Long saveContact(Contact contact)
	{
		contact_repo.save(contact);
		return contact.getContactId();
	}
	
	public Contact getContact(Long Id)
	{
		return contact_repo.findById(Id).get();
	}
	
	public void deleteContact(Long Id)
	{
		contact_repo.deleteById(Id);
	}

	public Long updateContact(Contact contact,Long contactId)
	{
		contact_repo.save(contact);
		return contact.getContactId();
	}

}
