package com.company.relationships.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepo personRepo;

    public void savePersons(int id, String name, int age) {
        personRepo.save(new Person(id, name, age));
    }
}
