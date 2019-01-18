package com.webappcafe.dao;

import com.webappcafe.model.Product;
import java.sql.ResultSet;

import java.util.List;

public interface ProductDAO {

    long saveProduct(Product product);
    
    List<Product> getAllProducts();
    
    Product getProductById(long id);
    
    int deleteProduct(int id);
    
    int updateProduct(Product product);
    
    Product fetchProductByResultSet(ResultSet resultSet);
}
