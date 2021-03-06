package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.WorkerDocument;
import com.satyamevjayate.api.services.WorkerDocumentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkerDocumentController {
    @Autowired
    private WorkerDocumentServices workerDocumentServices;

    @GetMapping("/workerdocument")
    public List<WorkerDocument> getAllWorkerDocument() {
        return workerDocumentServices.listAllWorkerDocument();
    }

    @GetMapping("/workerdocument/{id}")
    public WorkerDocument getWorkerDocument(@PathVariable Long id)
    {

        WorkerDocument WorkerDocument= workerDocumentServices.getWorkerDocument(id);
        return WorkerDocument;



    }

    @PostMapping("/workerdocument")
    public String addWorkerDocument(@RequestBody WorkerDocument WorkerDocument)
    {
        workerDocumentServices.saveWorkerDocument(WorkerDocument);
        return "WorkerDocument Add Successfully";
    }


    @DeleteMapping("/workerdocument/{id}")
    public String deleteWorkerDocument(@PathVariable Long id)
    {
        workerDocumentServices.deleteWorkerDocument(id);;
        return "Delete WorkerDocument Successfully";
    }

    @PutMapping("/workerdocument/{id}")
    public Long editWorkerDocument(@RequestBody WorkerDocument WorkerDocument, @PathVariable Long id) {

       Long workerDocumentId=workerDocumentServices.updateWorkerDocument(WorkerDocument,id);

        return workerDocumentId;
    }
}
