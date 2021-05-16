package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.CriminalDocument;
import com.satyamevjayate.api.services.CriminalDocumentservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CriminalDocumentController {
    @Autowired
    private CriminalDocumentservices criminalDocumentservices;

    @GetMapping("/criminaldocument")
    public List<CriminalDocument> getAllCriminalDocument() {
        return criminalDocumentservices.listAllCriminalDocument();
    }

    @GetMapping("/criminaldocument/{id}")
    public CriminalDocument getCriminalDocument(@PathVariable Long id)
    {

        CriminalDocument CriminalDocument= criminalDocumentservices.getCriminalDocument(id);
        return CriminalDocument;



    }

    @PostMapping("/criminaldocument")
    public Long addCriminalDocument(@RequestBody CriminalDocument CriminalDocument)
    {
        Long documentID= criminalDocumentservices.saveCriminalDocument(CriminalDocument);

        return documentID;
    }


    @DeleteMapping("/criminaldocument/{id}")
    public String deleteCriminalDocument(@PathVariable Long id)
    {
        criminalDocumentservices.deleteCriminalDocument(id);;
        return "Delete CriminalDocument Successfully";
    }

    @PutMapping("/criminaldocument/{id}")
    public Long editCriminalDocument(@RequestBody CriminalDocument CriminalDocument, @PathVariable Long id) {

        Long documentID= criminalDocumentservices.updateCriminalDocument(CriminalDocument,id);

        return documentID;
    }
}
