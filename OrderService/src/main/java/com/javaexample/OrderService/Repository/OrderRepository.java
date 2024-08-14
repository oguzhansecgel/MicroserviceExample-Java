package com.javaexample.OrderService.Repository;

import com.javaexample.OrderService.Entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
