package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Criminal;
import com.satyamevjayate.api.repo.CriminalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriminalServices {
    @Autowired
    private CriminalRepository criminalRepository;

    public List<Criminal> listAllCriminal()
    {
        return criminalRepository.findAll();
    }

    public Long saveCriminal(Criminal criminal)
    {
        criminalRepository.save(criminal);
    	return criminal.getCriminalID();
    }

    public Long editCriminal(Criminal criminal ,Long id)
  {
      criminalRepository.save(criminal);
      return criminal.getCriminalID();
    }
    
    public Criminal getCriminal(Long Id)
    {
        return criminalRepository.findById(Id).get();
    }

    public void deleteCriminal(Long Id)
    {
        criminalRepository.deleteById(Id);
    }
}
