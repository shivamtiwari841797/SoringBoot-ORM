package com.company.day05ormapp.lab07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenceService {

    @Autowired
    private TopicDao topicDao;

    public boolean addTopic(String title, double duration) {
        try {
            Topic topic = new Topic();
            topic.setId(1234);
            topic.setDuration(duration);
            topic.setTitle(title);
            topicDao.save(topic);
            return true;
        } catch (DuplicateKeyException ex) {
            return false;
        }
    }
    public Topic getTopic(String title) {
        return topicDao.findByTitle(title);
    }

    public List<Topic> getAllTopic() {
        return (List<Topic>) topicDao.findAll();
    }

}
