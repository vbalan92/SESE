package tuwien.at.sese.hotelreservation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tuwien.at.sese.hotelreservation.api.dto.CustomerDTO;
import tuwien.at.sese.hotelreservation.model.Customer;
import tuwien.at.sese.hotelreservation.service.CustomerService;

/**
 * Customers
 *
 */
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * @param customer
     * @return Customer
     */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ADMIN')")
    public Customer create(@RequestBody Customer customer){
        return customerService.create(customer);
    }

    /**
     * Find one.
     *
     * @param id the id
     * @return the customer
     */
    
    @GetMapping(path = {"/{id}"},produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ADMIN')")
    public Customer findOne(@PathVariable("id") Long id){
        return customerService.findById(id);
    }

    /**
     * Find one.
     *
     * @param email the email
     * @return the customer
     */
    
    @GetMapping(path = { "/{email}" }, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ADMIN')")
    public Optional<Customer> findByEmail(@PathVariable("email") String email) {
        return customerService.findByEmail(email);
    }

    /**
     * Update.
     *
     * @param id the id
     * @param customer the customer
     * @return the customer
     */
    @PutMapping(path = {"/{id}"},produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ADMIN')")
    public Customer update(@PathVariable("id") Long id, @RequestBody Customer customer){
        customer.setId(id);
        return customerService.update(customer);
    }

    /**
     * Delete.
     *
     * @param id the id
     * @return the customer
     */
    @DeleteMapping(path ={"/{id}"},produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ADMIN')")
    public Customer delete(@PathVariable("id") Long id) {
        return customerService.delete(id);
    }

    /**
     * Find all.
     *
     * @return the list
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ADMIN')")
    public List<CustomerDTO> findAll(){
        return customerService.findAll();
    }
}
