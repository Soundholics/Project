package com.example.Inventory.services;

import com.example.Inventory.entity.Inventory;

import java.util.List;

public interface InventoryService {

    Inventory save(Inventory inventory);
    void setPrice(String productId,String merchantId,double price);
    void setQuantity(String productId,String merchantId,int quantity);
    int getStock(String productId);
    List<Inventory> findByProductId(String productId);

}
