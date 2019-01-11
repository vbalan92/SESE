package tuwien.at.sese.hotelreservation.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import tuwien.at.sese.hotelreservation.model.Event;

/**
 * The Interface EventRepository.
 */
public interface EventRepository extends Repository<Event, Long> {

    /**
     * Delete.
     *
     * @param event the Event
     */
    void delete(Event event);

    /**
     * Find all.
     *
     * @return the list
     */
    List<Event> findAll();

    /**
     * Find one.
     *
     * @param id the id
     * @return the Event
     */
    Event findById(Long id);

    /**
     * Save.
     *
     * @param event the Event
     * @return the Event
     */
    Event save(Event event);
}
