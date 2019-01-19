/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webappcafe.service;

import com.webappcafe.dao.ProductDAO;
import com.webappcafe.dao.ProductDAOImpl;
import com.webappcafe.model.Product;
import java.util.ArrayList;
import java.util.List;


public class ProductService {
    
    private ProductDAO productDAO;
    
    public void updateProductAvailability(long id, boolean isAvailable) {
        
        productDAO = new ProductDAOImpl();
        
        Product p = productDAO.getProductById(id);
        
        if(p != null) {
            
            p.setIsAvailable(isAvailable);
            
            productDAO.updateProduct(p);
            
        }
    }
    
    public void editProduct(long id, String name, double price, String description) {
        
        productDAO = new ProductDAOImpl();
        
        Product p = productDAO.getProductById(id);
        
        if(p != null) {
            
            p.setName(name);
            p.setPrice(price);
            p.setDescription(description);
            
            productDAO.updateProduct(p);
            
        }
        
    }
    
    public List<Product> getAvailableProducts() {
        productDAO = new ProductDAOImpl();
        
        List<Product> products = productDAO.getAllProducts();
        
        List<Product> availableProducts = new ArrayList();

        for(Product p : products) {
            
            if(p.getIsAvailable())
                availableProducts.add(p);
            
        }
        
        return availableProducts;
    }
}
