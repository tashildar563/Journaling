package com.journaling.Journaling;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.journaling.Journaling.Entities.Journal;
import com.journaling.Journaling.Service.JournalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping({"/journal"})
public class MyController {

    @Autowired
    JournalService journalService;

    public MyController() {
    }

    @PostMapping({"/get"})
    public ResponseEntity<List<Map<String, Object>>> getUserEvents(@RequestBody @Valid JournalRequest request) throws JsonProcessingException {
        System.out.println("Request received for event: " + request.toString());
        List<Journal> journals = this.journalService.findAllByEvent(request.getEvent());
        List<Map<String, Object>> response = new ArrayList<>();
        for (Journal journal : journals) {
            Map<String, Object> newJournal = new HashMap<>();
            newJournal.put("id", String.valueOf(journal.getId()));
            newJournal.put("event", journal.getEvent());
            ObjectMapper objectMapper = new ObjectMapper();
            newJournal.put("data", objectMapper.readValue(journal.getData(), Map.class));
            newJournal.put("created_by", journal.getCreated_by());
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String formattedDate = formatter.format(journal.getCreated_on());
            newJournal.put("created_on", formattedDate);
            response.add(newJournal);
        }
        return new ResponseEntity(response, HttpStatus.FOUND);
    }
}
