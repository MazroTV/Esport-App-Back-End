package com.website.rednation.event;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @Column(name = "event_id)")
    private Integer id;

    @Column(name = "event_name")
    private String eventName;

    @Column(name="event_description")
    private String eventDescription;

    @Column (name = "start_date")
    private LocalDate startDate;

    @Column (name = "end_date")
    private LocalDate endDate;

    public Event(){

    }

    public Event (Integer id, String eventName, String eventDescription, LocalDate startDate, LocalDate endDate){
        this.id = id;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getEventId() {
        return id;
    }

    public void setEventId(Integer id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
