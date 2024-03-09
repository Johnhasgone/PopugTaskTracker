package com.johnhasgone.auth.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.johnhasgone.auth.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AccountProducer {
    @Value("custom.kafka.be-topic")
    private String beTopic;
    @Value("custom.kafka.cut-topic")
    private String cudTopic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void sendCud(AccountDto accountDto) throws JsonProcessingException {
        var msg = objectMapper.writeValueAsString(accountDto);
        kafkaTemplate.send(cudTopic, msg);
    }

    public void sendBe(AccountDto accountDto) throws JsonProcessingException {
        var msg = objectMapper.writeValueAsString(accountDto);
        kafkaTemplate.send(beTopic, msg);
    }
}
