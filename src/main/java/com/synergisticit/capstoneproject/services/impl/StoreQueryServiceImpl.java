package com.synergisticit.capstoneproject.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.synergisticit.capstoneproject.model.Store;
import com.synergisticit.capstoneproject.repository.StoreQueryDao;
import com.synergisticit.capstoneproject.services.StoreQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.util.StringUtils;

@Service
public class StoreQueryServiceImpl implements StoreQueryService {
    @Autowired
    private StoreQueryDao storeQueryDao;

    @Override
    public List<Store> getAll() {
        System.out.println("Inside Store Query Service Impl");
        return storeQueryDao.getAll();
    }

    @Override
    public List<Store> getStoreByProductName(String productName) {

        if (!StringUtils.isEmpty(productName)) {
            return storeQueryDao.getStoreByProductName(productName);
        }

        return null;
    }


    @Override
    public Store getOneStoreByProductName(String productName) {

        if (!StringUtils.isEmpty(productName)) {
            return storeQueryDao.getSingleStoreByProductName(productName);
        }

        return null;
    }
    @Override
    public List<Store> getStoreByProductNameLike(String productName) {

        if (!StringUtils.isEmpty(productName)) {
            return storeQueryDao.getStoreByProductNameLike(productName);
        }

        return null;
    }


    @Override
    public Store getSingleStoreByQuantity(String quantity) {

        if (!StringUtils.isEmpty(quantity)) {
            return storeQueryDao.getSingleStoreByQuantity(quantity);
        }
        return Store.builder().storeId(0).productName("Not Found").quantity("Please enter valid last name").price(0f).build();
    }

    @Override
    public List<Store> getStoreByPriceGreaterThan(int price) {

        if (price > 0) {
            return storeQueryDao.getStoreByPriceGreaterThan(price);
        }
        return Collections.emptyList();
    }

    @Override
    public List<Store> getStoreByCondition(Store store) {
        List<Store> list = storeQueryDao.getAll();
        List<Store> stores = new ArrayList<>();

        if (null != store && (null != store.getProductName() || store.getStoreId() > 0
                || null != store.getQuantity() || store.getPrice() > 0)) {

            for (Store st : list) {

                if (null != store.getProductName() && store.getStoreId() > 0 && null != store.getQuantity()
                        && store.getPrice() > 0) {

                    if (st.getStoreId() == store.getStoreId()
                            && st.getProductName().equalsIgnoreCase(store.getProductName())
                            && st.getQuantity().equalsIgnoreCase(store.getQuantity())
                            && st.getPrice() == store.getPrice()) {
                        stores.add(st);

                        break;
                    } else {
                        continue;
                    }
                }
                if (store.getStoreId() == st.getStoreId()) {
                    stores.add(st);
                    continue;
                }

                // Product NAme
                if (null != store.getProductName()) {
                    if (st.getProductName().toLowerCase().contains(store.getProductName().toLowerCase())) {
                        stores.add(st);
                        // Go back to first statement (nothing but for loop)
                        continue;
                    }
                }

                // Quantity
                if (null != store.getQuantity()) {
                    if (st.getQuantity().equalsIgnoreCase(store.getQuantity()))
                        stores.add(st);
                    // Go back to first statement (nothing but for loop)
                    continue;
                }
                // Price
                if (store.getPrice() == st.getPrice()) {
                    stores.add(st);
                }
                // ---------------------------------------------------------
            }
            // returning the list
            return stores;
        }
        return stores;
    }
}

