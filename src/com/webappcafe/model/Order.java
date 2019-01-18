package com.webappcafe.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private long id;
    private LocalDateTime date;
    private long customerId;
    private String status;
    private boolean isAvailable;
    private List<String> productsOfOrder;

    public Order() {
    }

    private Order(long id, LocalDateTime date, long customerId, String status, boolean isAvailable) {
        setId(id);
        setDate(date);
        setCustomerId(customerId);
        setStatus(status);
        setIsAvailable(isAvailable);
    }
    
    private Order(long customerId, String status, boolean isAvailable) {
        setCustomerId(customerId);
        setStatus(status);
        setIsAvailable(isAvailable);
    }
    
    private Order(long customerId, String status) {
        setCustomerId(customerId);
        setStatus(status);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public List<String> getProductsOfOrder() {
        return productsOfOrder;
    }

    public void setProductsOfOrder(List<String> productsOfOrder) {
        this.productsOfOrder = productsOfOrder;
    }

    public static Order createOrder(long id, LocalDateTime date, long customerId, String status, boolean isAvailable) {
        return new Order(id, date, customerId, status, isAvailable);
    }

    public static Order createOrder(long customerId, String status) {
        return new Order(customerId, status);
    }

    @Override
    public String toString() {
        return "Order{" + 
                "id=" + id + 
                ", date=" + date + 
                ", customerId=" + customerId + 
                ", status=" + status + 
                ", isAvailable=" + isAvailable + '}';
    }
}
