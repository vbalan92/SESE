package tuwien.at.sese.hotelreservation.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import tuwien.at.sese.hotelreservation.model.Contact;

/**
 * The Interface ContactRepository.
 */
public interface ContactRepository extends Repository<Contact, Long> {

    /**
     * Delete.
     *
     * @param contact the contact
     */
    void delete(Contact contact);

    /**
     * Find all.
     *
     * @return the list
     */
    List<Contact> findAll();

    /**
     * Find one.
     *
     * @param id the id
     * @return the contact
     */
    Contact findById(Long id);

    /**
     * Save.
     *
     * @param contact the contact
     * @return the contact
     */
    Contact save(Contact contact);
}
