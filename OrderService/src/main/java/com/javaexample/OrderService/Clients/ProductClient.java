package com.javaexample.OrderService.Clients;

import com.javaexample.OrderService.Entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient("ProductService")
public interface ProductClient {

    @GetMapping("/product/getByIdProduct/{id}")
    Order getByIdProduct(@PathVariable int id);
}
