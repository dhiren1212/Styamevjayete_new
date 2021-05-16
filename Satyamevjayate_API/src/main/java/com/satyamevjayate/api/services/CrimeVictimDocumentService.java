package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.CrimeVictim;
import com.satyamevjayate.api.entity.CrimeVictimDocument;
import com.satyamevjayate.api.repo.CrimeVictimDocumentRepository;
import com.satyamevjayate.api.repo.CrimeVictimRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.List;

public class CrimeVictimDocumentService {
    @Autowired
    private CrimeVictimDocumentRepository CrimeVictimDocument_repo;

    public List<CrimeVictimDocument> listAllCrimeVictimDocument()
    {
        return CrimeVictimDocument_repo.findAll();
    }

    public Long saveCrimeVictimDocument(CrimeVictimDocument crimeVictimDocument)
    {
         CrimeVictimDocument_repo.save(crimeVictimDocument);
        return crimeVictimDocument.getCrimeVictimDocumentID();
    }

    public CrimeVictimDocument getCrimeVictimDocument(Long Id)
    {
        return CrimeVictimDocument_repo.findById(Id).get();
    }

    public void deleteCrimeVictimDocument(Long Id)
    {
        CrimeVictimDocument_repo.deleteById(Id);
    }

    public Long updateCrimeVictimDocument(CrimeVictimDocument crimeVictimDocument, Long id)
    {
        CrimeVictimDocument_repo.save(crimeVictimDocument);
        return crimeVictimDocument.getCrimeVictimDocumentID();
    }
}
