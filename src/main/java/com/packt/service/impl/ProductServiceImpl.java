package com.packt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.model.Product;
import com.packt.repository.ProductRepository;
import com.packt.service.ProductService;

/**
 * Created by daudm on 11/20/17.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void updateAllStock() {
        List<Product> allProducts = productRepository.getAllProducts();

        for (Product product : allProducts) {
            if (product.getUnitsInStock() < 500) {
                productRepository.updateStock(product.getProductId(),
                                              product.getUnitsInStock() + 1000);
            }
        }
    }
}
