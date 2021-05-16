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
    private WorkerService workerService;

    @GetMapping("/worker")
    public List<Worker> getAllWorker() {
        return workerService.listAllWorker();
    }

    @GetMapping("/worker/{id}")
    public Worker getWorker(@PathVariable Long id)
    {
        Worker w= workerService.getWorker(id);
        return w;
    }

    @PostMapping("/worker")
    public Long addWorker(@RequestBody Worker w)
    {
        Long workerID= workerService.editWorker(w);

        return workerID;

    }

    @DeleteMapping("/worker/{id}")
    public String deleteWorker(@PathVariable Long id)
    {
        workerService.deleteWorker(id);
        return "Worker Delete successfully";
    }

    @PutMapping("/worker/{id}")
    public Long  editWorker(@RequestBody Worker Worker, @PathVariable Long id) {


        Long workerID= workerService.editWorker(Worker);

        return workerID;
    }

}
