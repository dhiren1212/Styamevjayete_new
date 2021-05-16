package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Crime;
import com.satyamevjayate.api.entity.CrimeImage;
import com.satyamevjayate.api.repo.CrimeImageRepository;
import com.satyamevjayate.api.repo.CrimeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class CrimeImageServices {
    @Autowired
    private CrimeImageRepository CrimeImage_repo;
    
    @Autowired
    private CrimeRepository crime_repo;

    public List<CrimeImage> listAllCrimeImage()
    {
        return CrimeImage_repo.findAll();
    }

    public Long saveCrimeImage(CrimeImage crimeImage)
    {
//    	 Crime crime = crime_repo.findById(CrimeImage.getImageCrimeId().getCrimeID()).orElse(null);
//	        if (null == crime) {
//	            crime = new Crime();
//	        }
//	        crime.setCrimeID(CrimeImage.getImageCrimeId().getCrimeID());
//	        CrimeImage.setImageCrimeId(crime);
	        CrimeImage_repo.save(crimeImage);
	        return crimeImage.getCrimeImageID();

    }

    public CrimeImage getCrimeImage(Long Id)
    {
        return CrimeImage_repo.findById(Id).get();
    }

    public void deleteCrimeImage(Long Id)
    {
        CrimeImage_repo.deleteById(Id);
    }

    public Long updateCrimeIamge(CrimeImage crimeImage,Long crimeImageId)
    {
        return crimeImageId;
    }
}
