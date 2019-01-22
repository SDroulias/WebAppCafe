package com.webappcafe.dao;

import com.webappcafe.model.Customer;
import java.util.List;


public interface CustomerDAO {
    public String registerUser(Customer registerBean);
    public List<Customer> getAllCustomers();
    public void deleteCustomerByID(long id);
}
