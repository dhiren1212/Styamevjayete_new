package com.satyamevjayate.api.services;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyamevjayate.api.entity.PoliceRole;
import com.satyamevjayate.api.repo.PoliceRoleRepository;

@Service
public class PoliceRoleServices {
	
	@Autowired
	private PoliceRoleRepository Police_Role_Repo;
	
	public List<PoliceRole> listAll_Police_Role()
	{
		return Police_Role_Repo.findAll();
	}
	
	public void save_Police_Role(PoliceRole police_role)
	{
		Police_Role_Repo.save(police_role);
	}
	
	public PoliceRole getPolice_Role(BigInteger Id)
	{
		return Police_Role_Repo.findById(Id).get();
	}
	
	public void delete_Police_Role(BigInteger Id)
	{
		Police_Role_Repo.deleteById(Id);
	}
	
	

}
