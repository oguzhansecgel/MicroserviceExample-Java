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
    public Order createOrder(@RequestParam int productId, @RequestParam int customerId) {
         return orderService.createOrder(productId,customerId);
    }
    @GetMapping("/getListByAllOrder")
    public List<Order> getListByAllOrder() {
        return orderService.getAllOrders();
    }
    @GetMapping("/getCustomerCart/{id}")
    public List<Order> getCustomerCart(@PathVariable long id) {
        return orderService.getCustomerCart(id);
    }
    @DeleteMapping("/deleteOrder/{id}")
    public void deleteOrder(@PathVariable String id)
    {
        orderService.deleteOrder(id);
    }
}
