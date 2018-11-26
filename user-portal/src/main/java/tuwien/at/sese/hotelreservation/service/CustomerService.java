package tuwien.at.sese.hotelreservation.service;

import java.util.List;
import java.util.Optional;

import tuwien.at.sese.hotelreservation.api.dto.CustomerDTO;
import tuwien.at.sese.hotelreservation.model.Customer;

/**
 * @author Abbas ULUSOY
 * crud operation for customers
 *
 */
public interface CustomerService {

    /**
     * @param customer
     * @return created customer
     */
    Customer create(Customer customer);

    /**
     * @param id
     * @return deleted customer
     */
    Customer delete(Long id);

    /**
     * @return list of customer 
     */
    List<CustomerDTO> findAll();

    /**
     * @param id
     * @return found customer
     */
    Customer findById(Long id);

    /**
     * @param email
     * @return found customer
     */
    Optional<Customer> findByEmail(String email);

    /**
     * @param customer
     * @return update customer
     */
    Customer update(Customer customer);
}
