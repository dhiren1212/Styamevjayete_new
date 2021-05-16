package com.satyamevjayate.api.services;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.satyamevjayate.api.entity.CrimeType;
import com.satyamevjayate.api.repo.CrimeTypeRepository;

@Service
public class CrimeTypeServices {
	
	@Autowired
	private CrimeTypeRepository crimetype_repo;
	
	public List<CrimeType> listAllCrimeType()
	{
		return crimetype_repo.findAll();
	}
	
	public Long saveCrimeType(CrimeType crimetype)
	{
		crimetype_repo.save(crimetype);
		return crimetype.getCrimeTypeId();
	}
	
	public CrimeType getCrimeType(Long Id)
	{
		return crimetype_repo.findById(Id).get();
	}
	
	public void deleteCrimeType(Long Id)
	{
		crimetype_repo.deleteById(Id);
	}

	public Long updateCrimeType(CrimeType crimetype,Long Id)
	{
		crimetype_repo.save(crimetype);
		return Id;
	}


}
