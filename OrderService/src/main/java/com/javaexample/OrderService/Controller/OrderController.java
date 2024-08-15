package com.javaexample.OrderService.Controller;

import com.javaexample.OrderService.Entity.Order;
import com.javaexample.OrderService.Service.Abstracts.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/createOrder")
    public Order createOrder(@RequestParam int productId) {
         return orderService.createOrder(productId);
    }
    @GetMapping("/getListByAllOrder")
    public List<Order> getListByAllOrder() {
        return orderService.getAllOrders();
    }
    @DeleteMapping("/deleteOrder/{id}")
    public void deleteOrder(@PathVariable String id)
    {
        orderService.deleteOrder(id);
    }
}
