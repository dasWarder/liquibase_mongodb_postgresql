package com.example.double_db.controller;


import com.example.double_db.entity.Person;
import com.example.double_db.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping(value = "/persons")
    public List<Person> getAll() {
        return personService.getAll();
    }
}
