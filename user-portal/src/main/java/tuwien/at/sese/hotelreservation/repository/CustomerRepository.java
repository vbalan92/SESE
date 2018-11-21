package tuwien.at.sese.hotelreservation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import tuwien.at.sese.hotelreservation.model.Customer;


/**
 * The Interface CustomerRepository.
 */
public interface CustomerRepository extends Repository<Customer, Long> {

    /**
     * Delete.
     *
     * @param customer the customer
     */
    void delete(Customer customer);

    /**
     * Find all.
     *
     * @return the list
     */
    List<Customer> findAll();

    /**
     * Find one.
     *
     * @param id the id
     * @return the customer
     */
    Customer findById(Long id);

    /**
     * Save.
     *
     * @param customer the customer
     * @return the customer
     */
    Customer save(Customer customer);

    Optional<Customer> findByEmail(String customerEmail);
}
