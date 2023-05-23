package com.sgenlecroyant.problem.datafiltering;

import com.sgenlecroyant.problem.datafiltering.product.entity.Product;

import java.util.List;

public class DataInitializer {

    public static List<Product> init(){

        Product samsung = Product.builder()
                .id(1L)
                .name("Samsung")
                .currency("$")
                .inStock(300)
                .unitPrice(2000D)
                .build();

        Product iPhone = Product.builder()
                .id(2L)
                .name("iPhone 12 Pro")
                .inStock(30)
                .currency("$")
                .unitPrice(8000D)
                .build();

        Product huawei = Product.builder()
                .id(3L)
                .name("Huawei Honor")
                .unitPrice(7500D)
                .inStock(40)
                .currency("$")
                .build();

        return List.of(samsung, iPhone, huawei);
    }
}
