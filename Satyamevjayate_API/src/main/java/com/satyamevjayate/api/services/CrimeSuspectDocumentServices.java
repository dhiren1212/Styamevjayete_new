package com.satyamevjayate.api.services;


import com.satyamevjayate.api.entity.Crime;
import com.satyamevjayate.api.entity.CrimeSuspect;
import com.satyamevjayate.api.entity.CrimeSuspectDocument;
import com.satyamevjayate.api.repo.CrimeSuspectDocumentRepository;
import com.satyamevjayate.api.repo.CrimeSuspectRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.List;

public class CrimeSuspectDocumentServices {
    @Autowired
    private CrimeSuspectDocumentRepository CrimeSuspectDocument_repo;

    public List<CrimeSuspectDocument> listAllCrimeSuspectDocument()
    {
        return CrimeSuspectDocument_repo.findAll();
    }

    public Long saveCrimeSuspectDocument(CrimeSuspectDocument crimeSuspectDocument)
    {
        CrimeSuspectDocument_repo.save(crimeSuspectDocument);
    	return crimeSuspectDocument.getDocumentID();
    }

    public CrimeSuspectDocument getCrimeSuspectDocument(Long Id)
    {
        return CrimeSuspectDocument_repo.findById(Id).get();
    }

    public void deleteCrimeSuspectDocument(Long Id)
    {
        CrimeSuspectDocument_repo.deleteById(Id);
    }

    public Long updateCrimeSuspectDocument(CrimeSuspectDocument crimeSuspectDocument , Long Id){
        return Id;
    }
}
