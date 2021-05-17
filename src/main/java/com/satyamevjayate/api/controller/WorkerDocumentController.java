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
    private WorkerDocumentServices WorkerDocumentServices;

    @GetMapping("/workerdocument")
    public List<WorkerDocument> getAllWorkerDocument() {
        return WorkerDocumentServices.listAllWorkerDocument();
    }

    @GetMapping("/workerdocument/{id}")
    public WorkerDocument getWorkerDocument(@PathVariable Long id)
    {

        WorkerDocument WorkerDocument= WorkerDocumentServices.getWorkerDocument(id);
        return WorkerDocument;



    }

    @PostMapping("/workerdocument")
    public String addWorkerDocument(@RequestBody WorkerDocument WorkerDocument)
    {
        WorkerDocumentServices.saveWorkerDocument(WorkerDocument);
        return "WorkerDocument Add Successfully";
    }


    @DeleteMapping("/workerdocument/{id}")
    public String deleteWorkerDocument(@PathVariable Long id)
    {
        WorkerDocumentServices.deleteWorkerDocument(id);;
        return "Delete WorkerDocument Successfully";
    }

    @PutMapping("/workerdocument/{id}")
    public ResponseEntity<Object> editWorkerDocument(@RequestBody WorkerDocument WorkerDocument, @PathVariable Long id) {

//        WorkerDocument.set
        WorkerDocumentServices.saveWorkerDocument(WorkerDocument);

        return ResponseEntity.noContent().build();
    }
}
