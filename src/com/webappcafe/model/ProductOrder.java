package com.webappcafe.model;

public class ProductOrder {
    private long id;
    private long ordersId;
    private long productsId;
    private int productsQuantity;

    public ProductOrder() {
    }
    
    private ProductOrder(long id, long ordersId, long productsId, int productsQuantity) {
        setId(id);
        setOrdersId(ordersId);
        setProductsId(productsId);
        setProductsQuantity(productsQuantity);
    }
    
    private ProductOrder(long ordersId, long productsId, int productsQuantity) {
        setOrdersId(ordersId);
        setProductsId(productsId);
        setProductsQuantity(productsQuantity);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(long ordersId) {
        this.ordersId = ordersId;
    }

    public long getProductsId() {
        return productsId;
    }

    public void setProductsId(long productsId) {
        this.productsId = productsId;
    }

    public int getProductsQuantity() {
        return productsQuantity;
    }

    public void setProductsQuantity(int productsQuantity) {
        this.productsQuantity = productsQuantity;
    }
    
    public static ProductOrder createProductOrder(long id, long ordersId, long productsId, int productsQuantity) {
        return new ProductOrder(id, ordersId, productsId, productsQuantity);
    }
    
    public static ProductOrder createProductOrder(long ordersId, long productsId, int productsQuantity) {
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
