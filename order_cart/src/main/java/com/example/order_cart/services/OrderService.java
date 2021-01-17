package com.example.order_cart.services;

import com.example.order_cart.entity.CartEntity;
import com.example.order_cart.entity.OrderEntity;

import java.util.List;

public interface OrderService {
    void saveOrder(OrderEntity orderEntity);
    List<OrderEntity> getOrder(String customerEmail);
    CartEntity getCart(String customerEmail);
    void updateCart(CartEntity cartEntity);
    void saveCart(CartEntity cart);
    void deleteCart(String customerEmail);
    void sendEmail(String email,List<OrderEntity> orderList) throws Exception;
}
