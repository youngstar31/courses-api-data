package com.example.courseapidata.services;

import com.example.courseapidata.models.Topic;

import com.example.courseapidata.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

  private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "Spring Framework", "Spring Framework Description" ),
                new Topic("java", "Core Java", "Java Description" ),
                new Topic("javascript", "JavaScript", "JavaScript Description" )
  ));
  public List<Topic> getAllTopics(){

     //return topics;
      List<Topic> topics = new ArrayList<>();
     topicRepository.findAll().forEach(topics::add);
     return topics;
  }

  public Optional<Topic> getTopic(String id){

      return topicRepository.findById(id);
  }

    public void addTopic(Topic topic) {

      topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
      topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
      topics.removeIf(t -> t.getId().equals(id));
    }
}

