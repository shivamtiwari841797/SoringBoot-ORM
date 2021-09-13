package com.company.day05ormapp;

import com.company.day05ormapp.lab07.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class Day05OrmAppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Day05OrmAppApplication.class, args);
    }

    @Autowired
    private PersonsDao personsDao;

    @Autowired
    private ConferenceService conferenceService;


    @Override
    public void run(String... args) {
        addPerson();
        updateAge();
        System.out.println(conferenceService.addTopic("topic-1", 5.0));
        System.out.println(conferenceService.getAllTopic());
        System.out.println(conferenceService.getTopic("topic-1"));

    }

    private void updateAge() {
        Optional<OldPerson> optPerson = personsDao.findById(0);
        if(optPerson.isPresent()) {
            OldPerson person = optPerson.get();
            person.setAge(45);
            personsDao.save(person);
        } else {
            System.out.println("Person with id not present");
        }
    }

    private void addPerson() {
        OldPerson person = new OldPerson();
        person.setAge(20);
        person.setName("Shivam");
        personsDao.save(person);
    }
}
