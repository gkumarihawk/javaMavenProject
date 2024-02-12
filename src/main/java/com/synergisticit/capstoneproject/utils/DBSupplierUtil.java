package com.synergisticit.capstoneproject.utils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import com.synergisticit.capstoneproject.model.Store;
public class DBSupplierUtil {

    private DBSupplierUtil() {
    }


    public static Supplier<List<Store>> storeSupplier = () ->
            Arrays.asList(
                    Store.builder().storeId(1).productName("Laptop").quantity("1").price(3000.0f).build(),
                    Store.builder().storeId(2).productName("Mobile").quantity("2").price(4000.0f).build(),
                    Store.builder().storeId(3).productName("HardDisk").quantity("3").price(5000.0f).build(),
                    Store.builder().storeId(4).productName("phone").quantity("4").price(6000.0f).build(),
                    Store.builder().storeId(5).productName("Dress").quantity("5").price(7000.0f).build()
            );
}
