package com.javaexample.OrderService.Service.Concretes;

import com.javaexample.OrderService.Clients.ProductClient;
import com.javaexample.OrderService.Entity.Order;
import com.javaexample.OrderService.Repository.OrderRepository;
import com.javaexample.OrderService.Service.Abstracts.OrderService;
import jakarta.transaction.Transactional;
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
        int stockCount = productClient.getProductStockCount(productId);
        if (stockCount <= 0) {
            throw new RuntimeException("Stock count is less than or equal to zero");
        }

        Order order = productClient.getByIdProduct(productId);

        productClient.decrementStock(productId);
        order.setOrderId();
        Order savedOrder = orderRepository.save(order);

        return savedOrder;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public void deleteOrder(String orderId) {
        orderRepository.deleteById(orderId);
    }
}
