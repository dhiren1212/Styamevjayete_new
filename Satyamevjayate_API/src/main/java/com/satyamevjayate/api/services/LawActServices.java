package com.satyamevjayate.api.services;
import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyamevjayate.api.entity.LawAct;

import com.satyamevjayate.api.repo.LawActRepository;

@Service
public class LawActServices {
	@Autowired
	private LawActRepository LawActRepo;
	
      public List<LawAct> listAllLawAct()
      {
    	  return LawActRepo.findAll();
      }
      
      public Long saveLawAct(LawAct lawact)
      {
    	  LawActRepo.save(lawact);
    	  return lawact.getLawID();
      }
      
      public LawAct getLawact(Long Id)
      {
    	  return LawActRepo.findById(Id).get();
      }
      
      public void  deleteLawact(Long Id)
      {
    	   LawActRepo.deleteById(Id);
      }

    public Long updateLawAct(LawAct lawact,Long id)
    {
        LawActRepo.save(lawact);
        return id;
    }


}
