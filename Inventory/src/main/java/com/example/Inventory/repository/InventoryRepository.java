package com.example.Inventory.repository;


import com.example.Inventory.entity.Inventory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository  extends CrudRepository<Inventory,Integer> {



    @Modifying
    @Query("update Inventory I  set I.price = :price  where I.productId = :productId and I.merchantId = :merchantId ")
    void setPrice(@Param("productId")String productId, @Param("merchantId")String merchantId, @Param("price")double price);


    @Modifying
    @Query("update Inventory I  set I.quantity = :quantity where I.productId = :productId and I.merchantId = :merchantId ")
    void setQuantity(@Param("productId")String productId,@Param("merchantId")String merchantId,@Param("quantity")int quantity);


    @Query("select sum(quantity) from Inventory I where I.productId = :productId")
    int  getStock(@Param("productId")String productId);


    List<Inventory> findByProductId(String productId);

}
