package com.journaling.Journaling.Service;

import com.journaling.Journaling.Entities.Journal;
import com.journaling.Journaling.Repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalService {
    @Autowired
    JournalRepository journalRepository;

    public void saveJournal(Journal j) {
        journalRepository.save(j);
    }

    public Journal getJournalById(String createdBy) {
        return journalRepository.findAllByCreatedBy(createdBy);
    }

    public List<Journal> findAllByEvent(String event) {
        return  journalRepository.findAllByEvent(event);
    }
}
