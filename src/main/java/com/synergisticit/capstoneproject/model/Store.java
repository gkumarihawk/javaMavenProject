package com.synergisticit.capstoneproject.model;

import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Store implements Serializable {
    @Id
    private String id;
    private int storeId;
    private String productName;
    private String quantity;
    private float price;
}
