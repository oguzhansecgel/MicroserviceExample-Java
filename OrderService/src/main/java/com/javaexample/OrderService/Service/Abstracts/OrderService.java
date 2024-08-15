package com.javaexample.OrderService.Service.Abstracts;

import com.javaexample.OrderService.Entity.Order;

import java.util.List;

public interface OrderService {

    Order createOrder(int productId);
    List<Order> getAllOrders();
    void deleteOrder(String orderId);
}
