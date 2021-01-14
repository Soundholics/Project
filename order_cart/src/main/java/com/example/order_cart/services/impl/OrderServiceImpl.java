package com.example.order_cart.services.impl;

import com.example.order_cart.entity.CartEntity;
import com.example.order_cart.entity.OrderEntity;
import com.example.order_cart.repository.CartRepository;
import com.example.order_cart.repository.OrderRepository;
import com.example.order_cart.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private OrderRepository orderRepository;

    public void saveOrder(OrderEntity orderEntity){
        orderRepository.save(orderEntity);
    }

    public List<OrderEntity> getOrder(String customerEmail){
        Iterable<OrderEntity> list = orderRepository.findAll();
        List<OrderEntity> orderList = new ArrayList<>();
        try {
            list.forEach(orderList::add);
        }catch (Exception e){
            System.out.println("Error: "+e);
            return null;
        }
        return orderList.stream().filter(e -> {return e.getCustomerEmail().equals(customerEmail);}).collect(Collectors.toList());
    }

    public CartEntity getCart(String customerEmail){
        CartEntity cart;
        try{
            cart = cartRepository.findById(customerEmail).get();
        }catch (Exception e){
            System.out.println("Error: "+e);
            return null;
        }
        return cart;
    }

    public void saveCart(CartEntity cart){
        cartRepository.save(cart);
    }

    public void updateCart(CartEntity cartEntity){
        saveCart(cartEntity);
    }

    public void deleteCart(String customerEmail){
        cartRepository.deleteById(customerEmail);
    }
}
