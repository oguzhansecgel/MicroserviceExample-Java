package com.javaexample.OrderService.Service.Concretes;

import com.javaexample.OrderService.Clients.ProductClient;
import com.javaexample.OrderService.Entity.Order;
import com.javaexample.OrderService.Repository.OrderRepository;
import com.javaexample.OrderService.Service.Abstracts.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductClient productClient;

    public OrderServiceImpl(OrderRepository orderRepository, ProductClient productClient) {
        this.orderRepository = orderRepository;
        this.productClient = productClient;
    }

    @Override
    public Order createOrder(int productId) {
        Order order = productClient.getByIdProduct(productId);
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
