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

import com.satyamevjayate.api.entity.PoliceRole;
import com.satyamevjayate.api.services.PoliceRoleServices;

@RestController
public class PoliceRoleContoller {

	@Autowired
	private PoliceRoleServices policeRoleServices;

	@GetMapping("/policerole")
	public List<PoliceRole> getAllPolice_Role() {
		return policeRoleServices.listAllPoliceRole();
	}
	
	@GetMapping("/policerole/{id}")
	public PoliceRole getPoliceRole(@PathVariable Long id)
	{
		PoliceRole p= policeRoleServices.getPoliceRole(id);
		return p;
	}
	
	@PostMapping("/policerole")
	public Long addPoliceRole(@RequestBody PoliceRole p)
	{
		Long roleID=policeRoleServices.savePoliceRole(p);

		return roleID;
		
	}
	
	@DeleteMapping("/policerole/{id}")
	public String deletePoliceRole(@PathVariable Long id)
	{
		policeRoleServices.delete_PoliceRole(id);
		return "PoliceRole Delete successfully";
	}
	
	@PutMapping("/policerole/{id}")
	public Long editPoliceRole(@RequestBody PoliceRole policerole, @PathVariable Long id) {

		
		Long roleID=policeRoleServices.editPoliceRole(policerole,id);

		return roleID;
	}

}
