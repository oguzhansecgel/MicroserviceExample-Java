package com.javaexample.OrderService.Service.Concretes;

import com.javaexample.OrderService.Clients.CustomerClient;
import com.javaexample.OrderService.Clients.ProductClient;
import com.javaexample.OrderService.Entity.CustomerDto;
import com.javaexample.OrderService.Entity.Order;
import com.javaexample.OrderService.Entity.ProductDto;
import com.javaexample.OrderService.Kafka.ProductProducer;
import com.javaexample.OrderService.Repository.OrderRepository;
import com.javaexample.OrderService.Service.Abstracts.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductClient productClient;

    private final CustomerClient customerClient;
    private final ProductProducer productProducer;

    public OrderServiceImpl(OrderRepository orderRepository, ProductClient productClient, CustomerClient customerClient, ProductProducer productProducer) {
        this.orderRepository = orderRepository;
        this.productClient = productClient;
        this.customerClient = customerClient;
        this.productProducer = productProducer;
    }

    @Override
    public Order createOrder(int productId, int customerId) {
        CustomerDto customer = customerClient.findByIdCustomer(customerId);
        ProductDto product = productClient.getByIdProduct(productId);
        Order order = new Order();
        order.setCustomer(customer);
        order.setProducts(product);
        //*** kafka ile stok düşürme
        //productProducer.sendMessage(productId);

        //** feign client ile stok düşürme
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

    @Override
    public List<Order> getCustomerCart(Long customerId) {
        return orderRepository.findByCustomerCustomerId(customerId);
    }
}
