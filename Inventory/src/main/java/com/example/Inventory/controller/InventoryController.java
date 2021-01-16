package com.example.Inventory.controller;
import com.example.Inventory.entity.Inventory;
import com.example.Inventory.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/Inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;


    @PostMapping(value="/save")
    Inventory save(@RequestBody Inventory inventory){

        return inventoryService.save(inventory);

    }

    @PostMapping(value="/price/{productId}/{merchantId}/{price}")
    void setPrice(@PathVariable("productId")String productId,@PathVariable("merchantId")String merchantId,@PathVariable("price")double price){
        inventoryService.setPrice(productId,merchantId,price);
    }

    @PostMapping(value="/quantity/{productId}/{merchantId}/{quantity}")
    void setQuantity(@PathVariable("productId")String productId,@PathVariable("merchantId")String merchantId,@PathVariable("quantity")int quantity){
        inventoryService.setQuantity(productId,merchantId,quantity);
    }


    @GetMapping(value="/allStock/{productId}")
    int  getstock(@PathVariable("productId")String productId) {

        return inventoryService.getStock(productId);
    }

    @GetMapping(value="/findProduct/{productId}")
    List<Inventory> findProductById(@PathVariable String productId){

                return inventoryService.findByProductId(productId);

    }

}
