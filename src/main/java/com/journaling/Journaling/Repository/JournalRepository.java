package com.journaling.Journaling.Repository;

import com.journaling.Journaling.Entities.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JournalRepository extends JpaRepository<Journal,Long> {
    Journal findAllByCreatedBy(String createdBy);

    List<Journal> findAllByEvent(String event);
}
