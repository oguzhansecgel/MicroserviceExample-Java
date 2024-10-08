package com.javaexample.OrderService.Clients;

import com.javaexample.OrderService.Entity.Order;
import com.javaexample.OrderService.Entity.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Optional;

@FeignClient("ProductService")
public interface ProductClient {

    @GetMapping("/product/getByIdProduct/{id}")
    ProductDto getByIdProduct(@PathVariable int id);

    @GetMapping("/product/productStockCount/{id}")
    Integer getProductStockCount(@PathVariable int id);

    @GetMapping("/product/existByProduct/{id}")
    boolean existByProduct(@PathVariable int id);

    @PutMapping("/product/decrementStock/{id}")
    void decrementStock(@PathVariable int id);
}
