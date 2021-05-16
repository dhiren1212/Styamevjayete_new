package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.Crime;
import com.satyamevjayate.api.services.CrimeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CrimeController {
    @Autowired
    private CrimeServices crimeServices;

    @GetMapping("/crime")
    public List<Crime> getAllCrime() {
        return crimeServices.listAllCrime();
    }

    @GetMapping("/crime/{id}")
    public Crime getCrime(@PathVariable Long id)
    {

        Crime Crime= crimeServices.getCrime(id);
        return Crime;

    }

    @PostMapping("/crime")
    public Long addCrime(@RequestBody Crime Crime)
    {
        Long id= crimeServices.saveCrime(Crime);;
        return id;

    }


    @DeleteMapping("/crime/{id}")
    public String deleteCrime(@PathVariable Long id)
    {
        crimeServices.deleteCrime(id);;
        return "Delete Crime Successfully";
    }

    @PutMapping("/crime/{id}")
    public Long editCrime(@RequestBody Crime Crime, @PathVariable Long id) {
        Long crimeID= crimeServices.saveCrime(Crime);;
        return crimeID;
    }

}
