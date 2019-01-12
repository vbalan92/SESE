package tuwien.at.sese.hotelreservation.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tuwien.at.sese.hotelreservation.api.dto.EventDTO;
import tuwien.at.sese.hotelreservation.model.Event;
import tuwien.at.sese.hotelreservation.service.EventService;

/**
 * The Class EventController.
 */
@RestController
@RequestMapping({"/api/events"})
public class EventController {

    @Autowired
    private EventService eventService;

    /**
     * Creates the.
     *
     * @param eventDTO the EventDTO
     * @return the EventDTO
     */
    @PostMapping
    public EventDTO create(@RequestBody EventDTO eventDTO){

        return eventService.create(eventDTO);
    }

    /**
     * Find one.
     *
     * @param id the id
     * @return the Event
     */
    @GetMapping(path = {"/{id}"})
    public Event findOne(@PathVariable("id") Long id){
        return eventService.findById(id);
    }

    /**
     * Update.
     *
     * @param id the id
     * @param Event the Event
     * @return the Event
     */
    @PutMapping(path = {"/{id}"})
    public EventDTO update(@PathVariable("id") Long id, @RequestBody EventDTO Event)
    {
        return eventService.update(Event);
    }

    /**
     * Delete.
     *
     * @param id the id
     * @return the Event
     */
    @DeleteMapping(path ={"/{id}"})
    public Event delete(@PathVariable("id") Long id) {
        return eventService.delete(id);
    }

    /**
     * Find all.
     *
     * @return the list
     */
    @GetMapping
    public List<EventDTO> findAll(){
        return eventService.findAll().stream()
            .map(EventDTO::new)
            .collect(Collectors.toList());
    }
}