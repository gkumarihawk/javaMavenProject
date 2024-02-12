package com.synergisticit.capstoneproject.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.synergisticit.capstoneproject.model.Store;
import com.synergisticit.capstoneproject.repository.StoreRepository;
import com.synergisticit.capstoneproject.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository repository;



    @Override
    public List<Store> getAll() {
        return repository.findAll();
    }

    @Override
    public Store getStoreByQuantity(String quantity) {

        List<Store> stores = repository.findAll();

        for (Store st : stores) {
            if (st.getQuantity().equalsIgnoreCase(quantity))
                return st;
        }
        return Store.builder().storeId(0).productName("Not Found").quantity("Please enter valid id").price(0f).build();
    }

    @Override
    public Store getStoreById(int storeId) {
        List<Store> stores = repository.findAll();
        for (Store st : stores) {
            if (storeId == st.getStoreId())
                return st;
        }
        return Store.builder().storeId(0).productName("Not Found").quantity("Please enter valid id").price(0f).build();
    }

    @Override
    public List<Store> getStoreByProductName(String productName) {
        List<Store> stores = new ArrayList<>();
        List<Store> list = repository.findAll();
        for (Store st : list) {
            if (st.getProductName().equalsIgnoreCase(productName))
                stores.add(st);
        }
        return stores;
    }

    @Override
    public Store getOneStoreByProductName(String productName) {
        return repository.findByProductName(productName);
    }

    @Override
    public List<Store> getStoreByProductNameLike(String productName) {
        return repository.findByProductNameLike(productName);
    }


    @Override
    public List<Store> getStoreByPriceGreaterThan(int price) {
        List<Store> stores = new ArrayList<>();

        if (price > 0) {
            List<Store> list = repository.findAll();

            for (Store st : list) {
                if (st.getPrice() > price)
                    stores.add(st);
            }
        }
        return stores;
    }




    @Override
    public List<Store> getStoreByCondition(Store store) {
        List<Store> list = repository.findAll();
        List<Store> stores = new ArrayList<>();

        // This will return true if Store object is present(not null) any one of
        // property is not null OR greater than 0
        if (null != store && (null != store.getProductName() || store.getStoreId() > 0
                || null != store.getQuantity() || store.getPrice() > 0)) {

            for (Store st : list) {

                // If all 4 properties are present then only this block will execute
                if (null != store.getProductName() && store.getStoreId() > 0 && null != store.getQuantity()
                        && store.getPrice() > 0) {

                    if (st.getStoreId() == store.getStoreId()
                            && st.getProductName().equalsIgnoreCase(store.getProductName())
                            && st.getQuantity().equalsIgnoreCase(store.getQuantity())
                            && st.getPrice() == store.getPrice()) {
                        stores.add(st);
                        // Break the for loop
                        break;
                    } else {
                        // Go back to first statement
                        continue;
                    }
                }

                // if any one of above property is null or less than equals to 0 then below
                // block is executing
                // st Id
                if (store.getStoreId() == st.getStoreId()) {
                    stores.add(st);
                    // Go back to first statement
                    continue;
                }

                // Product Name
                if (null != store.getProductName()) {
                    if (st.getProductName().toLowerCase().contains(store.getProductName().toLowerCase())) {
                        stores.add(st);
                        // Go back to first statement
                        continue;
                    }
                }

                // Quantity
                if (null != store.getQuantity()) {
                    if (st.getQuantity().equalsIgnoreCase(store.getQuantity()))
                        stores.add(st);
                    // Go back to first statement
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
