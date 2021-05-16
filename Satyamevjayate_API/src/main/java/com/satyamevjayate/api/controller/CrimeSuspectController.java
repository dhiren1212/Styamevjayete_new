package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.CrimeSuspect;
import com.satyamevjayate.api.model.Crimesuspectmodel;
import com.satyamevjayate.api.services.CrimeSuspectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CrimeSuspectController {
    @Autowired
private CrimeSuspectServices crimeSuspectServices;

    @GetMapping("/crimesuspect")
    public List<CrimeSuspect> getAllCrimeSuspect() {
        return crimeSuspectServices.listAllCrimeSuspect();
    }

    @GetMapping("/crimesuspect/{id}")
    public Crimesuspectmodel getCrimeSuspect(@PathVariable Long id)
    {

        Crimesuspectmodel CrimeSuspect= crimeSuspectServices.getCrimeSuspect(id);
        return CrimeSuspect;

    }

    @PostMapping("/crimesuspect")
    public Long addCrimeSuspect(@RequestBody CrimeSuspect crimeSuspect)
    {
        Long id= crimeSuspectServices.saveCrimeSuspect(crimeSuspect);
        return id;
    }


    @DeleteMapping("/crimesuspect/{id}")
    public String deleteCrimeSuspect(@PathVariable Long id)
    {
        String res= crimeSuspectServices.deleteCrimeSuspect(id);
        return res;
    }

    @PutMapping("/crimesuspect/{id}")
    public Long  editCrimeSuspect(@RequestBody CrimeSuspect CrimeSuspect, @PathVariable Long id) {

        Long crimeSuspectID=crimeSuspectServices.saveCrimeSuspect(CrimeSuspect);

        return crimeSuspectID;
    }

}
