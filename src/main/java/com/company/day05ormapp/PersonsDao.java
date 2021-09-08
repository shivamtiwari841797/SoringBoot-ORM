package com.company.day05ormapp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonsDao extends CrudRepository<Person, Integer> {
}
