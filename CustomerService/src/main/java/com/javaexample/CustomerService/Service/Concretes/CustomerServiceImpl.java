package com.javaexample.CustomerService.Service.Concretes;

import com.javaexample.CustomerService.Entity.Customer;
import com.javaexample.CustomerService.Repository.CustomerRepository;
import com.javaexample.CustomerService.Service.Abstracts.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

    @Override
    public Optional<Customer> getCustomerById(int id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer;
    }
}
