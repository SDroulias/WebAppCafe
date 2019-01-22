package com.webappcafe.service;

import com.webappcafe.dao.OrderDAO;
import com.webappcafe.dao.OrderDAOImpl;
import com.webappcafe.model.Order;

public class OrderService {
    
    public long createOrder(long id) {
        long orderId = 0;
        OrderDAO orderDAO = new OrderDAOImpl();
        
        // Saving the newly created order with the given id
        orderId = orderDAO.saveOrder(Order.createOrder(id));
        
        // Returns the id of the order inserted
        return orderId;
    }
    
}
