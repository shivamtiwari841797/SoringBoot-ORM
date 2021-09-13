package com.company.relationships;

import com.company.relationships.web.*;
import com.company.relationships.web.lab08.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Optional;

@SpringBootApplication
public class RelationshipsApplication implements CommandLineRunner {


    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private AccountService accountService;


    public static void main(String[] args) {
        SpringApplication.run(RelationshipsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        methodForLab08();
    }


    private void methodForLab08() {
        accountService.deposit("101", 2000);
        accountService.deposit("102", 4000);
        accountService.withdraw("102", 5000);
        accountService.withdraw("101", 1000);
    }

    private void method1() {
        personService.savePersons(1, "2", 3);
        System.out.println("Done");
        savePersonWithCar();
    }

    private void method2() {
        Optional<Person> personOptional = personRepo.findById(1);
        if(personOptional.isPresent()) {
            Person person = personOptional.get();
            System.out.println(person);
            System.out.println(person.getCars());
        }
    }

    private void savePersonWithCar() {
        Person p1 = new Person();
        p1.setAge(23);
        p1.setName("P1");
        p1.setId(1);

        Car c1 = new Car();
        c1.setModel("model");
        c1.setYear(2000);
        c1.setId(123);

        c1.setOwner(p1);
        p1.setCars(Arrays.asList(c1));

        personRepo.save(p1);
    }
}
