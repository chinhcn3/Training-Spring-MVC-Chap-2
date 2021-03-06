package com.packt.repository;

import java.util.List;

import com.packt.model.Product;

/**
 * Created by chinhvd on 11/19/17.
 */
public interface ProductRepository {

    List<Product> getAllProducts();

    void updateStock(String productId, long noOfUnits);
}
