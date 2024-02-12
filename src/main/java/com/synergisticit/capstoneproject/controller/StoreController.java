package com.synergisticit.capstoneproject.controller;

import java.util.List;

import com.synergisticit.capstoneproject.model.Store;
import com.synergisticit.capstoneproject.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/store-Management")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @GetMapping("/say")
    public String sayHello() {
        return "Hello Store Management Application - Capstone Project";
    }

    @GetMapping
    public List<Store> getAll() {
        return storeService.getAll();
    }


    @GetMapping("/{storeId}")
    public Store getStoreById(@PathVariable int storeId ) {
        return storeService.getStoreById(storeId);
    }

    @GetMapping("/productName/{productName}")
    public List<Store> getStoreByName(@PathVariable String productName ) {
        return storeService.getStoreByProductName(productName);
    }

    // get Product by name (equals())
    @GetMapping("/one-by-productName/{productName}")
    public Store getOneStoreByProductName(@PathVariable String productName) {
        return storeService.getOneStoreByProductName(productName);
    }

    // get Product by name %LIKE%
    @GetMapping("/productName-like/{productName}")
    public List<Store> getStoreByProductNameLike(@PathVariable String productName) {
        return storeService.getStoreByProductNameLike(productName);
    }

    @GetMapping("/one-by-quantity/{quantity}")
    public Store getStoreBylName(@PathVariable String quantity) {
        return storeService.getStoreByQuantity(quantity);
    }


    @GetMapping("/price-greater-than/{price}")
    public List<Store> getStoreByPriceGreaterThan(@PathVariable int price) {
        return storeService.getStoreByPriceGreaterThan(price);
    }

    @PostMapping("/get-by-condition")
    public List<Store> getStoreByCondition(@RequestBody Store store) {
        return storeService.getStoreByCondition(store);
    }
}





