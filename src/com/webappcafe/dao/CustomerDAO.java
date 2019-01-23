package com.webappcafe.dao;

import com.webappcafe.model.Customer;
import java.sql.ResultSet;
import java.util.List;


public interface CustomerDAO {
    
    String registerUser(Customer registerBean);
    
    List<Customer> getAllCustomers();
    
    Customer getCustomerById(long id);
    
    void deleteCustomerByID(long id);
    
    int updateCustomer(Customer customer);
    
    Customer fetchCustomerByResultSet(ResultSet results);
    
    Customer getCustomerByUsername(String username);
}
