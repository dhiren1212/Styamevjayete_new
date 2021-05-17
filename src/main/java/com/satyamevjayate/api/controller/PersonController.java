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
    private PersonServices PersonServices;
    @GetMapping("/GetAllPerson")
    public List<Person> getAllPerson() {
        return PersonServices.listAllPerson();
    }
    @GetMapping("/GetPerson/{id}")
    public Person getPerson(@PathVariable BigInteger id)
    {
        Person Person= PersonServices.getPerson(id);
        return Person;
    }
    @PostMapping("/AddPerson")
    public String addPerson(@RequestBody Person Person)
    {
        PersonServices.savePerson(Person);;
        return "Person Add Successfully";
    }
    @DeleteMapping("/DeletePerson/{id}")
    public String deletePerson(@PathVariable BigInteger id)
    {
        PersonServices.deletePerson(id);
        return "Delete Person Successfully";
    }

    @PutMapping("/EditPerson/{id}")
    public ResponseEntity<Object> editPerson(@RequestBody Person Person, @PathVariable BigInteger id) {
        Person.setPersonId(id);;
        PersonServices.savePerson(Person);
        return ResponseEntity.noContent().build();
    }

}