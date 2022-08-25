package com.website.rednation.event;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/vi")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/events/all")
    public List<Event> getAllEvents() {return eventRepository.findAll();}

    @PostMapping("/events/add")
    public Event createEvent(@RequestBody Event event) {
        return eventRepository.save(event);
    }

    @GetMapping("/events/get/{eventId}")
    public ResponseEntity<Event> getEventById(@PathVariable Integer eventId) {

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new EventNotFoundException("Event does not exist with that id :" + eventId));
        return ResponseEntity.ok(event);
    }

    @PutMapping("/events/update/{eventId}")
    public ResponseEntity < Event > updateEvent(@PathVariable Integer eventId, @RequestBody Event eventDetails) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new EventNotFoundException("Role does not exist with id :" + eventId));

        event.setEventId(eventDetails.getEventId());
        event.setEventName(eventDetails.getEventName());
        event.setEventDescription(eventDetails.getEventDescription());
        event.setStartDate(eventDetails.getStartDate());
        event.setEndDate(eventDetails.getEndDate());

        Event updatedEvent = eventRepository.save(event);
        return ResponseEntity.ok(updatedEvent);
    }

    @DeleteMapping("/events/delete/{roleId}")
    public ResponseEntity <Map< String, Boolean >> deleteRole(@PathVariable Integer eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new EventNotFoundException("Event not exist with id :" + eventId));

        eventRepository.delete(event);
        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
