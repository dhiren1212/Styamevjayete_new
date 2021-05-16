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


import com.satyamevjayate.api.entity.CrimeType;
import com.satyamevjayate.api.services.CrimeTypeServices;

@RestController
public class CrimeTypeController {

	@Autowired
	private CrimeTypeServices crimeTypeServices;
	
	@GetMapping("/crimetype")
	public List<CrimeType> getAllCrimeType() {
		return crimeTypeServices.listAllCrimeType();
	}
	
	@GetMapping("/crimetype/{id}")
	public CrimeType getCrimeType(@PathVariable Long id)
	{
		
			CrimeType crimetype= crimeTypeServices.getCrimeType(id);
			return crimetype;
	}
	
	@PostMapping("/crimetype")
	public Long addCrimeType(@RequestBody CrimeType crimetype)
	{
		Long crimeTypeId=crimeTypeServices.saveCrimeType(crimetype);

		return crimeTypeId;
	}	
	
	
	@DeleteMapping("/crimetype/{id}")
	public String deleteCrimeType(@PathVariable Long id)
	{
		crimeTypeServices.deleteCrimeType(id);;
	    return "Delete CrimeType Successfully";
	}
	
	@PutMapping("/crimetype/{id}")
	public Long editCrimeType(@RequestBody CrimeType crimetype, @PathVariable Long id) {

		Long crimeTypeId=crimeTypeServices.saveCrimeType(crimetype);

		return crimeTypeId;
	}

}
