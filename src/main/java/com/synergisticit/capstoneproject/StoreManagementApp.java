package com.synergisticit.capstoneproject;

import com.synergisticit.capstoneproject.repository.StoreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories
public class StoreManagementApp implements CommandLineRunner{

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        SpringApplication.run(StoreManagementApp.class, args);
    }

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public void run(String... args) throws Exception {

    }

}
