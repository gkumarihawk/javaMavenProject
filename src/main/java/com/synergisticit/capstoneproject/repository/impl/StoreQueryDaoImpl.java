package com.synergisticit.capstoneproject.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.synergisticit.capstoneproject.model.Store;
import com.synergisticit.capstoneproject.repository.StoreQueryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class StoreQueryDaoImpl implements StoreQueryDao{
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Store> getAll() {
        System.out.println("Inside Store Query DAO Impl's get()");
        return mongoTemplate.findAll(Store.class);
    }


    @Override
    public List<Store> getStoreByProductName(String productName) {

        Query query = new Query();
        query.addCriteria(Criteria.where("productName").is(productName));
        return new ArrayList<>(mongoTemplate.find(query, Store.class));
    }


    @Override
    public Store getSingleStoreByProductName(String name) {

        Query query = new Query();
        query.addCriteria(Criteria.where("productName").is(name));

        return mongoTemplate.findOne(query, Store.class);
    }


    // "productName"  --> database property (not related to java code)
    // select * from store where quantity like %Gurung% limit 1 --> (case insensitive)
    @Override
    public List<Store> getStoreByProductNameLike(String productName) {

        Query query = new Query();
        query.addCriteria(Criteria.where("productName").regex(productName, "i"));

        return mongoTemplate.find(query, Store.class);
    }


    @Override
    public Store getSingleStoreByQuantity(String quantity) {

        Query query = new Query();
        query.addCriteria(Criteria.where("quantity").regex(quantity, "i"));

        return mongoTemplate.findOne(query, Store.class);
    }




    @Override
    public List<Store> getStoreByPriceGreaterThan(int price) {

        Query query = new Query();
        query.addCriteria(Criteria.where("price").gt(price));
        query.with(Sort.by(Sort.Direction.ASC, "productName"));
        query.with(Sort.by(new Sort.Order(Sort.Direction.ASC, "productName").ignoreCase()));

        return mongoTemplate.find(query, Store.class);
    }
}
