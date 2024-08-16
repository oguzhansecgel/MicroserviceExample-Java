package com.javaexample.OrderService.Service.Concretes;

import com.javaexample.OrderService.Clients.ProductClient;
import com.javaexample.OrderService.Entity.Order;
import com.javaexample.OrderService.Kafka.ProductProducer;
import com.javaexample.OrderService.Repository.OrderRepository;
import com.javaexample.OrderService.Service.Abstracts.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductClient productClient;
    private final ProductProducer productProducer;

    public OrderServiceImpl(OrderRepository orderRepository, ProductClient productClient, ProductProducer productProducer) {
        this.orderRepository = orderRepository;
        this.productClient = productClient;
        this.productProducer = productProducer;
    }

    @Override
    public Order createOrder(int productId) {
        boolean existProduct = productClient.existByProduct(productId);
        if(!existProduct)
            throw new RuntimeException("Ürün Bulunamadı");
        int stockCount = productClient.getProductStockCount(productId);
        if (stockCount <= 0) {
            throw new RuntimeException("Stock sayısı sıfır");
        }

        Order order = productClient.getByIdProduct(productId);
        order.setProductId(productId);
        //productClient.decrementStock(productId);
        productProducer.sendMessage(order);
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
