package tuwien.at.sese.hotelreservation.service;

import java.util.List;

import tuwien.at.sese.hotelreservation.model.Contact;

/**
 * crud operation for contacts
 *
 */
public interface ContactService {

    /**
     * @param contact
     * @return created contact
     */
    Contact create(Contact contact);

    /**
     * @param id
     * @return deleted contact
     */
    Contact delete(Long id);

    /**
     * @return all contacts
     */
    List<Contact> findAll();

    /**
     * @param id
     * @return found contact
     */
    Contact findById(Long id);

    /**
     * @param contact
     * @return updated contact
     */
    Contact update(Contact contact);
}
