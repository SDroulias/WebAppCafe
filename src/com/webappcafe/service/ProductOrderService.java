package com.webappcafe.service;

import com.webappcafe.dao.ProductOrderDAO;
import com.webappcafe.dao.ProductOrderDAOImpl;
import com.webappcafe.model.ProductOrder;

public class ProductOrderService {
    
    public void createProductOrder(long ordersId, long productsId, int productsQuantity) {
        ProductOrderDAO prodOrderDAO = new ProductOrderDAOImpl();
        
        prodOrderDAO.saveProductOrder(ProductOrder.createProductOrder(ordersId, productsId, productsQuantity));
    }
    
}
