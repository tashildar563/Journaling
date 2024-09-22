package com.journaling.Journaling.Response;

public class JournalResponse {

    private Long id;
    private String createdBy;
    private String event;
    private String date;
    private String time;

    public JournalResponse() {
    }

    public JournalResponse(Long id, String createdBy, String event, String date, String time) {
        this.id = id;
        this.createdBy = createdBy;
        this.event = event;
        this.date = date;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
