package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Addresses;
import com.satyamevjayate.api.entity.Contact;
import com.satyamevjayate.api.entity.Person;
import com.satyamevjayate.api.entity.Worker;
import com.satyamevjayate.api.repo.AddressesRepository;
import com.satyamevjayate.api.repo.ContactRepository;
import com.satyamevjayate.api.repo.PersonRepository;
import com.satyamevjayate.api.repo.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Lob;
import java.math.BigInteger;
import java.util.List;
@Service
public class WorkerService {
    @Autowired
    private WorkerRepository Worker_repo;
    
    @Autowired
    private AddressesRepository address_repo;
    
    @Autowired
    private ContactRepository contact_repo;
    
    @Autowired
    private PersonRepository person_repo;
    

    public List<Worker> listAllWorker()
    {
        return Worker_repo.findAll();
    }

    public Worker saveWorker(Worker worker)
    {
        address_repo.save(worker.getWorkerResidentAddress());
        address_repo.save(worker.getWorkerPermanentAddress());
        contact_repo.save(worker.getWorkerContact());
        person_repo.save(worker.getWorkerPerson());
       return Worker_repo.save(worker);
    }
    public Worker editWorker(Worker worker, Long Id)
    {
       return Worker_repo.save(worker);
    }

    public Worker getWorker(BigInteger Id)
    {
        return Worker_repo.findById(Id).get();
    }

    public void deleteWorker(BigInteger Id)
    {
        Worker_repo.deleteById(Id);
    }
}
