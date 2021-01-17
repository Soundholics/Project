package com.example.order_cart.controller;

import com.example.order_cart.entity.CartEntity;
import com.example.order_cart.entity.OrderEntity;
import com.example.order_cart.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/saveOrder")
    void saveOrder(@RequestBody OrderEntity orderEntity){
        orderService.saveOrder(orderEntity);
    }

    @GetMapping(value = "/getOrder/{customerEmail}")
    List<OrderEntity> getOrder(@PathVariable("customerEmail") String customerEmail){
        return orderService.getOrder(customerEmail);
    }

    @GetMapping(value = "/getCart/{customerEmail}")
    CartEntity getCart(@PathVariable("customerEmail") String customerEmail){
        return orderService.getCart(customerEmail);
    }

    @PutMapping(value = "/updateCart")
    void updateCart(@RequestBody CartEntity cart){
        orderService.updateCart(cart);
    }

    @PostMapping(value = "/cart")
    void saveCart(@RequestBody CartEntity cart){
        orderService.saveCart(cart);
    }

    @DeleteMapping(value = "/deleteCart/{customerEmail}")
    void deleteCart(@PathVariable("customerEmail") String customerEmail){
        orderService.deleteCart(customerEmail);
    }

    @GetMapping(value="/sendMail/{email}")
    String sendMail(@PathVariable("email")String email) throws Exception{
        List<OrderEntity> orderList = new ArrayList<>();
        orderList=orderService.getOrder(email);

        orderService.sendEmail(email,orderList);
        return "success";
    }
}
