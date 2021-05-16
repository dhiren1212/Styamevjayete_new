package com.satyamevjayate.api.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.satyamevjayate.api.entity.Police;
import com.satyamevjayate.api.model.policeModel;
import com.satyamevjayate.api.repo.AddressesRepository;
import com.satyamevjayate.api.services.PoliceServices;


@RestController

public class PoliceController {
	
	@Autowired
	private PoliceServices policeServices;
	
	@Autowired
	private AddressesRepository address_repo;
	
	 @PostMapping("/polices")
	 public Long savePolice(@RequestBody Police police)
	 {
		 Long policeId= policeServices.savePolice(police);

		 return policeId;
	 }
	
	@GetMapping("/polices")
	public List<Police> findAllPolice()
	{
		 return policeServices.listAllPolice();
	}
	
	@GetMapping("/polices/{id}")
	public policeModel getPolice(@PathVariable Long id)
	{
	     policeModel policemodel= policeServices.getPolice(id);
	     return policemodel;
	}
	
	@PutMapping("/polices/{id}")
	public Long editPolice(@RequestBody Police police, @PathVariable Long id)
	{

	    Long policeId= policeServices.editPolice(police,id);

	     return policeId;
	}
	@DeleteMapping("/polices/{id}")
    public String deletePolice(@PathVariable Long id)
    {
        policeServices.deletePolice(id);
        return "Delete Person Successfully";
    }


}
