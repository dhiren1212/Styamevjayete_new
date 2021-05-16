package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.PoliceStation;
import com.satyamevjayate.api.repo.PoliceStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
@Service
public class PoliceStationServices {
    @Autowired
    private PoliceStationRepository policeStationRepository;

    public List<PoliceStation> listAllPoliceStation()
    {
        System.out.println(policeStationRepository.findAll());
        return policeStationRepository.findAll();
    }

    public Long savePoliceStation(PoliceStation policeStation)
    {
    	 policeStationRepository.save(policeStation);
    	 return policeStation.getPoliceStationID();
    }

    public PoliceStation getPoliceStation(Long Id)
    {
        return policeStationRepository.findById(Id).get();
    }

    public void deletePoliceStation(Long Id)
    {
        policeStationRepository.deleteById(Id);
    }
    public Long updatePoliceStation(PoliceStation policeStation,Long id)
    {
        policeStationRepository.save(policeStation);
        return id;
    }


}
