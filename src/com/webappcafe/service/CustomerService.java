package com.webappcafe.service;

import com.webappcafe.dao.CustomerDAO;
import com.webappcafe.dao.CustomerDAOImpl;
import com.webappcafe.model.Customer;


public class CustomerService {
    
    private CustomerDAO customerDAO;
    
    public void editCustomerFnameLname(long id, String fname, String lname) {
        
        customerDAO = new CustomerDAOImpl();
        
        Customer c = customerDAO.getCustomerById(id);
        
        if(c != null) {
        
            c.setFname(fname);
            c.setLname(lname);
            
            customerDAO.updateCustomer(c);
        
        }
        
    }
    
    public void editCustomerPassword(int id, String password) {
        
        customerDAO = new CustomerDAOImpl();
        
        Customer c = customerDAO.getCustomerById(id);
        
        if(c != null) {
        
            c.setPassword(password);
            
            customerDAO.updateCustomer(c);
        
        }
        
    }
    
}
