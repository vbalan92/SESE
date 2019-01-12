package tuwien.at.sese.hotelreservation.service.impl;

import static java.time.temporal.ChronoUnit.DAYS;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuwien.at.sese.hotelreservation.api.dto.EventDTO;
import tuwien.at.sese.hotelreservation.model.Customer;
import tuwien.at.sese.hotelreservation.model.Event;
import tuwien.at.sese.hotelreservation.model.User;
import tuwien.at.sese.hotelreservation.repository.EventRepository;
import tuwien.at.sese.hotelreservation.repository.UserRepository;
import tuwien.at.sese.hotelreservation.service.EventService;

/**
 * @author Abbas ULUSOY
 */
@Service
public class EventServiceImpl implements EventService
{

    @Autowired
    private EventRepository repository;
    @Autowired
    private UserRepository userRepository;
    

    /**
     * {@inheritDoc}
     *
     * @param eventDTO
     */
    @Override
    public EventDTO create(final EventDTO eventDTO)
    {
        validateEvent(eventDTO);

        final Optional<User> existingUser = userRepository.findByUsername(eventDTO.getUsername());
        final User user= existingUser.isPresent()
            ? existingUser.get() : null;

       

        Event event = new Event(eventDTO);
        event.setUser(user);
        event.setEventName(eventDTO.getEventName());
        event.setFromDate(eventDTO.getFrom());
        event.setToDate(eventDTO.getTo());
        final Event eventEntity = repository.save(event);
        return new EventDTO(eventEntity);
    }

    private void validateEvent(final EventDTO EventDTO)
    {
        if(EventDTO.getTo().isBefore(LocalDate.now())
            || EventDTO.getTo().isBefore(EventDTO.getFrom()))
        {
        	
            throw new IllegalArgumentException("TODO Exception");
        }
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Event delete(Long id)
    {
        Event event = findById(id);
        if (event != null)
        {
            repository.delete(event);
        }
        return event;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Event> findAll()
    {
        return repository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Event findById(Long id)
    {
        return repository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventDTO update(EventDTO eventDTO)
    {
        final Event event = repository.findById(eventDTO.getId());
        if (event == null)
        {
            return null;
        }
        event.setEventName(eventDTO.getEventName());
        event.setFromDate(eventDTO.getFrom());
        event.setFromDate(eventDTO.getTo());
        final Optional<User> existingUser = userRepository.findByUsername(eventDTO.getUsername());
        final User user= existingUser.isPresent()
            ? existingUser.get() : null;
        event.setUser(user);

        return new EventDTO(repository.save(event));
    }
}
