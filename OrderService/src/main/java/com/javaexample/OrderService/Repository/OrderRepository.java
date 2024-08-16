package com.javaexample.OrderService.Repository;

import com.javaexample.OrderService.Entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> findByCustomerCustomerId(Long customerId);
}
