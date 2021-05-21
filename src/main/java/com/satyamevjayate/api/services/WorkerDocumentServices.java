package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.WorkerDocument;
import com.satyamevjayate.api.repo.WorkerDocumentRepository;
import com.satyamevjayate.api.repo.WorkerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerDocumentServices {
    @Autowired
    private WorkerDocumentRepository workerDocumentRepository;


    
    public List<WorkerDocument> listAllWorkerDocument()
    {
        return workerDocumentRepository.findAll();
    }

    public Long saveWorkerDocument(WorkerDocument workerDocument)
    {
       workerDocumentRepository.save(workerDocument);
       return workerDocument.getDocumentID();
    }
    public Long updateWorkerDocument(WorkerDocument workerDocument,Long Id)
    {

        workerDocument.setDocumentID(Id);
        System.out.println(workerDocument);

        workerDocumentRepository.save(workerDocument);
        return workerDocument.getDocumentID();
    }

    public WorkerDocument getWorkerDocument(Long Id)
    {
        return workerDocumentRepository.findById(Id).get();
    }

    public void deleteWorkerDocument(Long Id)
    {
        workerDocumentRepository.deleteById(Id);
    }
}
