package com.synergisticit.capstoneproject.repository;

import java.util.List;

import com.synergisticit.capstoneproject.model.Store;
public interface StoreQueryDao {

    List<Store> getAll();

    List<Store> getStoreByProductName(String productName);

    Store getSingleStoreByProductName(String productName);

    List<Store> getStoreByProductNameLike(String productName);

    Store getSingleStoreByQuantity(String quantity);

    List<Store> getStoreByPriceGreaterThan(int price);

}
