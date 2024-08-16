package com.javaexample.CustomerService.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "OrderService")
public interface OrderClient {
    @GetMapping("/orders/getCustomerCart/{id}")
    List<String> getCustomerCart(@PathVariable long id);
}
