package com.johnhasgone.tracker.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.johnhasgone.tracker.dto.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TaskProducer {
    @Value("custom.kafka.task-created-topic")
    private String taskCreatedTopic;
    @Value("custom.kafka.task-assigned-topic")
    private String taskAssignedTopic;
    @Value("custom.kafka.task-completed-topic")
    private String taskCompletedTopic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void sendTaskAssigned(TaskDto taskD) {
        String msg = null;
        try {
            msg = objectMapper.writeValueAsString(taskD);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        kafkaTemplate.send(taskAssignedTopic, msg);
    }

    public void sendTaskCreated(TaskDto taskDto) throws JsonProcessingException {
        var msg = objectMapper.writeValueAsString(taskDto);
        kafkaTemplate.send(taskCreatedTopic, msg);
    }

    public void sendTaskCompleted(TaskDto taskDto) throws JsonProcessingException {
        var msg = objectMapper.writeValueAsString(taskDto);
        kafkaTemplate.send(taskCompletedTopic, msg);
    }
}
