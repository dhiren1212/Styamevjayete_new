package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.CrimeSuspect;
import com.satyamevjayate.api.model.Crimesuspectmodel;
import com.satyamevjayate.api.services.CrimeSuspectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class CrimeSuspectController {
    @Autowired
private CrimeSuspectServices CrimeSuspectServices;

    @GetMapping("/crimesuspect")
    public List<CrimeSuspect> getAllCrimeSuspect() {
        return CrimeSuspectServices.listAllCrimeSuspect();
    }

    @GetMapping("/crimesuspect/{id}")
    public Crimesuspectmodel getCrimeSuspect(@PathVariable BigInteger id)
    {

        Crimesuspectmodel CrimeSuspect= CrimeSuspectServices.getCrimeSuspect(id);
        return CrimeSuspect;



    }

    @PostMapping("/crimesuspect")
    public String addCrimeSuspect(@RequestBody CrimeSuspect CrimeSuspect)
    {
        CrimeSuspectServices.saveCrimeSuspect(CrimeSuspect);;
        return "CrimeSuspect Add Successfully";
    }


    @DeleteMapping("/crimesuspect/{id}")
    public String deleteCrimeSuspect(@PathVariable BigInteger id)
    {
        String res= CrimeSuspectServices.deleteCrimeSuspect(id);
        return res;
    }

    @PutMapping("/crimesuspect/{id}")
    public String  editCrimeSuspect(@RequestBody CrimeSuspect CrimeSuspect, @PathVariable BigInteger id) {

        CrimeSuspect.setCrimeSuspectID(id);

        CrimeSuspectServices.saveCrimeSuspect(CrimeSuspect);

        return "CrimeSuspect Edit Successfully";
    }

}
