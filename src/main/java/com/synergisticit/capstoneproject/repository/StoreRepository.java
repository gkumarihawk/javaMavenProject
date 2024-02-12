package com.synergisticit.capstoneproject.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.synergisticit.capstoneproject.model.Store;

public interface StoreRepository extends MongoRepository<Store, String> {

    Store findByProductName(String productName);

    List<Store> findByProductNameLike(String productName);

}
