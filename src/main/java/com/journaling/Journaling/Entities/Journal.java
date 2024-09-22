package com.journaling.Journaling.Entities;

import jakarta.persistence.*;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;

@Entity
public class Journal {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String event;
    private  String data = new String(new char[2048]);
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    private String createdBy;

    public Journal() {
    }

    public Journal(String event, String data, Date created_on, String created_by) throws SQLException {
        this.event = event;
        this.data = data;
        this.createdOn = created_on;
        this.createdBy = created_by;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data.toString();
    }

    public void setData(String data) throws SQLException {
        this.data = data;
    }

    public Date getCreated_on() {
        return createdOn;
    }

    public void setCreated_on(Date created_on) {
        this.createdOn = created_on;
    }

    public String getCreated_by() {
        return createdBy;
    }

    public void setCreated_by(String created_by) {
        this.createdBy = created_by;
    }
}
