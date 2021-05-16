package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.CrimeVictim;
import com.satyamevjayate.api.model.Crimevictimmodel;
import com.satyamevjayate.api.services.CrimeVictimServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class CrimeVictimController {
    @Autowired
    private CrimeVictimServices crimeVictimServices;

    @GetMapping("/crimevictim")
    public List<CrimeVictim> getAllCrimeVictim() {
        return crimeVictimServices.listAllCrimeVictim();
    }

    @GetMapping("/crimevictim/{id}")
    public Crimevictimmodel getCrimeVictim(@PathVariable Long id)
    {

        Crimevictimmodel CrimeVictim= crimeVictimServices.getCrimeVictim(id);
        return CrimeVictim;
    }

    @PostMapping("/crimevictim")
    public Long addCrimeVictim(@RequestBody CrimeVictim crimeVictim)
    {

        Long crimeVictimId= crimeVictimServices.saveCrimeVictim(crimeVictim);
        return crimeVictimId;

    }


    @DeleteMapping("/crimevictim/{id}")
    public String deleteCrimeVictim(@PathVariable Long id)
    {
        String res= crimeVictimServices.deleteCrimeVictim(id);;
        return res;
    }

    @PutMapping("/crimevictim/{id}")
    public Long editCrimeVictim(@RequestBody CrimeVictim crimeVictim, @PathVariable Long id) {

        crimeVictim.setCrimeVictimID(id);

        Long crimeVictimId= crimeVictimServices.saveCrimeVictim(crimeVictim);
        return crimeVictimId;

    }
}
