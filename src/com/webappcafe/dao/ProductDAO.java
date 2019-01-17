package com.webappcafe.dao;

import com.webappcafe.model.Product;

import java.util.List;

public interface ProductDAO {

    long saveProduct(Product product);
    
    List<Product> getAllProducts();
    
    int deleteProduct(int id);
}
