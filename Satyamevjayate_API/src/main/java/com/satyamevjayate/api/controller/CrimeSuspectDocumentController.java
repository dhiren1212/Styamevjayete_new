package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.CrimeSuspectDocument;
import com.satyamevjayate.api.services.CrimeSuspectDocumentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

public class CrimeSuspectDocumentController {
    @Autowired
    private CrimeSuspectDocumentServices crimeSuspectDocumentServices;

    @GetMapping("/crimesuspectdocument")
    public List<CrimeSuspectDocument> getAllCrimeSuspectDocument() {
        return crimeSuspectDocumentServices.listAllCrimeSuspectDocument();
    }

    @GetMapping("/crimesuspectdocument/{id}")
    public CrimeSuspectDocument getCrimeSuspectDocument(@PathVariable Long id)
    {

        CrimeSuspectDocument crimeSuspectDocument= crimeSuspectDocumentServices.getCrimeSuspectDocument(id);
        return crimeSuspectDocument;
    }

    @PostMapping("/crimesuspectdocument")
    public Long addCrimeSuspectDocument(@RequestBody CrimeSuspectDocument crimeSuspectDocument)
    {
        Long documentID=crimeSuspectDocumentServices.saveCrimeSuspectDocument(crimeSuspectDocument);

        return documentID;
    }


    @DeleteMapping("/crimesuspectdocument/{id}")
    public String deleteCrimeSuspectDocument(@PathVariable Long id)
    {
        crimeSuspectDocumentServices.deleteCrimeSuspectDocument(id);
        return "Delete CrimeSuspectDocument Successfully";
    }

    @PutMapping("/crimesuspectdocument/{id}")
    public Long editCrimeSuspectDocument(@RequestBody CrimeSuspectDocument crimeSuspectDocument, @PathVariable Long id) {

        Long documentID=crimeSuspectDocumentServices.saveCrimeSuspectDocument(crimeSuspectDocument);

        return documentID;
    }
}
