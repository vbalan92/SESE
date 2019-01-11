package tuwien.at.sese.hotelreservation.service;


import java.util.List;

import tuwien.at.sese.hotelreservation.api.dto.EventDTO;
import tuwien.at.sese.hotelreservation.model.Event;

/**
 * The interface eventService.
 */
public interface EventService {

    /**
     * Creates the.
     *
     * @param event the event
     * @return the event
     */
    EventDTO create(EventDTO event);

    /**
     * Delete.
     *
     * @param id the id
     * @return the event
     */
    Event delete(Long id);

    /**
     * Find all.
     *
     * @return the list
     */
    List<Event> findAll();

    /**
     * Find by id.
     *
     * @param id the id
     * @return the event
     */
    Event findById(Long id);

    /**
     * Update.
     *
     * @param event the event
     * @return the event
     */
    EventDTO update(EventDTO event);
}
