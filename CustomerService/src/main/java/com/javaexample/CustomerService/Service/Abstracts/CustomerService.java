package com.javaexample.CustomerService.Service.Abstracts;

import com.javaexample.CustomerService.Entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Optional<Customer> getCustomerById(int id);
}
