package com.javaexample.CustomerService.Repository;

import com.javaexample.CustomerService.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
