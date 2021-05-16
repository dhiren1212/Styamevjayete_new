package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Worker;
import com.satyamevjayate.api.repo.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WorkerService {
    @Autowired
    private WorkerRepository Worker_repo;


    public List<Worker> listAllWorker()
    {
        return Worker_repo.findAll();
    }

    public Long saveWorker(Worker worker)
    {
        Worker_repo.save(worker);
        return worker.getWorkerID();
    }
    public Long editWorker(Worker worker, Long id)
    {
        Worker_repo.save(worker);
        return worker.getWorkerID();
    }

    public Worker getWorker(Long Id)
    {
        return Worker_repo.findById(Id).get();
    }

    public void deleteWorker(Long Id)
    {
        Worker_repo.deleteById(Id);
    }
}
