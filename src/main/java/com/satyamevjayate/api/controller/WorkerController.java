package com.satyamevjayate.api.controller;
import com.satyamevjayate.api.entity.Worker;
import com.satyamevjayate.api.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class WorkerController {
    @Autowired
    private WorkerService WorkerService;

    @GetMapping("/worker")
    public List<Worker> getAllWorker() {
        return WorkerService.listAllWorker();
    }

    @GetMapping("/worker/{id}")
    public Worker getWorker(@PathVariable BigInteger id)
    {
        Worker w= WorkerService.getWorker(id);
        return w;
    }

    @PostMapping("/worker")
    public String addWorker(@RequestBody Worker w)
    {
        WorkerService.saveWorker(w);
        return "Worker Add successfully";

    }

    @DeleteMapping("/worker/{id}")
    public String deleteWorker(@PathVariable BigInteger id)
    {
        WorkerService.deleteWorker(id);
        return "Worker Delete successfully";
    }

    @PutMapping("/worker/{id}")
    public ResponseEntity<Object> editWorker(@RequestBody Worker Worker, @PathVariable BigInteger id) {


        Worker.setWorkerID(id);

        WorkerService.editWorker(Worker);

        return ResponseEntity.noContent().build();
    }

}
