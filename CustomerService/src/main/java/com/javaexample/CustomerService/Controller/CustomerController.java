package com.javaexample.CustomerService.Controller;

import com.javaexample.CustomerService.Entity.Customer;
import com.javaexample.CustomerService.Service.Abstracts.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getAllCustomer")
    public List<Customer> getAllCustomer() {
        return customerService.getAllCustomers();
    }
    @GetMapping("/findByIdCustomer/{id}")
    public Optional<Customer> findByIdCustomer(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }
    @PostMapping("/createCustomer")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }
}
