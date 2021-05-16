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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satyamevjayate.api.entity.LawAct;
import com.satyamevjayate.api.services.LawActServices;

@RequestMapping("/LawActs")
@RestController
public class LawActContoller {
	
	@Autowired
	private LawActServices lawActServices;
	
	@GetMapping("/LawActs")
	public List<LawAct> lawActs()
	{
		return lawActServices.listAllLawAct();
	}
	
	@GetMapping("/LawAct/{id}")
	public LawAct getLawAct(@PathVariable Long id)
	{
		LawAct l = lawActServices.getLawact(id);
		return l;
				
	}
	
	@PostMapping("/LawAct")
	public Long addLawact(@RequestBody LawAct lawAct)
	{
		Long lawID=lawActServices.saveLawAct(lawAct);
		return lawID;
	}
	
	@DeleteMapping("/DeleteLawAct/{id}")
	public String deleteLawAct(@PathVariable Long id)
	{
		lawActServices.deleteLawact(id);
		return "LawAct Delete successfully";
		
	}
	
	@PutMapping("/EditLawAct/{id}")
	public Long editLawAct(@RequestBody LawAct lawact , @PathVariable Long id)
	{
		Long lawID=lawActServices.saveLawAct(lawact);
		return lawID;
	}
	
	

}
