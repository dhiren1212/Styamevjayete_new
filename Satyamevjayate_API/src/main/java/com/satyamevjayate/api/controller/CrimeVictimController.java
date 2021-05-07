package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.CrimeVictim;
import com.satyamevjayate.api.model.Crimevictimmodel;
import com.satyamevjayate.api.services.CrimeVictimServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
@RestController
public class CrimeVictimController {
    @Autowired
    private CrimeVictimServices CrimeVictimServices;

    @GetMapping("/crimevictim")
    public List<CrimeVictim> getAllCrimeVictim() {
        return CrimeVictimServices.listAllCrimeVictim();
    }

    @GetMapping("/crimevictim/{id}")
    public Crimevictimmodel getCrimeVictim(@PathVariable BigInteger id)
    {

        Crimevictimmodel CrimeVictim= CrimeVictimServices.getCrimeVictim(id);
        return CrimeVictim;



    }

    @PostMapping("/crimevictim")
    public String addCrimeVictim(@RequestBody CrimeVictim CrimeVictim)
    {

        CrimeVictimServices.saveCrimeVictim(CrimeVictim);;
        return "CrimeVictim Add Successfully";
    }


    @DeleteMapping("/crimevictim/{id}")
    public String deleteCrimeVictim(@PathVariable BigInteger id)
    {
        String res= CrimeVictimServices.deleteCrimeVictim(id);;
        return res;
    }

    @PutMapping("/crimevictim/{id}")
    public ResponseEntity<Object> editCrimeVictim(@RequestBody CrimeVictim CrimeVictim, @PathVariable BigInteger id) {

        CrimeVictim.setCrimeVictimID(id);

        CrimeVictimServices.saveCrimeVictim(CrimeVictim);

        return ResponseEntity.noContent().build();
    }
}
