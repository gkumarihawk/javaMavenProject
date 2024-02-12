package com.synergisticit.capstoneproject.services;

import java.util.List;

import com.synergisticit.capstoneproject.model.Store;
public interface StoreQueryService {

    List<Store> getAll();

    List<Store> getStoreByProductName(String productName);

    Store getSingleStoreByQuantity(String quantity);

    List<Store> getStoreByProductNameLike(String productName);

    Store getOneStoreByProductName(String productName);

    List<Store> getStoreByPriceGreaterThan(int price);

    List<Store> getStoreByCondition(Store store);
}
