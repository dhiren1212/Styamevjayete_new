package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.CrimeVictimDocument;
import com.satyamevjayate.api.services.CrimeVictimDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

public class CrimeVictimDocumentController {
    @Autowired
    private CrimeVictimDocumentService crimeVictimDocumentService;

    @GetMapping("/crimevictimdocument")
    public List<CrimeVictimDocument> getAllCrimeVictimDocument() {
        return crimeVictimDocumentService.listAllCrimeVictimDocument();
    }

    @GetMapping("/crimevictimdocument/{id}")
    public CrimeVictimDocument getCrimeVictimDocument(@PathVariable Long id)
    {

        CrimeVictimDocument CrimeVictimDocument= crimeVictimDocumentService.getCrimeVictimDocument(id);
        return CrimeVictimDocument;



    }

    @PostMapping("/crimevictimdocument")
    public Long addCrimeVictimDocument(@RequestBody CrimeVictimDocument crimeVictimDocument)
    {
       Long id=  crimeVictimDocumentService.saveCrimeVictimDocument(crimeVictimDocument);;
        return id;
    }


    @DeleteMapping("/crimevictimdocument/{id}")
    public String deleteCrimeVictimDocument(@PathVariable Long id)
    {
        crimeVictimDocumentService.deleteCrimeVictimDocument(id);;
        return "Delete CrimeVictimDocument Successfully";
    }

    @PutMapping("/crimevictimdocument/{id}")
    public Long editCrimeVictimDocument(@RequestBody CrimeVictimDocument CrimeVictimDocument, @PathVariable BigInteger id) {

        Long crimeVictimDocumentid= crimeVictimDocumentService.saveCrimeVictimDocument(CrimeVictimDocument);

        return crimeVictimDocumentid;
    }
}
