package com.webappcafe.dao;

import com.webappcafe.model.ProductOrder;

import java.util.List;

public interface ProductOrderDAO {

    List<ProductOrder> getProductsOrdersByOrderId(long orderId);
    void saveOrdersProducts(ProductOrder order);
}
