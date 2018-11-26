package tuwien.at.sese.hotelreservation.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuwien.at.sese.hotelreservation.api.dto.CustomerDTO;
import tuwien.at.sese.hotelreservation.model.Customer;
import tuwien.at.sese.hotelreservation.repository.CustomerRepository;
import tuwien.at.sese.hotelreservation.service.CustomerService;

/**
 * @author Abbas ULUSOY
 * crud operation for customers and list 
 *
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Customer delete(Long id) {
        Customer customer = findById(id);
        if(customer != null){
            repository.delete(customer);
        }
        return customer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CustomerDTO> findAll() {
        return repository.findAll().stream().map(CustomerDTO::new).collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Customer findById(Long id) {
        return repository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Customer update(Customer customer) {
        return repository.save(customer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Customer> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
