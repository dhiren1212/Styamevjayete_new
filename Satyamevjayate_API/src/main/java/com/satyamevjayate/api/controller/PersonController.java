package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.Person;
import com.satyamevjayate.api.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
@RestController
public class PersonController {
    @Autowired
    private PersonServices personServices;
    @GetMapping("/GetAllPerson")
    public List<Person> getAllPerson() {
        return personServices.listAllPerson();
    }
    @GetMapping("/GetPerson/{id}")
    public Person getPerson(@PathVariable Long id)
    {
        Person person = personServices.getPerson(id);
        return person;
    }
    @PostMapping("/AddPerson")
    public String addPerson(@RequestBody Person person)
    {
        personServices.savePerson(person);;
        return "Person Add Successfully";
    }
    @DeleteMapping("/DeletePerson/{id}")
    public String deletePerson(@PathVariable Long id)
    {
        personServices.deletePerson(id);
        return "Delete Person Successfully";
    }

    @PutMapping("/EditPerson/{id}")
    public Long editPerson(@RequestBody Person person, @PathVariable Long id) {
       Long personId=personServices.updatePerson(person,id);
        return personId;
    }

}