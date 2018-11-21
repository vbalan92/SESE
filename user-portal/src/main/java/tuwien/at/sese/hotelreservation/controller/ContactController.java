package tuwien.at.sese.hotelreservation.controller;

import java.util.List;

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

import tuwien.at.sese.hotelreservation.model.Contact;
import tuwien.at.sese.hotelreservation.service.ContactService;

/**
 * Contact crud operations
 *
 */
@RestController
@RequestMapping({ "/api/contacts" })
public class ContactController {

    @Autowired
    private ContactService contactService;

    /**
     * @param contact
     * @return created Contact
     */
    @PostMapping
    public Contact create(@RequestBody Contact contact) {
        return contactService.create(contact);
    }

    /**
     * @param id
     * @return found Contact
     */
    @GetMapping(path = {"/{id}"})
    @PreAuthorize("hasRole('ADMIN')")
    public Contact findOne(@PathVariable("id") Long id) {
        return contactService.findById(id);
    }

    /**
     * @param id
     * @param contact
     * @return updated Contact
     */
    @PutMapping(path = {"/{id}"})
    @PreAuthorize("hasRole('ADMIN')")
    public Contact update(@PathVariable("id") Long id, @RequestBody Contact contact) {
        contact.setId(id);
        return contactService.update(contact);
    }

    /**
     * @param id
     * @return deleted Contact
     */
    @DeleteMapping(path ={"/{id}"})
    @PreAuthorize("hasRole('ADMIN')")
    public Contact delete(@PathVariable("id") Long id) {
        return contactService.delete(id);
    }

    /**
     * @return all Contacts
     */
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<Contact> findAll() {
        return contactService.findAll();
    }
}