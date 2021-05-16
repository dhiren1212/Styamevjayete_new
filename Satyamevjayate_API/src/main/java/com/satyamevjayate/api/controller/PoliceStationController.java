package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.PoliceStation;
import com.satyamevjayate.api.services.PoliceStationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
@RestController
public class PoliceStationController {
    @Autowired
    private PoliceStationServices policeStationServices;

    @GetMapping("/GetAllPoliceStation")
    public List<PoliceStation> getAllPolice_Role() {
        return policeStationServices.listAllPoliceStation();
    }

    @GetMapping("/GetPoliceStation/{id}")
    public PoliceStation getPoliceStation(@PathVariable Long id)
    {
        PoliceStation p= policeStationServices.getPoliceStation(id);
        return p;
    }

    @PostMapping("/AddPoliceStation")
    public Long addPoliceStation(@RequestBody PoliceStation p)
    {
        Long policeStationID=policeStationServices.savePoliceStation(p);

        return policeStationID;

    }

    @DeleteMapping("/DeletePoliceStation/{id}")
    public String deletePoliceStation(@PathVariable Long id)
    {
        policeStationServices.deletePoliceStation(id);
        return "PoliceStation Delete successfully";
    }

    @PutMapping("/EditPoliceStation/{id}")
    public Long editPoliceStation(@RequestBody PoliceStation policeStation, @PathVariable Long id) {


        Long policeStationID=policeStationServices.updatePoliceStation(policeStation,id);

        return policeStationID;
    }
}
