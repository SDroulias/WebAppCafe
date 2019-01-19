package com.webappcafe.dao;

import com.webappcafe.model.Customer;
import java.sql.ResultSet;
import java.util.List;


public interface CustomerDAO {
    
    public String registerUser(Customer registerBean);
    
    public List<Customer> getAllCustomers();
    
    public void deleteCustomerByID(long id);
    
    int updateProduct(Customer customer);
    
    Customer fetchCustomerByResultSet(ResultSet results);
}
