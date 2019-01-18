package com.webappcafe.model;

public class ProductOrder {
    private int id;
    private int ordersId;
    private int productsId;
    private int productsQuantity;

    private ProductOrder() {
    }
    
    private ProductOrder(int id, int ordersId, int productsId, int productsQuantity) {
        setId(id);
        setOrdersId(ordersId);
        setProductsId(productsId);
        setProductsQuantity(productsQuantity);
    }
    
    private ProductOrder(int ordersId, int productsId, int productsQuantity) {
        setOrdersId(ordersId);
        setProductsId(productsId);
        setProductsQuantity(productsQuantity);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(int ordersId) {
        this.ordersId = ordersId;
    }

    public int getProductsId() {
        return productsId;
    }

    public void setProductsId(int productsId) {
        this.productsId = productsId;
    }

    public int getProductsQuantity() {
        return productsQuantity;
    }

    public void setProductsQuantity(int productsQuantity) {
        this.productsQuantity = productsQuantity;
    }
    
    public static ProductOrder createProductOrder(int id, int ordersId, int productsId, int productsQuantity) {
        return new ProductOrder(id, ordersId, productsId, productsQuantity);
    }
    
    public static ProductOrder createProductOrder(int ordersId, int productsId, int productsQuantity) {
        return new ProductOrder(ordersId, productsId, productsQuantity);
    }

    @Override
    public String toString() {
        return "ProductOrder{" + 
                "id=" + id + 
                ", ordersId=" + ordersId + 
                ", productsId=" + productsId + 
                ", productsQuantity=" + productsQuantity + '}';
    }
}
