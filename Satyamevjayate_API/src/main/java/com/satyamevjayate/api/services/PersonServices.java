package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Person;
import com.satyamevjayate.api.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class PersonServices {
    @Autowired
    private PersonRepository person_repository;

    public List<Person> listAllPerson()
    {
        return person_repository.findAll();
    }

    public Long savePerson(Person person)
    {
        person_repository.save(person);
        return person.getPersonId();
    }

    public Person getPerson(Long Id)
    {
        return person_repository.findById(Id).get();
    }

    public void deletePerson(Long Id)
    {
        person_repository.deleteById(Id);
    }
    public Long updatePerson(Person person,Long id)
    {
        person_repository.save(person);
        return person.getPersonId();
    }

}
