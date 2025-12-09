package com.Order_Managment_System.order;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;   
    }

    @PostMapping
    public String createOrder(@RequestBody OrderEntity order) {
        orderRepository.save(order);
        return "Order inserted successfully!";
    }

    @GetMapping
    public List<OrderEntity> getAllOrder() {
        return orderRepository.findAll();        
    }

    @GetMapping("/{orderId}")
    public Optional<OrderEntity> getOrderById(@PathVariable Long orderId) {
        return orderRepository.findById(orderId);
    }

    @PutMapping("/{orderId}")
    public String updateOrder(@RequestBody OrderEntity order, @PathVariable Long orderId) {
        order.setId(orderId);                     
        orderRepository.save(order);              
        return "Order updated successfully!";
    }

    @DeleteMapping("/{orderId}")
    public String deleteOrder(@PathVariable Long orderId) {
        orderRepository.deleteById(orderId);      
        return "Order deleted successfully!";
    }
}
