package com.synergisticit.capstoneproject.services;

import java.util.List;
import com.synergisticit.capstoneproject.model.Store;

public interface StoreService {

    List<Store> getAll();

    List<Store> getStoreByProductName(String productName);

    Store getOneStoreByProductName(String productName);

    List<Store> getStoreByProductNameLike(String productName);

    Store getStoreById(int storeId);

    Store getStoreByQuantity(String quantity);

    List<Store> getStoreByPriceGreaterThan(int price);

    List<Store> getStoreByCondition(Store store);

}
