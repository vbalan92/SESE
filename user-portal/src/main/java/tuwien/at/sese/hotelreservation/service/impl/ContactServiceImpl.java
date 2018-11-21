package tuwien.at.sese.hotelreservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuwien.at.sese.hotelreservation.model.Contact;
import tuwien.at.sese.hotelreservation.repository.ContactRepository;
import tuwien.at.sese.hotelreservation.service.ContactService;

/**
 * @author Abbas ULUSOY 
 *
 */
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository repository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Contact create(Contact contact) {
        return repository.save(contact);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Contact delete(Long id) {
        Contact Contact = findById(id);
        if (Contact != null) {
            repository.delete(Contact);
        }
        return Contact;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Contact> findAll() {
        return repository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Contact findById(Long id) {
        return repository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Contact update(Contact contact) {
        return repository.save(contact);
    }
}
