package com.synergisticit.capstoneproject.controller;

import com.synergisticit.capstoneproject.model.Store;
import com.synergisticit.capstoneproject.services.StoreQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store-query")
public class StoreQueryController {
    @Autowired
    private StoreQueryService storeQueryService;

    @GetMapping
    public List<Store> getAll() {
        return storeQueryService.getAll();
    }


    // getAllProduct by name (equals())
    @GetMapping("/productName/{productName}")
    public List<Store> getStoreByProductName(@PathVariable String productName) {
        return storeQueryService.getStoreByProductName(productName);
    }


    // getAll Product by name (equals())
    @GetMapping("/one-by-productName/{productName}")
    public Store getOneStoreByProductName(@PathVariable String productName) {
        return storeQueryService.getOneStoreByProductName(productName);
    }

    // getAll Product by name %LIKE%
    @GetMapping("/productName-like/{productName}")
    public List<Store> getStoreByProductNameLike(@PathVariable String productName) {
        return storeQueryService.getStoreByProductNameLike(productName);
    }


    // getAll Product by name (equals())
    @GetMapping("/one-by-quantity/{quantity}")
    public Store getSingleStoreByQuantity(@PathVariable String quantity) {
        return storeQueryService.getSingleStoreByQuantity(quantity);
    }


    @GetMapping("/price-greater-than/{price}")
    public List<Store> getStoreByPriceGreaterThan(@PathVariable int price) {
        return storeQueryService.getStoreByPriceGreaterThan(price);
    }


    @PostMapping("/get-by-condition")
    public List<Store> getStoreByCondition(@RequestBody Store store) {
        return storeQueryService.getStoreByCondition(store);
    }

}
