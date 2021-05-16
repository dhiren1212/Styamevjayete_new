package com.satyamevjayate.api.services;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyamevjayate.api.entity.Addresses;

import com.satyamevjayate.api.repo.AddressesRepository;

@Service
public class AddressesServices {
	
	@Autowired
	private AddressesRepository Address_repo;
	
	public List<Addresses> listAllAddresses()
	{
		return Address_repo.findAll();
	}
	
	public Long saveAddress(Addresses address)
	{
		Address_repo.save(address);
		return  address.getAddressID();
	}
	
	public Addresses getAddress(Long Id)
	{
		return Address_repo.findById(Id).get();
	}
	
	public void deleteAddress(Long Id)
	{
		Address_repo.deleteById(Id);
	}

	public Long saveAddress(Addresses address,Long addressId)
	{
//		Address_repo.save(address);
		return  address.getAddressID();
	}

}
