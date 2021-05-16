package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.WorkerDocument;
import com.satyamevjayate.api.repo.WorkerDocumentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Long updateWorkerDocument(WorkerDocument workerDocument,Long id)
    {
        workerDocumentRepository.save(workerDocument);
        return id;
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
