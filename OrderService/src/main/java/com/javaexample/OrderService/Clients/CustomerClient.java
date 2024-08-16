package com.javaexample.OrderService.Clients;

import com.javaexample.OrderService.Entity.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "CustomerService")
public interface CustomerClient {

    @GetMapping("/customer/findByIdCustomer/{id}")
    CustomerDto findByIdCustomer(@PathVariable int id);
}
