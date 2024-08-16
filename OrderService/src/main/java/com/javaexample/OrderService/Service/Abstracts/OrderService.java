package com.javaexample.OrderService.Service.Abstracts;

import com.javaexample.OrderService.Entity.Order;

import java.util.List;

public interface OrderService {

    Order createOrder(int productId, int customerId);
    List<Order> getAllOrders();
    void deleteOrder(String orderId);
    List<Order> getCustomerCart(Long customerId);
}
