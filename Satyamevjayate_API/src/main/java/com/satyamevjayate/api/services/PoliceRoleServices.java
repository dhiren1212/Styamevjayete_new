package com.satyamevjayate.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyamevjayate.api.entity.PoliceRole;
import com.satyamevjayate.api.repo.PoliceRoleRepository;

@Service
public class PoliceRoleServices {
	
	@Autowired
	private PoliceRoleRepository policeRoleRepository;
	
	public List<PoliceRole> listAllPoliceRole()
	{
		return policeRoleRepository.findAll();
	}
	
	public Long savePoliceRole(PoliceRole policerole)
	{
		policeRoleRepository.save(policerole);
		return policerole.getRoleID();
	}
	
	public PoliceRole getPoliceRole(Long Id)
	{
		return policeRoleRepository.findById(Id).get();
	}
	
	public void delete_PoliceRole(Long Id)
	{
		policeRoleRepository.deleteById(Id);
	}
	public Long editPoliceRole(PoliceRole policerole,Long id)
	{
		policeRoleRepository.save(policerole);
		return id;
	}

}
