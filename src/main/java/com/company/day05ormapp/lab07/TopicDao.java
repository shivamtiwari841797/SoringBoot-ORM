package com.company.day05ormapp.lab07;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TopicDao extends CrudRepository<Topic, Integer> {

    Topic findByTitle(String title);
}
