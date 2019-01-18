package com.webappcafe.dao;

import com.webappcafe.model.Product;

import java.util.List;

public interface ProductOrderDAO {


    List<Product> getProductsOfOrder(long product_id);

}
