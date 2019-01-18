/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webappcafe.service;

import com.webappcafe.dao.ProductDAO;
import com.webappcafe.dao.ProductDAOImpl;
import com.webappcafe.model.Product;


public class ProductService {
    
    private ProductDAO productDAO;
    
    public boolean updateProductAvailability(long id, byte isAvailable) {
        
        productDAO = new ProductDAOImpl();
        
        Product p = productDAO.getProductById(id);
        
        if(p != null) {
            
            p.setIsAvailable(isAvailable);
            
            productDAO.updateProduct(p);
            
            return true;
        }
        
        return false;
    }
    
}
