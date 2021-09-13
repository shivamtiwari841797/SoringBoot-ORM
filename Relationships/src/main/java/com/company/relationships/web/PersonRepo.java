package com.company.relationships.web;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepo extends CrudRepository<Person, Integer> {

    List<Person> findByName(String name);
    Person findByNameAndAge(String name, int age);

    List<Person> findAll();
    List<Person> findAllByName(String name);
    List<Person> findAllByAge(int age);
    List<Person> findAllByNameOrAge(String name, int age);

    List<Person> findAllByNameInOrAgeIn(List<String> names, List<Integer> ages);

//    List<Person> getAllPersonsWithAgeBetween(int s, int e);

//    @Query("select * from persons p where p.age between ? and ?") //mysql wrong
    @Query("select p from Person p where p.age between :p1 and :p2") //jpa ql
    List<Person> getAllPersonsInAgeBetween(@Param("p1") int f, @Param("p2") int t);

    @Query(value = "select distinct name from persons", nativeQuery = true)
    List<String> getAllDistinctNames();
}
