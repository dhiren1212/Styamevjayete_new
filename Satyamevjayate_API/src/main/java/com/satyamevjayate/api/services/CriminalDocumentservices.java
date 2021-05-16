package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.CriminalDocument;
import com.satyamevjayate.api.repo.CriminalDocumentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriminalDocumentservices {
    @Autowired
    private CriminalDocumentRepository CriminalDocument_repo;

    public List<CriminalDocument> listAllCriminalDocument()
    {
        return CriminalDocument_repo.findAll();
    }

    public Long saveCriminalDocument(CriminalDocument criminalDocument)
    {
        CriminalDocument_repo.save(criminalDocument);
        return criminalDocument.getCriminalID();
    }

    public CriminalDocument getCriminalDocument(Long Id)
    {
        return CriminalDocument_repo.findById(Id).get();
    }

    public void deleteCriminalDocument(Long Id)
    {
        CriminalDocument_repo.deleteById(Id);
    }

    public Long updateCriminalDocument(CriminalDocument criminalDocument,Long id)
    {
        CriminalDocument_repo.save(criminalDocument);
        return criminalDocument.getCriminalID();
    }
}
