package com.journaling.Journaling.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.journaling.Journaling.Entities.Journal;
import com.journaling.Journaling.Service.JournalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

@Service
public class Consumer {
    private static final Logger log = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    JournalService journalService;


    @KafkaListener(topics = "user_event", groupId = "journal")
    public void readMessage(String message) throws JsonProcessingException, SQLException {
        try {
            log.info("Received message: " + message);
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> member = objectMapper.readValue(message, Map.class);
            String createdBy = member.get("created_by");
            String event = member.get("event");
            String data = member.get("data");
            //serialise the message and save it to the database

            Journal j = new Journal();
            j.setCreated_by(createdBy);
            j.setCreated_on(new Date());
            j.setData(data);
            j.setEvent(event);
            journalService.saveJournal(j);
        } catch (JsonProcessingException e) {
            log.error("Error in processing message: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
