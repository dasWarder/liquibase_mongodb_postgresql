package com.example.double_db.service;

import com.example.double_db.entity.Person;
import com.example.double_db.repository.IssueRepository;
import com.example.double_db.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableMongoRepositories(basePackageClasses = { IssueRepository.class })
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getAll() {
        return (List<Person>) personRepository.findAll();
    }
}
