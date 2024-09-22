package com.journaling.Journaling;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JournalRequest {
    private String event;

    @Override
    public String toString() {
        return "JournalRequest{" +
                "event='" + event + '\'' +
                '}';
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public JournalRequest(String event) {
        this.event = event;
    }
}
