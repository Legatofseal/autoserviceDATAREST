package com.autoservice.service;


import com.autoservice.exception.AlreadyExistsException;
import com.autoservice.exception.NotFoundException;
import com.autoservice.model.Person;
import com.autoservice.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PersonService {

    private final PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Person create(Person person) {


        // Example of custom logic
        if (person.getId() != null && repository.findOne(person.getId()) != null) {
            throw new AlreadyExistsException("Person", person.getId());
        }

        Person result = repository.save(person);
        return person;
    }

    public Person get(Long id) {
        Person person = repository.findOne(id);
        if (person == null) {
            throw new NotFoundException("Person", id);
        }
        return person;
    }

    public List<Person> getAll() {
        // Java 8 magic!
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public List<Person> searchByName(String name) {

        return repository.findByPersonName(name);
    }
    public List<Person> searchByAge(double age) {

        return repository.findByPersonAge(age);
    }

}
