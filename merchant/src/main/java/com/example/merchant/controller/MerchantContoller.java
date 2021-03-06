package com.example.merchant.controller;


import com.example.merchant.collections.Merchant;
import com.example.merchant.services.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/merchant")
public class MerchantContoller {

    @Autowired
    MerchantService merchantService;


    //post-register functionality to save the merchant
    @PostMapping(value="/save")
    public Merchant save(@RequestBody Merchant merchant){
        return merchantService.save(merchant);
    }


    //@GetMapping(value="/findAll")
    //get-merchant details

    @GetMapping(value="/{merchantId}")
    public Merchant findById(@PathVariable("merchantId")String merchantId){
        return  merchantService.findById(merchantId);
    }


    //get-orders fora certain merchant
    @GetMapping(value="/orders/{merchantId}")
    public List<String> findOrders(@PathVariable("merchantId") String merchantId) {

        return merchantService.findOrders(merchantId);

    }

    //add order to the merchant
    @PostMapping(value="/addMerchantOrder/{merchantId}/{orderId}")
    public void  addMerchantOrder(@PathVariable("merchantId")String merchantId,@PathVariable("orderId")String orderId){
         merchantService.addMerchantOrder(merchantId,orderId);
    }


}
